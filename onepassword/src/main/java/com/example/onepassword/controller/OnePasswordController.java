package com.example.onepassword.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.onepassword.dto.LoginDto;
import com.example.onepassword.dto.UserPasswordDetailDto;
import com.example.onepassword.dto.UserPasswordSummaryDto;
import com.example.onepassword.entity.UserInfo;
import com.example.onepassword.service.PasswordService;
import com.example.onepassword.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 認証・パスワード閲覧機能のコントローラー
 * 
 */
@Controller
public class OnePasswordController {

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
    public String menu(@Validated @ModelAttribute("loginDto") LoginDto loginDto, BindingResult result, Model model,
            HttpSession session) {

        // 正式なユーザでなければログインさせない
        if (!loginService.isValidUser(loginDto, result)) {
            return "page/login";
        }

        // ログイン情報取得
        UserInfo userInfo = loginService.getLoginUser(loginDto);
        // セッションにログイン情報を格納
        session.setAttribute("userId", userInfo.getUserId());

        return "page/menu";
    }

    /** 登録一覧画面 */
    @RequestMapping(value = "/onepassword-menu-allregist")
    public String allRegist(Model model, HttpSession session) {

        // ユーザIDに紐づいたtarget, passwordを全件取得
        List<UserPasswordSummaryDto> userPasswordSummaryDtos = passwordService
                .getUserPasswordSummaryAll((String) session.getAttribute("userId"));
        // target, passwordのリストをmodelに格納
        model.addAttribute("userPasswordSummaryDtos", userPasswordSummaryDtos);

        return "page/allRegist";
    }

    /** 登録一覧画面からメニュー画面 */
    @RequestMapping(value = "/onepassword-return-menu")
    public String returnMenuFromAllRegist() {
        return "page/menu";
    }

    /** 詳細確認 */
    @RequestMapping(value = "/onepassword-menu-allregist-detail")
    public String detail(@ModelAttribute("targetPasswordId") String targetPasswordId, Model model) {

        // 与えられたtargetPasswordIdからパスワード詳細：UserPasswordDetailDtoを呼び出す処理
        UserPasswordDetailDto userPasswordDetailDto = passwordService
                .getUserPasswordDetailByTargetPasswordId(targetPasswordId);
        // パスワードの詳細情報をmodelに格納
        model.addAttribute("userPasswordDetailDto", userPasswordDetailDto);

        return "page/detail";
    }

    /** ログアウト */
    @RequestMapping(value = "/onepassword-logout")
    public String logout() {
        return "page/logout";
    }

}
