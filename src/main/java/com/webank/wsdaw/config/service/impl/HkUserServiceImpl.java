package com.webank.wsdaw.config.service.impl;

import com.webank.wsdaw.config.dao.entity.HkUserEntity;
import com.webank.wsdaw.config.dao.mapper.HkUserMapper;
import com.webank.wsdaw.config.enums.CodeEnum;
import com.webank.wsdaw.config.service.EmailVerifyService;
import com.webank.wsdaw.config.service.HkUserService;
import com.webank.wsdaw.config.vo.request.HkEmailRequest;
import com.webank.wsdaw.config.vo.request.HkLoginRequest;
import com.webank.wsdaw.config.vo.request.HkRegisterRequest;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import com.webank.wsdaw.config.vo.response.HkTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HkUserServiceImpl implements HkUserService {
    @Autowired private HkUserMapper userMapper;
    @Autowired private EmailVerifyService emailVerifyService;

    @Override
    public CommonResponse<HkTokenResponse> register(HkRegisterRequest registerRequest) {
        if (userMapper.emailExists(registerRequest.getEmail())) {
            return CommonResponse.error(CodeEnum.EMAIL_EXIST_ERROR);
        }
        CommonResponse<String> verifyResult =
                emailVerifyService.verifyEmailCode(
                        registerRequest.getEmail(), registerRequest.getCode());
        if (!verifyResult.isSuccess()) {
            return CommonResponse.error(verifyResult.getCode(), verifyResult.getMsg());
        }
        HkUserEntity userEntity = new HkUserEntity();
        userEntity
                .setEmail(registerRequest.getEmail())
                .setCompany(registerRequest.getCompany())
                .setFirstName(registerRequest.getFirstName())
                .setLastName(registerRequest.getLastName())
                .setPhoneCode(registerRequest.getPhoneCode())
                .setPhoneNumber(registerRequest.getPhoneNumber());
        userMapper.insertUser(userEntity);
        HkTokenResponse hkTokenResponse = new HkTokenResponse();
        hkTokenResponse
                .setFirstName(registerRequest.getFirstName())
                .setLastName(registerRequest.getLastName());
        return CommonResponse.success(hkTokenResponse);
    }

    @Override
    public CommonResponse<HkTokenResponse> login(HkLoginRequest loginRequest) {
        HkUserEntity user = userMapper.getNormalUserByEmail(loginRequest.getEmail());
        if (user == null) {
            return CommonResponse.error(CodeEnum.USER_NOT_EXIST_ERROR);
        }
        CommonResponse<String> verifyResult =
                emailVerifyService.verifyEmailCode(loginRequest.getEmail(), loginRequest.getCode());
        if (!verifyResult.isSuccess()) {
            return CommonResponse.error(verifyResult.getCode(), verifyResult.getMsg());
        }
        HkTokenResponse hkTokenResponse = new HkTokenResponse();
        hkTokenResponse.setFirstName(user.getFirstName()).setLastName(user.getLastName());
        return CommonResponse.success(hkTokenResponse);
    }

    @Override
    public CommonResponse<Boolean> registerStatus(HkEmailRequest emailRequest) {
        HkUserEntity user = userMapper.getNormalUserByEmail(emailRequest.getEmail());
        if (user == null) {
            return CommonResponse.success(false);
        }
        return CommonResponse.success(true);
    }
}
