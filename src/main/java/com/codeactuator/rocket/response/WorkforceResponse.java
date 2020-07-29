package com.codeactuator.rocket.response;

import com.codeactuator.rocket.dto.WorkforceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkforceResponse {

    private boolean error;
    private String errorCode;
    private String errorMessage;
    private WorkforceDTO projectDTO;
}
