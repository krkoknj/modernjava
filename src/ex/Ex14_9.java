package ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ex14_9 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100, 101, 102, 4, 5, 6, 7, 8, 9, 10, 197, 201);
        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;

        Predicate<Integer> notP = p.negate();
        Predicate<Integer> or = notP.and(q).or(r);
        Predicate<Integer> and = notP.and(q.or(r));
        List<Integer> test = test(and, list);
        System.out.println("test = " + test);
    }

    static List<Integer> test(Predicate<Integer> p, List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer i : list) {
            if (p.test(i)) {
                newList.add(i);
            }
        }
        return newList;
    }

}
