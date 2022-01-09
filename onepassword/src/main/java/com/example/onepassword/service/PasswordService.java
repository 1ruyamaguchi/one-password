package com.example.onepassword.service;

import java.util.ArrayList;
import java.util.List;

import com.example.onepassword.dto.UserPasswordSummaryDto;
import com.example.onepassword.entity.UserPassword;
import com.example.onepassword.persistence.UserPasswordMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    @Autowired
    private UserPasswordMapper userPasswordMapper;

    /**
     * 指定したユーザのtarget, passwordを全件取得
     * 
     * @param userId
     * @return
     */
    public List<UserPasswordSummaryDto> getUserPassword(int userId) {

        // 返却値を定義
        List<UserPasswordSummaryDto> userPasswordSummaryDtos = new ArrayList<>();

        // DBから情報を取得
        List<UserPassword> userPasswordEntities = userPasswordMapper.selectUserPassword(userId);

        // 各UserPasswordエンティティを返却値のリストに格納
        for (UserPassword userPasswordEntity : userPasswordEntities) {
            UserPasswordSummaryDto userPasswordSummaryDto = new UserPasswordSummaryDto();
            BeanUtils.copyProperties(userPasswordEntity, userPasswordSummaryDto);
            userPasswordSummaryDtos.add(userPasswordSummaryDto);
        }

        return userPasswordSummaryDtos;
    }

}
