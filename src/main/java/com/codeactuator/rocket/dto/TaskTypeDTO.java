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

    public static class Builder{

        private Long id;
        private String name;

        public Builder(String name){
            this.name = name;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public TaskTypeDTO build(){
            TaskTypeDTO taskTypeDTO = new TaskTypeDTO();
            taskTypeDTO.setId(this.id);
            taskTypeDTO.setName(this.name);

            return taskTypeDTO;
        }
    }
}
