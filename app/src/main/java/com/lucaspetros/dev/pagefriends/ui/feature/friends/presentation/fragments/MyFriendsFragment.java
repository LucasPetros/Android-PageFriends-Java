package com.lucaspetros.dev.pagefriends.ui.feature.friends.presentation.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lucaspetros.dev.pagefriends.R;
import com.lucaspetros.dev.pagefriends.databinding.FragmentMyFriendsBinding;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.adapter.FriendsAdapter;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.viewmodel.FriendsViewModel;


public class MyFriendsFragment extends Fragment {

    private FragmentMyFriendsBinding binding = null;
    private RecyclerView recyclerView;
    private FriendsAdapter adapter;
    private FriendsViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentMyFriendsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(FriendsViewModel.class);

        configRecyclerView();
        binding.edtSearch.clearFocus();

        refresh();
        startLoadingAnimation();

        mViewModel.getQntPages();

        observerLoading();

        observerDataApi();

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

    private void observerDataApi() {
        mViewModel.listAllFriendsDTOMutableLiveData.observe(getViewLifecycleOwner(), userList -> {
            if (userList.size() == 0) {
                binding.txtMyFriends.setVisibility(View.GONE);
                binding.txtUserNotFound.setVisibility(View.VISIBLE);
            } else {
                binding.txtMyFriends.setVisibility(View.VISIBLE);
                binding.txtUserNotFound.setVisibility(View.GONE);
            }
            adapter = new FriendsAdapter(userList, getContext());
            recyclerView.setAdapter(adapter);

        });
    }

    private void observerLoading() {
        mViewModel.loading.observe(getViewLifecycleOwner(), loading -> {
            if (!loading) {
                stopLoadinAnimation();
            }
        });
    }

    private void startLoadingAnimation() {
        binding.cardShimmer.setVisibility(View.VISIBLE);
        binding.cardShimmer2.setVisibility(View.VISIBLE);
        binding.shimmerViewContainer1.startShimmer();
        binding.shimmerViewContainer2.startShimmer();
    }

    private void stopLoadinAnimation() {
        binding.shimmerViewContainer1.stopShimmer();
        binding.shimmerViewContainer2.stopShimmer();
        binding.cardShimmer.setVisibility(View.GONE);
        binding.cardShimmer2.setVisibility(View.GONE);
    }

    private void refresh() {
        binding.swiperefresh.setOnRefreshListener(() -> {
            mViewModel.getQntPages();
            binding.edtSearch.setText("");
            binding.swiperefresh.setRefreshing(false);
        });
    }

    private void configRecyclerView() {
        recyclerView = requireView().findViewById(R.id.rvFriends);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewModel.clearObservable();
        mViewModel.getQntPages();
        binding.edtSearch.setText("");
    }
}