package com.example.onepassword.dto;

import lombok.Data;

/**
 * ログイン時の情報を格納するDto
 * 
 */
@Data
public class LoginDto {

    /** ユーザ名 */
    private String userName;

    /** パスワード */
    private String userPassword;

}
