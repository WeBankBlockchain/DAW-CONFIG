package com.webank.wsdaw.config.service;

import com.webank.wsdaw.config.vo.response.CommonResponse;

public interface EmailVerifyService {
    CommonResponse<String> sendVerificationCode(String email);

    CommonResponse<String> verifyEmailCode(String email, String code);
}
