package com.lucaspetros.dev.pagefriends.ui.feature.friends.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucaspetros.dev.pagefriends.R;
import com.lucaspetros.dev.pagefriends.databinding.FragmentMyFriendsBinding;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.adapter.FriendsAdapter;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.viewmodel.FriendsViewModel;


public class MyFriendsFragment extends Fragment {

    private FragmentMyFriendsBinding binding;
    private RecyclerView recyclerView;
    private FriendsAdapter adapter;
    private FriendsViewModel mViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMyFriendsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel  = new ViewModelProvider(requireActivity()).get(FriendsViewModel.class);
        configRecyclerView();
        mViewModel.getQntPages();
        refresh();

        mViewModel.pagesMutableLiveData.observe(getViewLifecycleOwner(), pages -> {
            mViewModel.getAllFriends(pages);

        });

        mViewModel.listAllFriendsDTOMutableLiveData.observe(getViewLifecycleOwner(), userList -> {
            if (userList.size() == 0){
                binding.txtMyFriends.setVisibility(View.GONE);
                binding.txtUserNotFound.setVisibility(View.VISIBLE);
            }else {
                binding.txtMyFriends.setVisibility(View.VISIBLE);
                binding.txtUserNotFound.setVisibility(View.GONE);
            }
            adapter = new FriendsAdapter(userList, getContext());
            recyclerView.setAdapter(adapter);

        });

        binding.edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mViewModel.getFriendsFilter(binding.edtSearch.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }

    private void refresh() {
        binding.swiperefresh.setOnRefreshListener(() -> {
                mViewModel.getAllFriends(mViewModel.getQntPage());
                binding.edtSearch.setText("");
                binding.swiperefresh.setRefreshing(false);
        });
    }

    private void configRecyclerView(){
        recyclerView = requireView().findViewById(R.id.rvFriends);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
    }
}