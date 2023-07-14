package ch4;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunClass {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        menu.stream().forEach(s -> {
            System.out.println("name = " + s.getName() + ", cal = "+ s.getCalories());
        });
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        System.out.println("lowCaloricDishes = " + lowCaloricDishes);
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCalDishName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCalDishName.add(dish.getName());
        }
        System.out.println("lowCalDishName = " + lowCalDishName);

        List<String> collect = menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}

class Temp {
    private int a;
    private int b;

    public Temp() {
        System.out.println("Temp.Temp");
    }

    public Temp setAndGetTemp(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println(this);
        return this;
    }

    public Temp setB(int b) {
        this.b = b;
        return this;
    }

}