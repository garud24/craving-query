package com.cravingquery.cravingquery.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "restaurants")
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="zipcode")
    private String zipcode;

    @Column(name="country")
    private String country;

    @Column(name = "cuisines")
    private String cuisines;

    @Column(name="pickup_enabled")
    private boolean pickupEnabled;

    @Column(name="delivery_enabled")
    private boolean deliveryEnabled;

    @Column(name="weighted_rating_value")
    private BigDecimal weightedRatingValue;

    @Column(name="aggregated_rating_count")
    private int aggregatedRatingCount;

    public Restaurant(){}

    public Restaurant( Long id, String name, String city, String state, String zipcode, String country, String cuisines, boolean pickupEnabled, boolean deliveryEnabled, BigDecimal weightedRatingValue, int aggregatedRatingCount)
    {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.cuisines = cuisines;
        this.pickupEnabled = pickupEnabled;
        this.deliveryEnabled = deliveryEnabled;
        this.weightedRatingValue = weightedRatingValue;
        this.aggregatedRatingCount = aggregatedRatingCount;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public boolean isPickupEnabled() {
        return pickupEnabled;
    }

    public void setPickupEnabled(boolean pickupEnabled) {
        this.pickupEnabled = pickupEnabled;
    }

    public boolean isDeliveryEnabled() {
        return deliveryEnabled;
    }

    public void setDeliveryEnabled(boolean deliveryEnabled) {
        this.deliveryEnabled = deliveryEnabled;
    }

    public BigDecimal getWeightedRatingValue() {
        return weightedRatingValue;
    }

    public void setWeightedRatingValue(BigDecimal weightedRatingValue) {
        this.weightedRatingValue = weightedRatingValue;
    }

    public int getAggregatedRatingCount() {
        return aggregatedRatingCount;
    }

    public void setAggregatedRatingCount(int aggregatedRatingCount) {
        this.aggregatedRatingCount = aggregatedRatingCount;
    }



}
