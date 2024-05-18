package com.og.co2data.model;

import jakarta.inject.Named;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "`co2-data-tmp`")
@Named(value = "co2datatmp")
public class CO2DataTmp implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String country;
    @Column(name = "\"year\"")
    private Integer year;
    @Column
    private String co2;

    public CO2DataTmp() {
    }

    @Override
    public String toString() {
        return "CO2_Data_Tmp{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", co2='" + co2 + '\'' +
                '}';
    }

    public CO2DataTmp(String country, Integer year, String co2) {
        this.country = country;
        this.year = year;
        this.co2 = co2;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }
}

