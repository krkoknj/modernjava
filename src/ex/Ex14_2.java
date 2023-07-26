package ex;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Ex14_2 {
    public static void main(String[] args) {
        Supplier<Integer> random = () -> (int) ((Math.random() * 100) + 1);
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> function = i -> i / 10 * 10;
        List<Integer> list = new ArrayList<>();
        makeRandomList(random, list);
        printEvenNum(p, c, list);
        List<Integer> integers = doSomething(function, list);
        System.out.println("list = " + list);
        System.out.println("integers = " + integers);
    }

    static <T> List<T> doSomething(Function<T, T> function, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());
        for (T i : list) {
            newList.add(function.apply(i));
        }
        return newList;
    }

    static <T> void makeRandomList(Supplier<T> supplier, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(supplier.get());
        }
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i))
                c.accept(i);
        }
        System.out.print("]");
    }
}
