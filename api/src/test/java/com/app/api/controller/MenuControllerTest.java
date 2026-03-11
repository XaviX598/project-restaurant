package com.app.api.controller;

import com.app.api.dto.MenuItemDto;
import com.app.api.exception.GlobalExceptionHandler;
import com.app.api.exception.ResourceNotFoundException;
import com.app.api.service.MenuItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

    @Mock
    private MenuItemService menuItemService;

    @InjectMocks
    private MenuController menuController;

    private MockMvc mockMvc;
    private MenuItemDto menuItemDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(menuController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();

        menuItemDto = MenuItemDto.builder()
                .id(1L)
                .nombre("Spaghetti Carbonara")
                .descripcion("Pasta con huevo y panceta")
                .precio(new BigDecimal("14.50"))
                .categoria("Pastas")
                .disponible(true)
                .build();
    }

    @Test
    @DisplayName("Test getAllMenuItems - Should return all menu items")
    void testGetAllMenuItems() {
        List<MenuItemDto> menuItems = Arrays.asList(menuItemDto);
        when(menuItemService.getAllMenuItems()).thenReturn(menuItems);

        ResponseEntity<List<MenuItemDto>> response = menuController.getAllMenuItems();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        verify(menuItemService, times(1)).getAllMenuItems();
    }

    @Test
    @DisplayName("Test getAvailableMenuItems - Should return available menu items")
    void testGetAvailableMenuItems() {
        List<MenuItemDto> menuItems = Arrays.asList(menuItemDto);
        when(menuItemService.getAvailableMenuItems()).thenReturn(menuItems);

        ResponseEntity<List<MenuItemDto>> response = menuController.getAvailableMenuItems();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(menuItemService, times(1)).getAvailableMenuItems();
    }

    @Test
    @DisplayName("Test getMenuItemsByCategory - Should return items by category")
    void testGetMenuItemsByCategory() {
        List<MenuItemDto> menuItems = Arrays.asList(menuItemDto);
        when(menuItemService.getMenuItemsByCategory("Pastas")).thenReturn(menuItems);

        ResponseEntity<List<MenuItemDto>> response = menuController.getMenuItemsByCategory("Pastas");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(menuItemService, times(1)).getMenuItemsByCategory("Pastas");
    }

    @Test
    @DisplayName("Test getMenuItemById - Should return menu item by ID")
    void testGetMenuItemById() {
        when(menuItemService.getMenuItemById(1L)).thenReturn(menuItemDto);

        ResponseEntity<MenuItemDto> response = menuController.getMenuItemById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Spaghetti Carbonara", response.getBody().getNombre());
    }

    @Test
    @DisplayName("Test getMenuItemById - Should return 404 when not found")
    void testGetMenuItemByIdNotFound() {
        when(menuItemService.getMenuItemById(999L)).thenThrow(new ResourceNotFoundException("No encontrado"));

        ResponseEntity<MenuItemDto> response = menuController.getMenuItemById(999L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @DisplayName("Test getAllCategories - Should return all categories")
    void testGetAllCategories() {
        List<String> categorias = Arrays.asList("Pastas", "Pizzas", "Carnes");
        when(menuItemService.getAllCategories()).thenReturn(categorias);

        ResponseEntity<List<String>> response = menuController.getAllCategories();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(3, response.getBody().size());
    }
}
