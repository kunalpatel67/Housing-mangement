package com.example.housing.service;

import com.example.housing.model.AvgPriceByLocationDTO;
import com.example.housing.model.House;
import com.example.housing.repository.HousingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HousingService {
    @Autowired
    HousingRepo housingRepo;

    public List<House> addMultipleHouses(List<House> houses) {
        return housingRepo.saveAll(houses);
    }

    public Double getAvgPrice() {
        return housingRepo.getAvgPrice();
    }

    public List<AvgPriceByLocationDTO> avgPriceGroupByLocation() {
        return housingRepo.avgPriceGroupByLocation();
    }

    public int getMaxSalePrice() {
        return housingRepo.getMaxSalePrice();
    }

    public Double getAvgPriceByLocation(String location) {
        return housingRepo.getAvgPriceByLocation(location);
    }
}
