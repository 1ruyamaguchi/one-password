package com.example.onepassword.controller;

import javax.servlet.http.HttpSession;

import com.example.onepassword.dto.PasswordRegistInputDto;
import com.example.onepassword.service.PasswordRegistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("passwordRegistInputDto")
public class PasswordRegistController {

    @Autowired
    private PasswordRegistService passwordRegistService;

    @ModelAttribute(value = "passwordRegistInputDto")
    public PasswordRegistInputDto passwordRegistInputDto() {
        return new PasswordRegistInputDto();
    }

    /** パスワード新規登録 */
    @RequestMapping(value = "/onepassword-password-regist")
    public String passwordRegist() {
        return "passwordRegist/input";
    }

    /** パスワード新規登録画面から確認画面 */
    @RequestMapping(value = "onepassword-password-regist-confirm")
    public String passwordRegistConfirm(
            @ModelAttribute("passwordRegistInputDto") PasswordRegistInputDto passwordRegistInputDto, Model model) {

        // TODO 入力情報のバリデーション

        // 入力された情報をモデルに格納
        model.addAttribute("passwordRegistInputDto", passwordRegistInputDto);

        return "passwordRegist/confirm";
    }

    /** 確認画面からパスワード新規登録画面 */
    @RequestMapping(value = "/onepassword-password-return-input")
    public String returnPasswordRegistFromConfirm() {
        return "passwordRegist/input";
    }

    /** 確認画面から完了画面 */
    @RequestMapping(value = "/onepassword-password-regist-determine")
    public String passwordRegistDetermine(
            @ModelAttribute("passwordRegistInputDto") PasswordRegistInputDto passwordRegistInputDto,
            HttpSession session) {

        // パスワード登録処理
        passwordRegistService.insertPasswordRegist(passwordRegistInputDto, (String) session.getAttribute("userId"));

        return "passwordRegist/determine";
    }

}
