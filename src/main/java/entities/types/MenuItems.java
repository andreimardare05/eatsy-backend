package entities.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItems {

    private long menuId;
    private long restaurantId;
    private List<Drink> drinks;
    private List<MainCourse> mainCourses;
    private List<Starter> starters;
    private List<SideDish> sideDishes;
    private List<Deserts> deserts;

    public static MenuItems.MenuBuilder builder() {
        return new MenuItems.MenuBuilder();
    }

    public static class MenuBuilder {
        private List<Drink> drinks;
        private List<MainCourse> mainCourses;
        private List<Starter> starters;
        private List<SideDish> sideDishes;
        private List<Deserts> deserts;
        private long restaurantId;

        public MenuBuilder() {

        }
        public MenuItems.MenuBuilder addRestaurantId(long restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }
        public MenuItems.MenuBuilder addDrinks(List<Drink> drinks) {
            this.drinks = drinks;
            return this;
        }
        public MenuItems.MenuBuilder addMainCourses(List<MainCourse> mainCourses) {
            this.mainCourses = mainCourses;
            return this;
        }

        public MenuItems.MenuBuilder addStarters(List<Starter> starters) {
            this.starters = starters;
            return this;
        }

        public MenuItems.MenuBuilder addSideDishes(List<SideDish> sideDishes) {
            this.sideDishes = sideDishes;
            return this;
        }

        public MenuItems.MenuBuilder addDeserts(List<Deserts> deserts) {
            this.deserts = deserts;
            return this;
        }

        public MenuItems build() {
            return new MenuItems();
        }
    }

}
