package com.example.onepassword.mapper;

import com.example.onepassword.dto.LoginDto;
import com.example.onepassword.entity.UserInfo;

import org.springframework.stereotype.Component;

/**
 * user_infoテーブルに関するmapper
 * 
 */
@Component
public interface UserInfoMapper {

    /** LoginDtoに一致するユーザ情報を取得する */
    UserInfo selectUserInfo(LoginDto loginDto);

}
