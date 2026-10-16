package com.cravingquery.cravingquery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cravingquery.cravingquery.entity.Restaurant;
 

@Repository 
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
    
    List<Restaurant> findByState(String state);

    List<Restaurant> findByCity(String city);

    List<Restaurant> findByZipcode(String zipcode);

    List<Restaurant> findByName(String name);

    List<Restaurant> findByCityAndState(String city, String state);

    @Query("select r.cuisines from Restaurant r where r.city = :city and r.name = :name")
    List<String> findCuisinesByNameAndCity(
        @Param("city") String city,
        @Param("name") String name);
    
    @Query("select r.pickupEnabled from Restaurant r where r.city = :city and r.name = :name")    
    List<Boolean> findPickupEnabledByCityAndName(@Param("city") String city, @Param("name")String name);
        

}
