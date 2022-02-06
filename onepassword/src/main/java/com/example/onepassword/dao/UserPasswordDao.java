package com.example.onepassword.dao;

import java.util.List;

import com.example.onepassword.entity.UserPassword;
import com.example.onepassword.mapper.UserPasswordMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * user_passwordテーブルのdaoクラス
 * 
 */
@Component
public class UserPasswordDao {

    @Autowired
    private UserPasswordMapper userPasswordMapper;

    /**
     * 指定したuserIdのUserPasswordを全件取得する
     * 
     */
    public List<UserPassword> selectUserPassword(String userId) {
        return userPasswordMapper.selectUserPassword(userId);
    }

    /**
     * 指定したtargetPasswordIdからパスワードの詳細情報を取得する
     * 
     */
    public UserPassword selectUserPasswordByTargetPasswordId(String targetPasswordId) {
        return userPasswordMapper.selectUserPasswordByTargetPasswordId(targetPasswordId);
    }

    /**
     * パスワードの新規登録
     * 
     */
    public void insertPasswordRegist(UserPassword userPassword) {
        userPasswordMapper.insertPasswordRegist(userPassword);
    }

}
