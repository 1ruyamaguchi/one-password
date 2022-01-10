package com.example.onepassword.dto;

import lombok.Data;

/**
 * パスワードIDとシステム名を管理するDto
 * 
 */
@Data
public class UserPasswordSummaryDto {

    /** 管理用ID */
    private String targetPasswordId;

    /** 対象システム名 */
    private String targetName;

}
