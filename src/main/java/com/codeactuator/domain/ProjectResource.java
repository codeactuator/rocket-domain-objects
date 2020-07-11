package com.codeactuator.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ProjectResource {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Workforce workforce;
    @OneToOne
    private Role designatedAs;
    private Date designatedOn;
    @ManyToOne
    private Workforce reportsTo;

    public ProjectResource(Workforce workforce, Role designatedAs, Date designatedOn, Workforce reportsTo) {
        this.workforce = workforce;
        this.designatedAs = designatedAs;
        this.designatedOn = designatedOn;
        this.reportsTo = reportsTo;
    }
}