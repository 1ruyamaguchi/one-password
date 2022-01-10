package com.example.onepassword.service;

import com.example.onepassword.dao.UserInfoDao;
import com.example.onepassword.dto.LoginDto;
import com.example.onepassword.entity.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ログインに関するサービスクラス
 * 
 */
@Service
public class LoginService {

    @Autowired
    private UserInfoDao userInfoDao;

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
        UserInfo userInfo = userInfoDao.selectUserInfo(loginDto);
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
        UserInfo userInfo = userInfoDao.selectUserInfo(loginDto);

        return userInfo;
    }
}
