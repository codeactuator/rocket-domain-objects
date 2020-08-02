package com.codeactuator.rocket.dto;


import com.codeactuator.rocket.domain.Project;
import com.codeactuator.rocket.domain.Workforce;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO implements Marshallable<Project, ProjectDTO> {

    private Long id;
    private String name;
    private Set<WorkforceDTO> resources;


    @Override
    public Project marshall() {
        Project project = new Project();
        project.setId(this.getId());
        project.setName(this.getName());

        project.setResources(this.resources
                .stream()
                .map(workforceDTO -> {
                    Workforce workforce = new Workforce();
                    workforceDTO.marshall();
                    return workforce;
                })
                .collect(Collectors.toSet())
        );
        return project;
    }

    @Override
    public void unmarshal(Project project) {
        this.setId(project.getId());
        this.setName(project.getName());
        this.resources = project.getResources()
                .stream()
                .map(workforce -> {
                    WorkforceDTO workforceDTO = new WorkforceDTO();
                    workforceDTO.unmarshal(workforce);
                    return workforceDTO;
                })
                .collect(Collectors.toSet());
    }
}
