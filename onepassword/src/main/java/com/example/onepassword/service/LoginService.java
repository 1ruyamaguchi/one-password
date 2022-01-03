package com.example.onepassword.service;

import com.example.onepassword.dto.LoginDto;
import com.example.onepassword.entity.UserInfo;
import com.example.onepassword.persistence.UserInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ログインに関するサービスクラス
 * 
 */
@Service
public class LoginService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 正当なユーザであるか判定する
     * 
     * @param loginDto
     * @return
     */
    public boolean isValidUser(LoginDto loginDto) {

        // 返却値
        boolean gudge = false;

        // ユーザ情報を取得
        UserInfo userInfo = userInfoMapper.selectUserInfo(loginDto);
        // ユーザが存在するか判定
        if (userInfo != null) {
            gudge = true;
        }

        return gudge;
    }

    /**
     * ログイン情報を取得
     * 
     */
    public UserInfo getLoginUser(LoginDto loginDto) {

        // ユーザ情報を取得
        UserInfo userInfo = userInfoMapper.selectUserInfo(loginDto);

        return userInfo;
    }
}
