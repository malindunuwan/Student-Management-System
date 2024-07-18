package com.example.demo.Service;


import com.example.demo.Entity.UserDtls;

public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);

}
