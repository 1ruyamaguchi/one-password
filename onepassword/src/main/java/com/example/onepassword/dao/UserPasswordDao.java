package com.example.onepassword.dao;

import java.util.List;

import com.example.onepassword.entity.UserPassword;

/**
 * user_passwordに関するmapper
 * 
 */
public interface UserPasswordDao {

    /** 指定したuserIdのUserPasswordを取得する */
    public List<UserPassword> selectUserPassword(int userId);

}
