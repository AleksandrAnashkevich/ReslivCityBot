package com.resliv.city_bot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

}
