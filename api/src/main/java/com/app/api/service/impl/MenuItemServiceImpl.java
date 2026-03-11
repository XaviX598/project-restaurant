package com.app.api.service.impl;

import com.app.api.dto.MenuItemDto;
import com.app.api.entity.MenuItem;
import com.app.api.exception.ResourceNotFoundException;
import com.app.api.mapper.MenuItemMapper;
import com.app.api.repository.MenuItemRepository;
import com.app.api.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MenuItemMapper menuItemMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MenuItemDto> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        return menuItemMapper.toDtoList(menuItems);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuItemDto> getAvailableMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findByDisponibleTrue();
        return menuItemMapper.toDtoList(menuItems);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuItemDto> getMenuItemsByCategory(String categoria) {
        List<MenuItem> menuItems = menuItemRepository.findByCategoriaAndDisponibleTrue(categoria);
        return menuItemMapper.toDtoList(menuItems);
    }

    @Override
    @Transactional(readOnly = true)
    public MenuItemDto getMenuItemById(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Platillo no encontrado con ID: " + id));
        return menuItemMapper.toDto(menuItem);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllCategories() {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        return menuItems.stream()
                .map(MenuItem::getCategoria)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
