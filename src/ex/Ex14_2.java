package ex;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2 {
    public static void main(String[] args) {
        Supplier<Integer> random = () -> (int) ((Math.random() * 100) + 1);
    }

    static <T> void makeRandomList(Supplier<T> supplier, List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            list.add(supplier.get());
        }
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i))
                c.accept(i);
        }
    }
}
