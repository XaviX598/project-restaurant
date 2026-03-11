package com.app.api.mapper;

import com.app.api.dto.MenuItemDto;
import com.app.api.entity.MenuItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuItemMapper {

    public MenuItemDto toDto(MenuItem entity) {
        if (entity == null) {
            return null;
        }
        return MenuItemDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .precio(entity.getPrecio())
                .categoria(entity.getCategoria())
                .imagen(entity.getImagen())
                .disponible(entity.getDisponible())
                .ingredientes(entity.getIngredientes())
                .build();
    }

    public MenuItem toEntity(MenuItemDto dto) {
        if (dto == null) {
            return null;
        }
        return MenuItem.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .categoria(dto.getCategoria())
                .imagen(dto.getImagen())
                .disponible(dto.getDisponible())
                .ingredientes(dto.getIngredientes())
                .build();
    }

    public List<MenuItemDto> toDtoList(List<MenuItem> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
