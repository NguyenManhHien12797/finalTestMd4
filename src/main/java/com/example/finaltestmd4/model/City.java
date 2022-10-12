package com.example.finaltestmd4.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String national;
    private int area;
    private int population;
    private String GDP;
    private String dicription;

    public City() {
    }

    public City(Long id, String name, String national, int area, int population, String GDP, String dicription) {
        this.id = id;
        this.name = name;
        this.national = national;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.dicription = dicription;
    }

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

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }

    public String getDicription() {
        return dicription;
    }

    public void setDicription(String dicription) {
        this.dicription = dicription;
    }
}
