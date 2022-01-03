package com.example.onepassword.entity;

import lombok.Data;

/**
 * user_infoのエンティティクラス
 * 
 */
@Data
public class UserInfo {

    /** user_id */
    private int userId;

    /** user_name */
    private String userName;

    /** user_password */
    private String userPassword;

}
