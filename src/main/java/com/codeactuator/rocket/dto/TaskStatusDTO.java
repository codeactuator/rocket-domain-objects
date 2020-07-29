package com.codeactuator.rocket.dto;

import com.codeactuator.rocket.domain.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatusDTO implements Marshallable<TaskStatus, TaskStatusDTO> {

    private Long id;
    private String name;


    @Override
    public TaskStatus marshall() {
        TaskStatus taskStatus = new TaskStatus();
        taskStatus.setId(this.getId());
        taskStatus.setName(this.getName());
        return taskStatus;
    }

    @Override
    public void unmarshal(TaskStatus taskStatus) {
        this.setId(taskStatus.getId());
        this.setName(taskStatus.getName());
    }
}
