package com.example.onepassword.persistence;

import java.util.List;

import com.example.onepassword.entity.UserPassword;

/**
 * user_passwordに関するmapper
 * 
 */
public interface UserPasswordMapper {

    /** 指定したuserIdのUserPasswordを取得する */
    public List<UserPassword> selectUserPassword(int userId);

}
