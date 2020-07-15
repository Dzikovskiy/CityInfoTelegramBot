package com.dzikovskiy.cityBot.Entities;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(length = 1500)
    private String citySights;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitySights() {
        return citySights;
    }

    public void setCitySights(String citySights) {
        this.citySights = citySights;
    }
}