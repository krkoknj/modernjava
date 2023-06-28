package behaviorparameterizatioin;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionMain {
    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(1, 7, 5, 10);
        List<Apple> apples = map(weights, Apple::new);
        System.out.println("apples = " + apples);

        BiFunction<Integer, Color, Apple> c3 = Apple::new;
        Function<Integer, Apple> sss = Apple::new;
        Apple apply1 = sss.apply(100);
        System.out.println("apply1 = " + apply1);
//        BiFunction<Integer, Color, Apple> c4 = (i, s) -> new Apple(i, s);
        Apple apply = c3.apply(10, Color.RED);
//        Apple apply1 = c4.apply(100, Color.GREEN);
        System.out.println("apply = " + apply);

        TestFunction<Integer, Integer, Integer, Integer, Integer, Apple> a = Apple::new;
        Apple apply2 = a.apply(10, 11, 12, 13, 14);
        System.out.println("apply2 = " + apply2);

        System.out.println("------------------------------");
        Apple apple = (Apple) giveMeFruit("apple", 100);

        Fruit apple2 = giveMeFruit("apple", 100);
        System.out.println("apple = " + apple);
        Orange orange = (Orange) giveMeFruit("orange", 110);
        System.out.println("orange = " + orange);
        System.out.println("------------------------------");
    }

    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    private static Fruit giveMeFruit(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase()).apply(weight);
    }

    private static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : weights) {
            result.add(f.apply(i));
        }
        return result;
    }

    enum Color {
        RED,
        GREEN
    }

    public static class Fruit {
        protected Integer fruitWeight;
        protected String shape;
    }

    public static class Orange extends Fruit {
        protected String orangeColor = "Orange";

        public Orange(Integer weight) {
            this.fruitWeight = weight;
        }

        @Override
        public String toString() {
            return "Orange{" +
                    "orangeColor='" + orangeColor + '\'' +
                    ", fruitWeight=" + fruitWeight +
                    ", shape='" + shape + '\'' +
                    '}';
        }
    }

    public static class Apple extends Fruit {

        private int weight = 0;
        private int weight2 = 0;
        private int weight3 = 0;
        private int weight4 = 0;
        private int weight5 = 0;
        private Color color;

        public Apple(Integer weight) {
            this.weight = weight;
        }

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public Apple(int weight, int weight2, int w3, int w4, int w5) {
            this.weight = weight;
            this.weight2 = weight2;
            this.weight3 = w3;
            this.weight4 = w4;
            this.weight5 = w5;
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

        public String getShape() {
            return shape;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", weight2=" + weight2 +
                    ", weight3=" + weight3 +
                    ", weight4=" + weight4 +
                    ", weight5=" + weight5 +
                    ", color=" + color +
                    '}';
        }
    }
}
