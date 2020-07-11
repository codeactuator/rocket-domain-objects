package com.codeactuator.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany
    private Set<ProjectResource> resources;
    private Date created;

    public Project(String name){
        this.name = name;
    }

    public void addResource(ProjectResource resource){
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