package services;

import entities.types.MenuItems;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantManagerService restaurantManagerService;

    public RestaurantService(RestaurantManagerService restaurantManagerService) {
        this.restaurantManagerService = restaurantManagerService;
    }

    /**
     * Build a menu for restaurant
     *
     * @param menuItems received from api
     */
    private MenuItems _buildMenu(MenuItems menuItems) {
        return MenuItems.builder()
                .addRestaurantId(menuItems.getRestaurantId())
                .addDeserts(menuItems.getDeserts())
                .addDrinks(menuItems.getDrinks())
                .build();

    }

}
