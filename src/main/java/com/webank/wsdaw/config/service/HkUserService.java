package com.webank.wsdaw.config.service;

import com.webank.wsdaw.config.vo.request.HkEmailRequest;
import com.webank.wsdaw.config.vo.request.HkLoginRequest;
import com.webank.wsdaw.config.vo.request.HkRegisterRequest;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import com.webank.wsdaw.config.vo.response.HkTokenResponse;

public interface HkUserService {
    public CommonResponse<HkTokenResponse> register(HkRegisterRequest registerRequest);

    public CommonResponse<HkTokenResponse> login(HkLoginRequest loginRequest);

    CommonResponse<Boolean> registerStatus(HkEmailRequest emailRequest);
}
