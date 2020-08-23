package com.codeactuator.rocket.dto;


import com.codeactuator.rocket.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO implements Marshallable<Project, ProjectDTO> {

    private Long id;
    private String name;
    private Optional<Set<WorkforceDTO>> workforces = Optional.empty();


    @Override
    public Project marshall() {
        Project project = new Project();
        project.setId(this.getId());
        project.setName(this.getName());

        if(this.workforces.isPresent()){
            this.workforces.get()
                    .stream()
                    .map(workforceDTO -> workforceDTO.marshall())
                    .collect(Collectors.toSet());
        }
        return project;
    }

    @Override
    public void unmarshal(Project project) {
        this.setId(project.getId());
        this.setName(project.getName());

        Set<WorkforceDTO> workforceDTOS = project.getWorkforces()
                .stream()
                .map(workforce -> {
                    WorkforceDTO workforceDTO = new WorkforceDTO();
                    workforceDTO.unmarshal(workforce);
                    return workforceDTO;
                })
                .collect(Collectors.toSet());
        this.workforces = Optional.of(workforceDTOS);
    }
}
