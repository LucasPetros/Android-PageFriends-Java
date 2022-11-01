package com.lucaspetros.dev.pagefriends.ui.utils;

import android.widget.ImageView;

public class Picasso {

    public static void picasso(ImageView imgView, String imgUrl) {
        com.squareup.picasso.Picasso.get()
                .load(imgUrl)
                .resize(50, 50)
                .centerCrop()
                .into(imgView);

    }

}
