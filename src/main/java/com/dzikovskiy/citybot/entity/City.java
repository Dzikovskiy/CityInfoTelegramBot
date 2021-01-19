package com.dzikovskiy.citybot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(length = 1500)
    private String citySights;

    public City(String name, String citySights) {
        this.name = name;
        this.citySights = citySights;
    }
}