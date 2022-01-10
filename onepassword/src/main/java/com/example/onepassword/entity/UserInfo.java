package com.example.onepassword.entity;

import lombok.Data;

/**
 * user_infoのエンティティクラス
 * 
 */
@Data
public class UserInfo {

    /** 管理用ID */
    private String userId;

    /** ユーザ名 */
    private String userName;

    /** システムログイン用パスワード */
    private String userPassword;

}
