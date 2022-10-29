package com.lucaspetros.dev.pagefriends.data.model;


import com.lucaspetros.dev.pagefriends.data.model.response.UserResponse;

public class UserDTO {
    private final int id;
    private final String email;
    private final String name;
    private final String lastName;
    private final String avatar;


    public UserDTO(UserResponse userResponse) {
        this.id = userResponse.user.id;
        this.email = userResponse.user.email;
        this.name = userResponse.user.name;
        this.lastName = userResponse.user.lastName;
        this.avatar = userResponse.user.avatar;

    }

    public int getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public String getAvatar() {
        return avatar;
    }

}
