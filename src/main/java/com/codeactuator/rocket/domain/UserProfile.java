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
public class UserProfile {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public UserProfile(String name) {
        this.name = name;
    }
}