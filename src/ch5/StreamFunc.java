package ch5;

import ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFunc {
    public static void main(String[] args) {
        List<String> words = getWordList();
        List<Integer> collect = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        List<String> collect1 = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

        List<String> words1 = Arrays.asList("Hello", "World");
        List<String> collect2 = words1.stream()
                .map(word -> word.split(""))
                //words1[0] : Hello, words2[1] : World -> flatMap(Array::stream) -> HelloWorld
                // flatMap은 Stream<String[]> 스트림 안에 스트링 배열을 Stream<String> 값으로 매핑
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);


        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> collect3 = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(1, 2);
        List<int[]> collect4 = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
    }

    public static List<String> getWordList() {
        return Arrays.asList("Modern", "Java", "In", "Action");
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
