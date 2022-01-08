package com.example.onepassword.dto;

import lombok.Data;

/**
 * ユーザとパスワードを紐づけて管理するDto
 * 
 */
@Data
public class UserPasswordDto {

    /** ユーザID */
    private int userId;

    /** 対象システム名 */
    private String targetName;

    /** 対象システムパスワード */
    private String targetPassword;

    /** 対象システムの説明 */
    private String targetInformation;

}
