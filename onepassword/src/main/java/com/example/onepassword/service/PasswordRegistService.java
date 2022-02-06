package com.example.onepassword.service;

import com.example.onepassword.dao.UserPasswordDao;
import com.example.onepassword.dto.PasswordRegistInputDto;
import com.example.onepassword.entity.UserPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

/**
 * パスワード新規登録のサービスクラス
 * 
 */
@Service
public class PasswordRegistService {

    @Autowired
    private UserPasswordDao userPasswordDao;

    /**
     * パスワードの新規登録
     * 
     * @param passwordRegistInputDto
     */
    @Transactional
    public void insertPasswordRegist(PasswordRegistInputDto passwordRegistInputDto, String userId) {

        // 登録内容を詰め込む
        UserPassword userPassword = new UserPassword();
        userPassword.setUserId(userId);
        userPassword.setTargetName(passwordRegistInputDto.getTargetName());
        userPassword.setTargetPassword(passwordRegistInputDto.getTargetPassword());
        userPassword.setTargetInformation(passwordRegistInputDto.getTargetInformation());

        // DBに登録
        userPasswordDao.insertPasswordRegist(userPassword);
    }

    /**
     * 正しいパスワードか判定
     * 
     * @param passwordRegistInputDto
     * @param result
     * @return
     */
    public boolean isValidPasswordRegist(PasswordRegistInputDto passwordRegistInputDto, BindingResult result) {

        // 返却値
        boolean judge = false;

        // 「パスワード」と「パスワード（確認用）」が一致しなければエラー
        if (!passwordRegistInputDto.getTargetPassword().equals(passwordRegistInputDto.getTargetPasswordConfirm())) {
            result.reject("notequal.password.passwordconfirm");
        }
        // 正しい登録内容であればtrue
        if (!result.hasErrors()) {
            judge = true;
        }

        return judge;
    }

}
