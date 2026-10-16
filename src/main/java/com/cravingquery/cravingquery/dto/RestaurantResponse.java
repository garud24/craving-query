package com.cravingquery.cravingquery.dto;
import java.math.BigDecimal;
import java.util.List;
public record RestaurantResponse(Long id, String name, String city, String state, String zipcode, String country, List<String> cuisines, boolean pickupEnabled, boolean deliveryEnabled, BigDecimal weightedRatingValue, int aggregatedRatingCount) {
    
}
