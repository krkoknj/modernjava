package behaviorparameterizatioin;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static behaviorparameterizatioin.FilteringApples.Color.GREEN;
import static behaviorparameterizatioin.FilteringApples.Color.RED;

enum Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}
public class FilteringApples {

    public static void main(String... args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED));

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            numbers.add(i);
        }
        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
//        List<Apple> greenApples = filterApplesByColor(inventory, GREEN);
//        System.out.println(greenApples);
//
//        // [Apple{color=RED, weight=120}]
//        List<Apple> redApples = filterApplesByColor(inventory, RED);
//        System.out.println(redApples);
//
//        List<Apple> apples = filterApples(inventory, new AppleWeightPredicate());
//        System.out.println("apples = " + apples);

//        prettyPrintApple(inventory, new ApplePrintPlus());
//        List<Apple> apples = filterApples(inventory, (Apple a) -> RED.equals(a.getColor()));
        List<Apple> redApples = filterList(inventory, (Apple a) -> RED.equals(a.getColor()));
        System.out.println("redApples = " + redApples);

        List<Integer> evenNumbers = filterList(numbers, (Integer i) -> i % 2 == 0);
        System.out.println("evenNumbers = " + evenNumbers);

        process(() -> System.out.println("ABC"));

        Rainbow[] arr = Rainbow.values();
        for (Rainbow rb : arr) {
            System.out.println("rb = " + rb);
        }

        List<String> listOfString = Arrays.asList("1", "2", "3", "", "", "4", "5", "6", "7", "8" ,"9");

        // boolean 반환
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> filter = filter(listOfString, nonEmptyStringPredicate);
        System.out.println("filter = " + filter);


        forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println("forEach -> " + i));

        List<Integer> map = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println("map = " + map);

//        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
//        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
//        System.out.println(greenApples2);
//
//        // [Apple{color=GREEN, weight=155}]
//        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
//        System.out.println(heavyApples);
//
//        // []
//        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
//        System.out.println(redAndHeavyApples);
//
//        // [Apple{color=RED, weight=120}]
//        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
//            @Override
//            public boolean test(Apple a) {
//                return a.getColor() == Color.RED;
//            }
//        });
//        System.out.println(redApples2);

        List<String> words = Arrays.asList("aaa", "bbb", "ccc");

        List<String> str = Arrays.asList("a", "b", "A", "B");
//        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);
        System.out.println("str = " + str);

        Function<Integer, Apple> integerColorAppleBiFunction = Apple::new;
        Apple apply = integerColorAppleBiFunction.apply(100);
        Function<Integer, Apple> c2 = (weight) -> new Apple(weight);
        Apple apply1 = c2.apply(110);

    }


    public boolean isValidName(String string) {
        return Character.isUpperCase(string.charAt(0));
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static void process(Runnable r) {
        r.run();
    }
    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filterList(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
    public static void prettyPrintApple(List<Apple> inventory, PrintApple printAp) {
        for (Apple apple : inventory) {
            String output = printAp.print(apple);
            System.out.println("output = " + output);
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }




    enum Color {
        RED,
        GREEN
    }

    public static class Apple {

        private int weight = 0;
        private Color color;

        public Apple(Integer weight) {
            this.weight = weight;
        }
        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color=%s, weight=%d}", color, weight);
        }

    }

    interface ApplePredicate {

        boolean test(Apple a);

    }

    interface PrintApple {
        String print(Apple a);
    }

    static class ApplePrintPlus implements PrintApple {
        @Override
        public String print(Apple a) {
            return a.getColor() + "+_+" + a.getWeight();
        }
    }


    static class AppleWeightPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }

    }

    static class AppleColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == GREEN;
        }

    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == RED && apple.getWeight() > 150;
        }

    }

}
