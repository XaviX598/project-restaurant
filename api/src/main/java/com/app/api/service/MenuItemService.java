package com.app.api.service;

import com.app.api.dto.MenuItemDto;

import java.util.List;

public interface MenuItemService {
    List<MenuItemDto> getAllMenuItems();
    List<MenuItemDto> getAvailableMenuItems();
    List<MenuItemDto> getMenuItemsByCategory(String categoria);
    MenuItemDto getMenuItemById(Long id);
    List<String> getAllCategories();
}
