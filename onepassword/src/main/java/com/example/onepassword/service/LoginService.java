package com.example.onepassword.service;

import com.example.onepassword.dao.UserInfoDao;
import com.example.onepassword.dto.LoginDto;
import com.example.onepassword.entity.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
    public boolean isValidUser(LoginDto loginDto, BindingResult result) {

        // 返却値
        boolean judge = false;

        // 入力に不備があればエラー
        if (loginDto.getUserName() == "" || loginDto.getUserPassword() == "") {
            return judge;
        }
        // ユーザ情報が存在しなければエラー
        if (userInfoDao.selectUserInfo(loginDto) == null) {
            result.reject("notexist.user");
        }
        // ユーザが存在すればtrue
        if (!result.hasErrors()) {
            judge = true;
        }

        return judge;
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
