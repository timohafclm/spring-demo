package com.timigv.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "application")
@Data
public class Application {

    @Id
    @GeneratedValue()
    @Column(name = "application_id")
    private Long id;

    @Column(name = "app_name", nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    private String owner;
}
