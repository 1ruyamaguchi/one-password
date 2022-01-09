package com.example.onepassword.dto;

import lombok.Data;

/**
 * ユーザとパスワードを紐づけて管理するDto
 * 
 */
@Data
public class UserPasswordSummaryDto {

    /** 管理用ID */
    private Integer targetPasswordId;

    /** 対象システム名 */
    private String targetName;

}
