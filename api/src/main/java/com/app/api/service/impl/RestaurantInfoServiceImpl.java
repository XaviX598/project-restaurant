package com.app.api.service.impl;

import com.app.api.dto.RestaurantInfoDto;
import com.app.api.entity.RestaurantInfo;
import com.app.api.mapper.RestaurantInfoMapper;
import com.app.api.repository.RestaurantInfoRepository;
import com.app.api.service.RestaurantInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantInfoServiceImpl implements RestaurantInfoService {

    private final RestaurantInfoRepository restaurantInfoRepository;
    private final RestaurantInfoMapper restaurantInfoMapper;

    @Override
    @Transactional(readOnly = true)
    public RestaurantInfoDto getRestaurantInfo() {
        RestaurantInfo restaurantInfo = restaurantInfoRepository.findAll().stream().findFirst()
                .orElse(null);
        return restaurantInfoMapper.toDto(restaurantInfo);
    }
}
