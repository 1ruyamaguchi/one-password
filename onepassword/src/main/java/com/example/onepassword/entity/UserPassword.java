package com.example.onepassword.entity;

import lombok.Data;

/**
 * user_passwordのエンティティクラス
 * 
 */
@Data
public class UserPassword {

    /** 管理用ID */
    private Integer targetPasswordId;

    /** ユーザID */
    private Integer userId;

    /** 対象システム名 */
    private String targetName;

    /** 対象システムパスワード */
    private String targetPassword;

    /** 対象システムの説明 */
    private String targetInformation;

}
