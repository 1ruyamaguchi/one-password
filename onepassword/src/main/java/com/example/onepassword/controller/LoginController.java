package com.example.onepassword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログイン機能のコントローラー
 * 
 */
@Controller
public class LoginController {

    /** ログイン画面 */
    @RequestMapping(value = "/onepassword")
    public String welcome() {
        return "page/login";
    }

    /** メニュー画面 */
    @RequestMapping(value = "/onepassword-menu")
    public String menu() {
        return "page/menu";
    }

    /** 登録一覧画面 */
    @RequestMapping(value = "/onepassword-menu-allregist")
    public String allRegist() {
        return "page/allRegist";
    }

    /** 登録内容確認 */
    @RequestMapping(value = "/onepassword-menu-allregist-detail")
    public String detail() {
        return "page/detail";
    }

    /** ログアウト */
    @RequestMapping(value = "/onepassword-logout")
    public String logout() {
        return "page/logout";
    }

}
