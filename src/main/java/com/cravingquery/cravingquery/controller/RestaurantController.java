package com.cravingquery.cravingquery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cravingquery.cravingquery.dto.RestaurantResponse;
import com.cravingquery.cravingquery.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @GetMapping("/by-state/{state}")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantByState(@PathVariable String state) {
        return ResponseEntity.ok(restaurantService.getRestaurantByState(state));
    }

    @GetMapping("/by-city/{city}")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantsByCity(@PathVariable String city) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByCity(city));
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantsByName(@PathVariable String name) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByName(name));
    }

    @GetMapping("by-zipcode/{zipcode}")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantByZipCode(@PathVariable String zipcode) {
        return ResponseEntity.ok(restaurantService.getRestaurantByZipCode(zipcode));
    }

    @GetMapping("by-city-state")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantByCityAndState(@RequestParam String city,
            @RequestParam String state) {
        return ResponseEntity.ok(restaurantService.getRestaurantByCityAndState(city, state));
    }

    @GetMapping("by-city-name-cuisines")
    public ResponseEntity<List<String>> getCuisinesByNameAndCity(@RequestParam String city, @RequestParam String name) {
        return ResponseEntity.ok(restaurantService.getCuisinesByNameAndCity(city, name));
    }

    @GetMapping("is-pickup-available")
    public ResponseEntity<String> getPickupEnabledCityAndName(@RequestParam String city, @RequestParam String name) {
        return ResponseEntity.ok(restaurantService.getPickupEnabledCityAndName(city, name));
    }

}