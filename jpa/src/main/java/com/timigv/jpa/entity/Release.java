package com.timigv.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Release {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private String description;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "application_id")
    private List<Application> applications = new ArrayList<>();
}
