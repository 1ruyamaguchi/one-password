package com.example.onepassword.controller;

import com.example.onepassword.dto.LoginDto;
import com.example.onepassword.entity.UserInfo;
import com.example.onepassword.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO 各htmlの投げるURLがおかしい可能性あり。横着した。
/**
 * ログイン機能のコントローラー
 * 
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ModelAttribute(value = "loginDto")
    public LoginDto loginDto() {
        return new LoginDto();
    }

    /** ログイン画面 */
    @RequestMapping(value = "/onepassword")
    public String welcome() {
        return "page/login";
    }

    /** ログイン画面からメニュー画面 */
    @RequestMapping(value = "/onepassword-menu")
    public String menu(@ModelAttribute("loginDto") LoginDto loginDto, Model model) {

        // 正式なユーザでなければログインさせない
        // TODO エラーメッセージとか定義する
        if (!loginService.isValidUser(loginDto)) {
            return "page/login";
        }

        // ログイン情報取得
        UserInfo userInfo = loginService.getLoginUser(loginDto);
        // modelにログイン情報を格納
        model.addAttribute("userInfo", userInfo);

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
