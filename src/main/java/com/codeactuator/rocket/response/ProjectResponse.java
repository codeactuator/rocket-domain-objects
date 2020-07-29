package com.codeactuator.rocket.response;

import com.codeactuator.rocket.dto.ProjectDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectResponse {

    private boolean error;
    private String errorCode;
    private String errorMessage;
    private ProjectDTO projectDTO;
}
