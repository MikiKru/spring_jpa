package com.example.jpa_into.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity             // mapowanie obiektu na encję
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer autoId;
    private String brand;
    private String model;
    private Double price;

    public Auto(String brand, String model, Double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
}
