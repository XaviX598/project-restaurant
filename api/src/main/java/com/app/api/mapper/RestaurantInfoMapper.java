package com.app.api.mapper;

import com.app.api.dto.RestaurantInfoDto;
import com.app.api.entity.RestaurantInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantInfoMapper {

    public RestaurantInfoDto toDto(RestaurantInfo entity) {
        if (entity == null) {
            return null;
        }
        return RestaurantInfoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .direccion(entity.getDireccion())
                .telefono(entity.getTelefono())
                .email(entity.getEmail())
                .horario(entity.getHorario())
                .linkWhatsapp(entity.getLinkWhatsapp())
                .linkMapa(entity.getLinkMapa())
                .ciudad(entity.getCiudad())
                .build();
    }

    public RestaurantInfo toEntity(RestaurantInfoDto dto) {
        if (dto == null) {
            return null;
        }
        return RestaurantInfo.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .horario(dto.getHorario())
                .linkWhatsapp(dto.getLinkWhatsapp())
                .linkMapa(dto.getLinkMapa())
                .ciudad(dto.getCiudad())
                .build();
    }

    public List<RestaurantInfoDto> toDtoList(List<RestaurantInfo> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
