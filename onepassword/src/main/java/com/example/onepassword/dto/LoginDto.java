package com.example.onepassword.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * ログイン時の情報を格納するDto
 * 
 */
@Data
public class LoginDto {

    /** ユーザ名 */
    @NotEmpty
    private String userName;

    /** パスワード */
    @NotEmpty
    private String userPassword;

}
