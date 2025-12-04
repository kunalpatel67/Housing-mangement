package com.example.housing.controller;


import com.example.housing.model.AvgPriceByLocationDTO;
import com.example.housing.model.House;
import com.example.housing.service.HousingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("house")
public class HousingController {
    @Autowired
    HousingService housingService;

    @PostMapping("addAll")
    public List<House> addAll(@RequestBody List<House> houses){
        return housingService.addMultipleHouses(houses);
    }

    @GetMapping("avgPrice")
    public Double getAvgPrice() {
        return housingService.getAvgPrice();
    }

    @GetMapping("avgPriceByLocation")
    public List<AvgPriceByLocationDTO> avgPriceGroupByLocation() {
        return housingService.avgPriceGroupByLocation();
    }

    @GetMapping("maxSalePrice")
    public int getMaxSalePrice(){
        return housingService.getMaxSalePrice();
    }

    @GetMapping("avgLocation/{location}")
    public Double getAvgPriceByLocation(@PathVariable String location) {
        return housingService.getAvgPriceByLocation(location);
    }
}
