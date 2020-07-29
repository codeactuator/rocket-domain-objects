package com.codeactuator.rocket.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workforce {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @OneToOne
    private UserProfile userProfile;

}