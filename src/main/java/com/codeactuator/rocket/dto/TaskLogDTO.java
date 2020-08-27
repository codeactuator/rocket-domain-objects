package com.codeactuator.rocket.dto;

import com.codeactuator.rocket.domain.TaskLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskLogDTO implements Marshallable<TaskLog, TaskLogDTO> {

    private Long id;
    private String description;
    private float spentHrs;
    private Date createdDate;

    @Override
    public TaskLog marshall() {
        TaskLog taskLog = new TaskLog();
        taskLog.setId(this.getId());
        taskLog.setDescription(this.getDescription());
        taskLog.setSpentHrs(this.getSpentHrs());
        taskLog.setCreatedDate(this.getCreatedDate());
        return taskLog;
    }

    @Override
    public void unmarshal(TaskLog taskLog) {
        this.setId(taskLog.getId());
        this.setDescription(taskLog.getDescription());
        this.setSpentHrs(taskLog.getSpentHrs());
        this.setCreatedDate(taskLog.getCreatedDate());
    }


    public static class Builder {

        private Long id;
        private String description;
        private float spentHrs;
        private Date createdDate;

        public Builder(float spentHrs){
            this.spentHrs = spentHrs;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }



    }


}
