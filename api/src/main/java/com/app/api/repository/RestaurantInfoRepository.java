package com.app.api.repository;

import com.app.api.entity.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Long> {
}
