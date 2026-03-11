package com.app.api.repository;

import com.app.api.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByDisponibleTrue();
    List<MenuItem> findByCategoriaAndDisponibleTrue(String categoria);
    List<MenuItem> findByNombreContainingIgnoreCase(String nombre);
}
