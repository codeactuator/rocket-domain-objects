package com.codeactuator.rocket.dto;

import com.codeactuator.rocket.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO implements Marshallable<Task, TaskDTO>{


    private Long id;
    private String name;
    private TaskTypeDTO taskType;
    private WorkforceDTO assignee;
    private WorkforceDTO assignedBy;
    private Date createdOn;
    private TaskStatusDTO status;
    private Set<TaskDTO> subTasks;
    private Set<TaskLogDTO> logs;


    @Override
    public Task marshall() {
        Task task = new Task();
        task.setId(this.getId());
        task.setName(this.getName());

        if(this.getAssignee() != null){
            task.setAssignee(this.getAssignee().marshall());
        }

        if(this.assignedBy != null) {
            task.setAssignedBy(this.getAssignedBy().marshall());
        }

        task.setCreatedOn(this.getCreatedOn());

        if(this.getStatus() != null) {
            task.setStatus(this.getStatus().marshall());
        }


        //Setting Subtasks
        task.setSubTasks(this.subTasks.stream()
                .map(taskDTO -> {
                    return taskDTO.marshall();
                })
                .collect(Collectors.toSet())
        );


        //Setting TaskLogs
        task.setLogs(
                this.logs.stream()
                .map(taskLogDTO -> {
                    return taskLogDTO.marshall();
                })
                .collect(Collectors.toSet())
        );

        return task;
    }

    @Override
    public void unmarshal(Task task) {
        this.setId(task.getId());
        this.setName(task.getName());
        this.setCreatedOn(task.getCreatedOn());

        //Set assignedBy
        if(task.getAssignedBy() != null) {
            WorkforceDTO workforceDTO = new WorkforceDTO();
            workforceDTO.unmarshal(task.getAssignedBy());
            this.setAssignedBy(workforceDTO);
        }


        //Set assignee
        if(task.getAssignee() != null) {
            WorkforceDTO workforceDTO = new WorkforceDTO();
            workforceDTO.unmarshal(task.getAssignee());
            this.setAssignee(workforceDTO);
        }


        //Set taskLogs
        if(task.getLogs() != null) {
            this.setLogs(
                    task.getLogs()
                            .stream()
                            .map(taskLog -> {
                                TaskLogDTO taskLogDTO = new TaskLogDTO();
                                taskLogDTO.unmarshal(taskLog);
                                return taskLogDTO;
                            })
                            .collect(Collectors.toSet())
            );
        }


        if(task.getSubTasks() != null) {
            this.setSubTasks(
                    task.getSubTasks()
                            .stream()
                            .map(task1 -> {
                                TaskDTO taskDTO = new TaskDTO();
                                taskDTO.unmarshal(task1);
                                return taskDTO;
                            })
                            .collect(Collectors.toSet())
            );
        }


        //Set taskStatus
        if(task.getStatus() != null){
            TaskStatusDTO taskStatusDTO = new TaskStatusDTO();
            taskStatusDTO.unmarshal(task.getStatus());
            this.setStatus(taskStatusDTO);
        }

        //Set taskType
        if(task.getTaskType() != null){
            TaskTypeDTO taskTypeDTO = new TaskTypeDTO();
            taskTypeDTO.unmarshal(task.getTaskType());
            this.setTaskType(taskTypeDTO);
        }
    }
}
