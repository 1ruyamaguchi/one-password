package com.example.onepassword.dao;

import java.util.List;

import com.example.onepassword.entity.UserPassword;

/**
 * user_passwordに関するmapper
 * 
 */
public interface UserPasswordDao {

    /** 指定したuserIdのUserPasswordを全件取得する */
    public List<UserPassword> selectUserPassword(String userId);

    /** 指定したtargetPasswordIdからパスワードの詳細情報を取得する */
    public UserPassword selectUserPasswordByTargetPasswordId(String targetPasswordId);

}
