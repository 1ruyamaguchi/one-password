package com.example.onepassword.dto;

import lombok.Data;

/**
 * 登録情報の詳細を管理するDto
 * 
 */
@Data
public class UserPasswordDetailDto {

    /** 登録システム名 */
    private String targetName;

    /** パスワード */
    private String targetPassword;

    /** 登録詳細 */
    private String targetInformation;

}
