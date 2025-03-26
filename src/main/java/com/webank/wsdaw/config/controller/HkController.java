package com.webank.wsdaw.config.controller;

import com.webank.wsdaw.config.service.EmailVerifyService;
import com.webank.wsdaw.config.service.impl.HkUserServiceImpl;
import com.webank.wsdaw.config.vo.request.*;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import com.webank.wsdaw.config.vo.response.HkTokenResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hk")
public class HkController {
    @Autowired private EmailVerifyService emailVerifyService;
    @Autowired private HkUserServiceImpl userService;

    @PostMapping("sendCode")
    public CommonResponse<String> hkSendCode(@RequestBody @Valid SendCodeRequest request)
            throws Exception {
        return emailVerifyService.sendVerificationCode(request.getEmail());
    }

    @PostMapping("verifyCode")
    public CommonResponse<String> hkVerifyCode(@RequestBody @Valid VerifyCodeRequest request)
            throws Exception {
        return emailVerifyService.verifyEmailCode(request.getEmail(), request.getCode());
    }

    @PostMapping("register")
    public CommonResponse<HkTokenResponse> hkRegister(@RequestBody @Valid HkRegisterRequest request)
            throws Exception {
        return userService.register(request);
    }

    @PostMapping("login")
    public CommonResponse<HkTokenResponse> hkLogin(@RequestBody @Valid HkLoginRequest request)
            throws Exception {
        return userService.login(request);
    }

    @PostMapping("registerStatus")
    public CommonResponse<Boolean> registerStatus(@RequestBody @Valid HkEmailRequest request)
            throws Exception {
        return userService.registerStatus(request);
    }
}
