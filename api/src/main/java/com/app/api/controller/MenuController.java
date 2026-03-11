package com.app.api.controller;

import com.app.api.dto.MenuItemDto;
import com.app.api.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuItemService menuItemService;

    @GetMapping
    public ResponseEntity<List<MenuItemDto>> getAllMenuItems() {
        List<MenuItemDto> menuItems = menuItemService.getAllMenuItems();
        return ResponseEntity.ok(menuItems);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<MenuItemDto>> getAvailableMenuItems() {
        List<MenuItemDto> menuItems = menuItemService.getAvailableMenuItems();
        return ResponseEntity.ok(menuItems);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<MenuItemDto>> getMenuItemsByCategory(@PathVariable String categoria) {
        List<MenuItemDto> menuItems = menuItemService.getMenuItemsByCategory(categoria);
        return ResponseEntity.ok(menuItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDto> getMenuItemById(@PathVariable Long id) {
        MenuItemDto menuItem = menuItemService.getMenuItemById(id);
        return ResponseEntity.ok(menuItem);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categorias = menuItemService.getAllCategories();
        return ResponseEntity.ok(categorias);
    }
}
