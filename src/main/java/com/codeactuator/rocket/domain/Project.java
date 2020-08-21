package com.codeactuator.rocket.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private Set<Task> tasks;
    @OneToMany
    private Set<Workforce> workforces;
    private Date created;

    public Project(String name){
        this.name = name;
    }

    public void addResource(Workforce workforce){
        if(workforces == null){
            workforces = new HashSet<>();
        }
        workforces.add(workforce);
    }

    public void addTask(Task task){
        if(tasks == null){
            tasks = new HashSet<>();
        }
        tasks.add(task);
    }

}