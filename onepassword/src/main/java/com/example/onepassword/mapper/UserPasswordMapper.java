package com.example.onepassword.mapper;

import java.util.List;

import com.example.onepassword.entity.UserPassword;

import org.springframework.stereotype.Component;

/**
 * user_passwordに関するmapper
 * 
 */
@Component
public interface UserPasswordMapper {

    /**
     * 指定したuserIdのUserPasswordを全件取得する
     * 
     */
    List<UserPassword> selectUserPassword(String userId);

    /**
     * 指定したtargetPasswordIdからパスワードの詳細情報を取得する
     * 
     */
    UserPassword selectUserPasswordByTargetPasswordId(String targetPasswordId);

    /**
     * パスワードの新規登録
     * 
     */
    void insertPasswordRegist(UserPassword userPassword);

}
