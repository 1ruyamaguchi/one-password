package com.example.onepassword.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.onepassword.dto.LoginDto;
import com.example.onepassword.dto.UserPasswordDto;
import com.example.onepassword.entity.UserInfo;
import com.example.onepassword.service.PasswordService;
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

    @Autowired
    private PasswordService passwordService;

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
    public String menu(@ModelAttribute("loginDto") LoginDto loginDto, Model model, HttpSession session) {

        // 正式なユーザでなければログインさせない
        // TODO エラーメッセージとか定義する
        if (!loginService.isValidUser(loginDto)) {
            return "page/login";
        }

        // ログイン情報取得
        UserInfo userInfo = loginService.getLoginUser(loginDto);
        // セッションにログイン情報を格納
        session.setAttribute("userId", userInfo.getUserId());

        return "page/menu";
    }

    /** メニュー画面から登録一覧画面 */
    @RequestMapping(value = "/onepassword-menu-allregist")
    public String allRegist(Model model, HttpSession session) {

        // ユーザIDに紐づいたtarget, passwordを全件取得
        List<UserPasswordDto> userPasswordDtos = passwordService.getUserPassword((int) session.getAttribute("userId"));
        // target, passwordのリストをmodelに格納
        model.addAttribute("userPasswordDtos", userPasswordDtos);

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
