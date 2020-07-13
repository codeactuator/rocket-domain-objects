package com.codeactuator.rocket.response;

import com.codeactuator.rocket.domain.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProjectResponse {

    private boolean error;
    private String errorCode;
    private String errorMessage;
    private Project project;
}
