package ch4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunClass {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        List<String> collect = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering : " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping : " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        Temp tmp = new Temp();
        Temp temp = tmp.setAndGetTemp(1, 3).setB(5);
        System.out.println(tmp == temp);
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