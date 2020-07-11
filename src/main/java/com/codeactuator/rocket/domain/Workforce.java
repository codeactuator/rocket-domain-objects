package com.codeactuator.rocket.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Workforce {

    @Id
    @GeneratedValue
    private Long id;
    private String employeeCode;
    private String name;
    private String email;
    @OneToOne
    private Role role;

    public Workforce(String employeeCode, String name, String email, Role role) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.email = email;
        this.role = role;
    }
}