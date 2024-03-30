package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;
    private double price;
    private boolean sold;
    // Constructors, getters, and setters can be added here.
// Default constructor
    public Animal() {    }
    // Parameterized constructor
    public Animal(String name, String species, double price, boolean sold) {
        this.name = name;
        this.species = species;
        this.price = price;
        this.sold = sold;    }
    //Parameterized constructor 2
    public Animal(String name, String species, double price) {
        this.name = name;
        this.species = species;
        this.price = price;
        this.sold=false;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", price=" + price +
                ", sold=" + sold +
                '}';
    }
    // Getters and setters
    public Long getId() {        return id;    }

    public void setId(Long id) {        this.id = id;    }

    public String getName() {        return name;    }

    public void setName(String name) {        this.name = name;    }

    public String getSpecies() {        return species;    }

    public void setSpecies(String species) {
        this.species = species;    }

    public double getPrice() {        return price;    }

    public void setPrice(double price) {        this.price = price;    }

    public boolean isSold() {        return sold;    }

    public void setSold(boolean sold) {        this.sold = sold;    }
}