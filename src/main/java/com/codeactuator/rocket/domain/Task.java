package com.codeactuator.rocket.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private TaskType taskType;
    @OneToOne
    private Workforce assignee;
    @OneToOne
    private Workforce assignedBy;
    private Date createdOn;
    @OneToOne
    private TaskStatus status;
    @OneToMany
    private Set<Task> subTasks;
    @OneToMany
    private Set<TaskLog> logs;
}