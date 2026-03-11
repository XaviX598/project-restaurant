package com.app.api.controller;

import com.app.api.dto.RestaurantInfoDto;
import com.app.api.service.RestaurantInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantInfoService restaurantInfoService;

    @GetMapping
    public ResponseEntity<RestaurantInfoDto> getRestaurantInfo() {
        RestaurantInfoDto restaurantInfo = restaurantInfoService.getRestaurantInfo();
        return ResponseEntity.ok(restaurantInfo);
    }
}
