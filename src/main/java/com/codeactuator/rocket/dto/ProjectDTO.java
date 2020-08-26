package com.codeactuator.rocket.dto;


import com.codeactuator.rocket.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
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
    private Optional<Set<TaskDTO>> tasks = Optional.empty();

    public static class Builder {

        private Long id;
        private String name;
        private Optional<Set<WorkforceDTO>> workforces = Optional.empty();
        private Optional<Set<TaskDTO>> tasks = Optional.empty();

        public Builder(String name){
            this.name = name;
        }

        public Builder workforce(WorkforceDTO workforceDTO){
            workforces.get().add(workforceDTO);
            if(workforces.isPresent()) {
                workforces.get().add(workforceDTO);
            }else {
                Set<WorkforceDTO> taskSet = new HashSet<>();
                taskSet.add(workforceDTO);
                workforces = Optional.of(taskSet);
            }

            return this;
        }

        public Builder workforces(Set<WorkforceDTO> workforceDTOS){
            workforces = Optional.of(workforceDTOS);
            return this;
        }

        public Builder task(TaskDTO taskDTO){
            if(tasks.isPresent()) {
                tasks.get().add(taskDTO);
            }else {
                Set<TaskDTO> taskSet = new HashSet<>();
                taskSet.add(taskDTO);
                tasks = Optional.of(taskSet);
            }
            return this;
        }

        public Builder tasks(Set<TaskDTO> taskDTOS){
            tasks = Optional.of(taskDTOS);
            return this;
        }

        public ProjectDTO build(){
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setName(this.name);
            projectDTO.setWorkforces(this.workforces);
            projectDTO.setTasks(this.tasks);

            return projectDTO;
        }
    }


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

        if(this.tasks.isPresent()){
            project.setTasks(
                    this.tasks.get()
                    .stream()
                    .map(taskDTO -> taskDTO.marshall())
                    .collect(Collectors.toSet())
            );

        }
        return project;
    }

    @Override
    public void unmarshal(Project project) {
        this.setId(project.getId());
        this.setName(project.getName());

        if (project.getWorkforces() != null){
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

        if(project.getTasks() != null) {
            Set<TaskDTO> taskDTOS = project.getTasks()
                    .stream()
                    .map(task -> {
                        TaskDTO taskDTO = new TaskDTO();
                        taskDTO.unmarshal(task);
                        return taskDTO;
                    })
                    .collect(Collectors.toSet());
            this.tasks = Optional.of(taskDTOS);
        }
    }
}
