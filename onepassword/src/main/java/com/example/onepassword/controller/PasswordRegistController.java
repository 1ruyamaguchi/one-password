package com.example.onepassword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PasswordRegistController {

    /** パスワード新規登録 */
    @RequestMapping(value = "/onepassword-password-regist")
    public String passwordRegist() {
        return "passwordRegist/input";
    }

    /** パスワード新規登録画面から確認画面 */
    @RequestMapping(value = "onepassword-password-regist-confirm")
    public String passwordRegistConfirm() {
        return "passwordRegist/confirm";
    }

    /** 確認画面からパスワード新規登録画面 */
    @RequestMapping(value = "/onepassword-password-return-input")
    public String returnPasswordRegistFromConfirm() {
        return "passwordRegist/input";
    }

    /** 確認画面から完了画面 */
    @RequestMapping(value = "/onepassword-password-regist-determine")
    public String passwordRegistDetermine() {
        return "passwordRegist/determine";
    }

}
