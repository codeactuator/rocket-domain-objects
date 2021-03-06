package com.codeactuator.rocket.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class TaskLog {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private float spentHrs;
    private Date createdDate;
}