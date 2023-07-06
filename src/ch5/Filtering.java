package ch5;

import ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Filtering {
    public static void main(String[] args) {
        System.out.println("Start - Filtering with a predicate");
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        vegetarianMenu.forEach(System.out::println);
        System.out.println("End - Filtering with a predicate");

        System.out.println("Start - Filtering unique elements:");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        System.out.println("End - Filtering unique elements");

        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        System.out.println("Filtered sorted menu:");
        List<Dish> dishList = specialMenu.stream()
                .filter(dish -> dish.getCalories() <= 320)
                .collect(toList());
        System.out.println("dishList = " + dishList);
        System.out.println("Filtered sorted menu End");

        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());
        System.out.println("dishes = " + dishes);

        List<Dish> collect = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(5)
                .collect(toList());
        System.out.println("collect = " + collect);

        List<Dish> collect1 = menu.stream()
                .filter(d -> Dish.Type.MEAT == d.getType())
                .skip(2)
                .collect(toList());
        System.out.println("collect1 = " + collect1);
    }

    public static final List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 400, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );
}
