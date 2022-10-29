package com.lucaspetros.dev.pagefriends.ui.feature.friends.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lucaspetros.dev.pagefriends.data.model.User;
import com.lucaspetros.dev.pagefriends.databinding.LayoutAdapterMyListFriendsBinding;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.MyViewHolder> {

    private List<User> userList;
    private Context context;

    public FriendsAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(
                LayoutAdapterMyListFriendsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private LayoutAdapterMyListFriendsBinding binding;

        public MyViewHolder(@NonNull LayoutAdapterMyListFriendsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }
    }

}



