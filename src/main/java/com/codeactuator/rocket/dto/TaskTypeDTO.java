package com.codeactuator.rocket.dto;

import com.codeactuator.rocket.domain.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTypeDTO implements Marshallable<TaskType, TaskTypeDTO> {

    private Long id;
    private String name;

    @Override
    public TaskType marshall() {
        TaskType taskType = new TaskType();
        taskType.setId(this.getId());
        taskType.setName(this.getName());
        return taskType;
    }

    @Override
    public void unmarshal(TaskType taskType) {
        this.setId(taskType.getId());
        this.setName(taskType.getName());
    }
}
