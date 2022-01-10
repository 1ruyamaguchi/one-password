package com.example.onepassword.service;

import java.util.ArrayList;
import java.util.List;

import com.example.onepassword.dao.UserPasswordDao;
import com.example.onepassword.dto.UserPasswordDetailDto;
import com.example.onepassword.dto.UserPasswordSummaryDto;
import com.example.onepassword.entity.UserPassword;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    @Autowired
    private UserPasswordDao userPasswordDao;

    /**
     * 指定したユーザのtarget, passwordを全件取得
     * 
     * @param userId
     * @return
     */
    public List<UserPasswordSummaryDto> getUserPasswordSummaryAll(String userId) {

        // 返却値を定義
        List<UserPasswordSummaryDto> userPasswordSummaryDtos = new ArrayList<>();

        // DBから情報を取得
        List<UserPassword> userPasswordEntities = userPasswordDao.selectUserPassword(userId);

        // 各UserPasswordエンティティを返却値のリストに格納
        for (UserPassword userPasswordEntity : userPasswordEntities) {
            UserPasswordSummaryDto userPasswordSummaryDto = new UserPasswordSummaryDto();
            BeanUtils.copyProperties(userPasswordEntity, userPasswordSummaryDto);
            userPasswordSummaryDtos.add(userPasswordSummaryDto);
        }

        return userPasswordSummaryDtos;
    }

    /**
     * パスワードIDからパスワード詳細情報を取得
     * 
     * @param userId
     * @return
     */
    public UserPasswordDetailDto getUserPasswordDetailByTargetPasswordId(String targetPasswordId) {

        // 返却値を定義
        UserPasswordDetailDto userPasswordDetailDto = new UserPasswordDetailDto();

        // DBから情報取得
        UserPassword userPassword = userPasswordDao.selectUserPasswordByTargetPasswordId(targetPasswordId);

        // DBからの情報を返却値に格納
        BeanUtils.copyProperties(userPassword, userPasswordDetailDto);

        return userPasswordDetailDto;
    }

}
