package chaptor3.addmulti;

import java.util.function.Function;

public class RunAddMulti {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> integerIntegerFunction = f.andThen(g);
        Integer apply = integerIntegerFunction.apply(1);
        Integer apply1 = f.apply(1);
        System.out.println("apply = " + apply);
        System.out.println("apply1 = " + apply1);
    }
}
