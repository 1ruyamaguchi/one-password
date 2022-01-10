package com.example.onepassword.dao;

import com.example.onepassword.dto.LoginDto;
import com.example.onepassword.entity.UserInfo;

/**
 * user_infoテーブルに関するmapper
 * 
 */
public interface UserInfoDao {

    /** LoginDtoに一致するユーザ情報を取得する */
    public UserInfo selectUserInfo(LoginDto loginDto);

}
