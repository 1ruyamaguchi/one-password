package com.example.onepassword.persistence;

import com.example.onepassword.dto.LoginDto;

/**
 * user_infoテーブルに関するmapper
 * 
 */
public interface UserInfoMapper {

    /** LoginDtoに一致するユーザ情報を取得する */
    public void selectUserInfo(LoginDto loginDto);

}
