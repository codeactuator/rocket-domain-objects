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
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    private Set<Task> tasks;
    @ElementCollection
    private Set<Workforce> resources;
    private Date created;

    public Project(String name){
        this.name = name;
    }

    public void addResource(Workforce resource){
        if(resources == null){
            resources = new HashSet<>();
        }
        resources.add(resource);
    }

    public void addTask(Task task){
        if(tasks == null){
            tasks = new HashSet<>();
        }
        tasks.add(task);
    }

}