package com.lucaspetros.dev.pagefriends.ui.feature.friends.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lucaspetros.dev.pagefriends.data.model.response.dto.FriendsDTO;
import com.lucaspetros.dev.pagefriends.data.model.User;
import com.lucaspetros.dev.pagefriends.databinding.LayoutAdapterMyListFriendsBinding;
import com.lucaspetros.dev.pagefriends.ui.utils.Picasso;

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
                LayoutAdapterMyListFriendsBinding.inflate(LayoutInflater.from(context), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = userList.get(position);
        holder.binding.tvEmailUser.setText(user.email);
        holder.binding.tvNameUser.setText(user.firstName + " " + user.lastName);
        Picasso.picasso(holder.binding.ivAvatar, user.avatar);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LayoutAdapterMyListFriendsBinding binding;

        public MyViewHolder(@NonNull LayoutAdapterMyListFriendsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }
    }

}



