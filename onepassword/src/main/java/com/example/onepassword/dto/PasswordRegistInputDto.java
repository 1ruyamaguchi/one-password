package com.example.onepassword.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * パスワード新規登録時の入力Dto
 * 
 */
@Data
public class PasswordRegistInputDto {

    /** 対象システム名 */
    @NotEmpty
    private String targetName;

    /** 対象システムパスワード */
    @NotEmpty
    private String targetPassword;

    /** 対象システムパスワード確認用 */
    @NotEmpty
    private String targetPasswordConfirm;

    /** 対象システムの説明 */
    private String targetInformation;

}
