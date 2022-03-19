package com.tuhin.springboot.overflow.q71522210;

import javax.persistence.*;

@Entity
@Table(name = "db_restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String restaurant;
    private String address;
    private String website;
    private String description;
    private Integer count;



    public Restaurant() {
    }

    public Restaurant(Long id, String restaurant, String address, String website, String description, Integer count) {
        this.id = id;
        this.restaurant = restaurant;
        this.address = address;
        this.website = website;
        this.description = description;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }



}