package com.cravingquery.cravingquery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cravingquery.cravingquery.dto.RestaurantResponse;
import com.cravingquery.cravingquery.entity.Restaurant;
import com.cravingquery.cravingquery.repository.RestaurantRepository;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public RestaurantResponse getRestaurantById(Long id) {
        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Restaurant not found with id " + id));

        return toResponse(restaurant);

    }

    private RestaurantResponse toResponse(Restaurant r) {
        return new RestaurantResponse(
                r.getId(),
                r.getName(),
                r.getCity(),
                r.getState(),
                r.getZipcode(),
                r.getCountry(),
                parseCuisines(r.getCuisines()),
                r.isPickupEnabled(),
                r.isDeliveryEnabled(),
                r.getWeightedRatingValue(),
                r.getAggregatedRatingCount());
    }

    private List<String> parseCuisines(String cuisines) {
        if (cuisines == null || cuisines.isBlank()) {
            return List.of();
        }

        List<String> result = new ArrayList<>();

        for (String c : cuisines.split(",")) {
            String trimmed = c.trim();
            if (!trimmed.isEmpty()) {
                result.add(trimmed);
            }
        }

        return result;
    }

    public List<RestaurantResponse> getRestaurantByState(String state) {
        List<Restaurant> restaurants = repository.findByState(state);

        if (restaurants.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, " No restaurants found in the state " + state);
        }

        List<RestaurantResponse> result = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            result.add(toResponse(restaurant));
        }

        return result;
    }

    public List<RestaurantResponse> getRestaurantsByCity(String city) {
        List<Restaurant> restaurants = repository.findByCity(city);

        if (restaurants.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, " No restaurants found in the city " + city);
        }

        List<RestaurantResponse> result = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            result.add(toResponse(restaurant));
        }

        return result;
    }

    public List<RestaurantResponse> getRestaurantsByName(String name) {
        List<Restaurant> restaurants = repository.findByName(name);

        if (restaurants.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, " No restaurants found by the name: " + name);
        }

        List<RestaurantResponse> result = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            result.add(toResponse(restaurant));
        }

        return result;
    }

    public List<RestaurantResponse> getRestaurantByZipCode(String zipcode) {
        List<Restaurant> restaurants = repository.findByZipcode(zipcode);

        if (restaurants.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, " No restaurants found in zipcode: " + zipcode);
        }

        List<RestaurantResponse> result = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            result.add(toResponse(restaurant));
        }

        return result;
    }

    public List<RestaurantResponse> getRestaurantByCityAndState(String city, String state) {
        List<Restaurant> restaurants = repository.findByCityAndState(city, state);

        if (restaurants.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, " No restaurants found in city and state: " + city + ", " + state);
        }

        List<RestaurantResponse> result = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            result.add(toResponse(restaurant));
        }

        return result;
    }

    public List<String> getCuisinesByNameAndCity(String city, String name) {
        List<String> cuisines = repository.findCuisinesByNameAndCity(city, name);

        if (cuisines == null || cuisines.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, " No restaurants found in city and name: " + city + ", " + name);
        }

        return cuisines;
    }

    public String getPickupEnabledCityAndName(String city, String name)
    {
        List<Boolean> result = repository.findPickupEnabledByCityAndName(city, name);

        if (result.isEmpty())
        {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No restaurants found in " + city + " named " + name);

        }

        boolean anyEnabled = result.contains(Boolean.TRUE);
        boolean anyDisabled = result.contains(Boolean.FALSE);

        if (anyEnabled && anyDisabled)
        {
            return "Some matching restaurants offer pickup, but some do not";
        }
        if (anyEnabled)
        {
            return "All restaurants of " + name + " have pick up option available";
        }

        return "None of the matching restaurants offer pickup";
    }
}
