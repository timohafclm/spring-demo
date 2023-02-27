package com.timigv.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @ManyToOne
    @JoinTable(name = "ticket_release",
            joinColumns = @JoinColumn(name = "ticket_fk"),
            inverseJoinColumns = @JoinColumn(name = "release_fk"))
    private Release release;

    private String status;
}
