package com.example.onepassword.dao;

import com.example.onepassword.dto.LoginDto;
import com.example.onepassword.entity.UserInfo;
import com.example.onepassword.mapper.UserInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * user_infoテーブルのdaoクラス
 * 
 */
@Component
public class UserInfoDao {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * LoginDtoに一致するユーザ情報を取得する
     * 
     */
    public UserInfo selectUserInfo(LoginDto loginDto) {
        return userInfoMapper.selectUserInfo(loginDto);
    }

}
