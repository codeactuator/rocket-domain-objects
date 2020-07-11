package com.codeactuator.rocket.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class TaskType {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
}