package com.app.api.util;

import com.app.api.entity.MenuItem;
import com.app.api.entity.RestaurantInfo;
import com.app.api.repository.MenuItemRepository;
import com.app.api.repository.RestaurantInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantInfoRepository restaurantInfoRepository;

    @Override
    public void run(String... args) {
        if (menuItemRepository.count() == 0) {
            initializeMenuItems();
        }
        if (restaurantInfoRepository.count() == 0) {
            initializeRestaurantInfo();
        }
    }

    private void initializeMenuItems() {
        menuItemRepository.save(MenuItem.builder()
                .nombre("Spaghetti Carbonara")
                .descripcion("Pasta fresca con huevo, queso pecorino, panceta crujiente y pimienta negra")
                .precio(new BigDecimal("14.50"))
                .categoria("Pastas")
                .imagen("https://images.unsplash.com/photo-1612874742237-6526221588e3?w=400")
                .disponible(true)
                .ingredientes("Pasta, huevo, queso pecorino, panceta, pimienta negra")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Lasagna Tradicional")
                .descripcion("Capas de pasta fresca, ragú de carne, bechamel y queso mozzarella")
                .precio(new BigDecimal("16.00"))
                .categoria("Pastas")
                .imagen("https://images.unsplash.com/photo-1574894709920-11b28e7367e3?w=400")
                .disponible(true)
                .ingredientes("Pasta, carne molida, tomate, bechamel, mozzarella")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Fettuccine Alfredo")
                .descripcion("Pasta fetuccini en cremosa salsa de mantequilla y queso parmesano")
                .precio(new BigDecimal("13.50"))
                .categoria("Pastas")
                .imagen("https://images.unsplash.com/photo-1645112411341-6c4fd023714a?w=400")
                .disponible(true)
                .ingredientes("Fettuccini, mantequilla, parmesano, ajo, perejil")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Risotto ai Funghi")
                .descripcion("Arroz arborio con mezcla de hongos silvestres y queso parmesano")
                .precio(new BigDecimal("15.00"))
                .categoria("Arroces")
                .imagen("https://images.unsplash.com/photo-1476124369491-e7addf5db371?w=400")
                .disponible(true)
                .ingredientes("Arroz arborio, hongos, cebolla, vino blanco, parmesano")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Pizza Margherita")
                .descripcion("Pizza clásica con tomate san marzano, mozzarella fresca y albahaca")
                .precio(new BigDecimal("12.00"))
                .categoria("Pizzas")
                .imagen("https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=400")
                .disponible(true)
                .ingredientes("Masa, tomate, mozzarella fresca, albahaca, aceite de oliva")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Pizza Quattro Formaggi")
                .descripcion("Pizza con mezcla de cuatro quesos: mozzarella, gorgonzola, fontina y parmesano")
                .precio(new BigDecimal("15.50"))
                .categoria("Pizzas")
                .imagen("https://images.unsplash.com/photo-1513104890138-7c749659a591?w=400")
                .disponible(true)
                .ingredientes("Masa, mozzarella, gorgonzola, fontina, parmesano")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Osso Buco alla Milanese")
                .descripcion("Estofado de ternera cocido lentamente con verduras y gremolata")
                .precio(new BigDecimal("22.00"))
                .categoria("Carnes")
                .imagen("https://images.unsplash.com/photo-1544025162-d76694265947?w=400")
                .disponible(true)
                .ingredientes("Carrillera de ternera, tomate, zanahoria, apio, vino blanco")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Saltimbocca alla Romana")
                .descripcion("Escalopes de ternera con prosciutto y sage en vino blanco")
                .precio(new BigDecimal("18.50"))
                .categoria("Carnes")
                .imagen("https://images.unsplash.com/photo-1432139555190-58524dae6a55?w=400")
                .disponible(true)
                .ingredientes("Ternera, prosciutto, sage, vino blanco, mantequilla")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Branzino al Forno")
                .descripcion("Lubina entera horneada con hierbas frescas, limón y aceite de oliva")
                .precio(new BigDecimal("21.00"))
                .categoria("Pescados")
                .imagen("https://images.unsplash.com/photo-1534604973900-c43ab4c2e0ab?w=400")
                .disponible(true)
                .ingredientes("Lubina, limón, ajo, romero, tomillo, aceite de oliva")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Gnocchi al Pesto")
                .descripcion("Gnocchi de papa caseros con pesto genovés y tomates cherry")
                .precio(new BigDecimal("13.00"))
                .categoria("Pastas")
                .imagen("https://images.unsplash.com/photo-1473093295043-cdd812d0e601?w=400")
                .disponible(true)
                .ingredientes("Gnocchi, albahaca, piñón, parmesano, tomates cherry")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Tiramisú")
                .descripcion("Postre clásico con capas de bizcocho, café, mascarpone y cacao")
                .precio(new BigDecimal("8.50"))
                .categoria("Postres")
                .imagen("https://images.unsplash.com/photo-1571877227200-a0d98ea607e9?w=400")
                .disponible(true)
                .ingredientes("Bizcocho, café, mascarpone, huevo, cacao")
                .build());

        menuItemRepository.save(MenuItem.builder()
                .nombre("Panna Cotta")
                .descripcion("Crema italiana cocida con coulis de frutas rojas")
                .precio(new BigDecimal("7.50"))
                .categoria("Postres")
                .imagen("https://images.unsplash.com/photo-1488477181946-6428a0291777?w=400")
                .disponible(true)
                .ingredientes("Nata, azúcar, vainilla, gelatina, frutas rojas")
                .build());
    }

    private void initializeRestaurantInfo() {
        restaurantInfoRepository.save(RestaurantInfo.builder()
                .nombre("Trattoria Roma")
                .descripcion("Auténtica cocina italiana en el corazón de Quito. Disfruta de pastas frescas, pizzas artesanales y los mejores platos de la tradición culinaria italiana. Ambiente acogedor, ideal para familias y parejas.")
                .direccion("Av. González Suárez N27-187, La Floresta, Quito")
                .telefono("+593 2 123 4567")
                .email("reservas@trattoriaroma.ec")
                .horario("Lunes a Domingo: 12:00 - 22:00")
                .linkWhatsapp("https://wa.me/593991234567?text=Hola,%20me%20gustaría%20reservar%20una%20mesa")
                .linkMapa("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3989.814456789012!2d-78.483409!3d-0.183762!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x91d5918575456789%3A0x1234567890abcdef!2sAv.%20Gonz%C3%A1lez%20Su%C3%A1rez%20N27-187%2C%20Quito!5e0!3m2!1ses!2sec!4v1234567890")
                .ciudad("Quito")
                .build());
    }
}
