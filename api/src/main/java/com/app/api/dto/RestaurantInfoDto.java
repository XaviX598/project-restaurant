package com.app.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantInfoDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String telefono;
    private String email;
    private String horario;
    private String linkWhatsapp;
    private String linkMapa;
    private String ciudad;
}
