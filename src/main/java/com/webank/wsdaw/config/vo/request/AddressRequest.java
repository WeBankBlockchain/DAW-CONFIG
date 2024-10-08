package com.webank.wsdaw.config.vo.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddressRequest extends CommonRequest {
    @NotBlank(message = "address不能为空.")
    private String address;
}
