package com.example.housing.repository;

import com.example.housing.model.AvgPriceByLocationDTO;
import com.example.housing.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HousingRepo extends JpaRepository<House,Integer> {
    @Query (value = "select AVG(sale_price) from house",nativeQuery = true)
    Double getAvgPrice();

    @Query( value = "SELECT location AS location, AVG(sale_price) AS avgPrice " + "FROM house GROUP BY location", nativeQuery = true)
    List<AvgPriceByLocationDTO> avgPriceGroupByLocation();

    @Query(value = "SELECT MAX(sale_price) FROM house", nativeQuery = true)
    int getMaxSalePrice();

    @Query(value = "SELECT AVG(sale_price) FROM house WHERE location = ?1", nativeQuery = true)
    Double getAvgPriceByLocation(String location);
}
