package com.example.test.model;

import javax.persistence.*;

@Entity
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int area;
    private int population;
    private int gdp1;
    private String describe1;

    @ManyToOne
    @JoinColumn(name="nation_id")
    private Nation nation;

    public City() {
    }

    public City(String name, int area, int population, int gdp1, String describe1, Nation nation) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp1 = gdp1;
        this.describe1 = describe1;
        this.nation = nation;
    }

    public City(Long id, String name, int area, int population, int gdp1, String describe1, Nation nation) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp1 = gdp1;
        this.describe1 = describe1;
        this.nation = nation;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
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

    public int getGdp1() {
        return gdp1;
    }

    public void setGdp1(int gdp1) {
        this.gdp1 = gdp1;
    }

    public String getDescribe1() {
        return describe1;
    }

    public void setDescribe1(String describe) {
        this.describe1 = describe;
    }
}
