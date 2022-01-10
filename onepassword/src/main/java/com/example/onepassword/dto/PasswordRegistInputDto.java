package com.example.onepassword.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * パスワード新規登録時の入力Dto
 * 
 */
@Data
public class PasswordRegistInputDto {

    /** 対象システム名 */
    @NotNull
    private String targetName;

    /** 対象システムパスワード */
    @NotNull
    private String targetPassword;

    /** 対象システムパスワード確認用 */
    @NotNull
    private String targetPasswordConfirm;

    /** 対象システムの説明 */
    private String targetInformation;

}
