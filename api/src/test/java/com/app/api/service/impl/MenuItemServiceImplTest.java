package com.app.api.service.impl;

import com.app.api.dto.MenuItemDto;
import com.app.api.entity.MenuItem;
import com.app.api.exception.ResourceNotFoundException;
import com.app.api.mapper.MenuItemMapper;
import com.app.api.repository.MenuItemRepository;
import com.app.api.service.MenuItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuItemServiceImplTest {

    @Mock
    private MenuItemRepository menuItemRepository;

    @Mock
    private MenuItemMapper menuItemMapper;

    @InjectMocks
    private MenuItemServiceImpl menuItemService;

    private MenuItem menuItem1;
    private MenuItem menuItem2;
    private MenuItemDto menuItemDto1;
    private MenuItemDto menuItemDto2;

    @BeforeEach
    void setUp() {
        menuItem1 = MenuItem.builder()
                .id(1L)
                .nombre("Spaghetti Carbonara")
                .descripcion("Pasta con huevo y panceta")
                .precio(new BigDecimal("14.50"))
                .categoria("Pastas")
                .disponible(true)
                .build();

        menuItem2 = MenuItem.builder()
                .id(2L)
                .nombre("Pizza Margherita")
                .descripcion("Pizza clásica italiana")
                .precio(new BigDecimal("12.00"))
                .categoria("Pizzas")
                .disponible(true)
                .build();

        menuItemDto1 = MenuItemDto.builder()
                .id(1L)
                .nombre("Spaghetti Carbonara")
                .descripcion("Pasta con huevo y panceta")
                .precio(new BigDecimal("14.50"))
                .categoria("Pastas")
                .disponible(true)
                .build();

        menuItemDto2 = MenuItemDto.builder()
                .id(2L)
                .nombre("Pizza Margherita")
                .descripcion("Pizza clásica italiana")
                .precio(new BigDecimal("12.00"))
                .categoria("Pizzas")
                .disponible(true)
                .build();
    }

    @Test
    @DisplayName("Test getAllMenuItems - Should return all menu items")
    void testGetAllMenuItems() {
        when(menuItemRepository.findAll()).thenReturn(Arrays.asList(menuItem1, menuItem2));
        when(menuItemMapper.toDtoList(anyList())).thenReturn(Arrays.asList(menuItemDto1, menuItemDto2));

        List<MenuItemDto> result = menuItemService.getAllMenuItems();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(menuItemRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test getAvailableMenuItems - Should return only available items")
    void testGetAvailableMenuItems() {
        when(menuItemRepository.findByDisponibleTrue()).thenReturn(Arrays.asList(menuItem1, menuItem2));
        when(menuItemMapper.toDtoList(anyList())).thenReturn(Arrays.asList(menuItemDto1, menuItemDto2));

        List<MenuItemDto> result = menuItemService.getAvailableMenuItems();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(menuItemRepository, times(1)).findByDisponibleTrue();
    }

    @Test
    @DisplayName("Test getMenuItemsByCategory - Should return items filtered by category")
    void testGetMenuItemsByCategory() {
        when(menuItemRepository.findByCategoriaAndDisponibleTrue("Pastas")).thenReturn(Arrays.asList(menuItem1));
        when(menuItemMapper.toDtoList(anyList())).thenReturn(Arrays.asList(menuItemDto1));

        List<MenuItemDto> result = menuItemService.getMenuItemsByCategory("Pastas");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Pastas", result.get(0).getCategoria());
    }

    @Test
    @DisplayName("Test getMenuItemById - Should return menu item when exists")
    void testGetMenuItemById() {
        when(menuItemRepository.findById(1L)).thenReturn(Optional.of(menuItem1));
        when(menuItemMapper.toDto(menuItem1)).thenReturn(menuItemDto1);

        MenuItemDto result = menuItemService.getMenuItemById(1L);

        assertNotNull(result);
        assertEquals("Spaghetti Carbonara", result.getNombre());
    }

    @Test
    @DisplayName("Test getMenuItemById - Should throw exception when not found")
    void testGetMenuItemByIdNotFound() {
        when(menuItemRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> menuItemService.getMenuItemById(999L));
    }

    @Test
    @DisplayName("Test getAllCategories - Should return unique categories")
    void testGetAllCategories() {
        when(menuItemRepository.findAll()).thenReturn(Arrays.asList(menuItem1, menuItem2));

        List<String> result = menuItemService.getAllCategories();

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
