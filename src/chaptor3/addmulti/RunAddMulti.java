package chaptor3.addmulti;

import java.util.function.Function;

public class RunAddMulti {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 10;
        Function<Integer, Integer> g = x -> x * 10;
        Function<Integer, Integer> integerIntegerFunction = f.compose(g);
        Integer apply = integerIntegerFunction.apply(5);
        Integer apply1 = f.apply(1);
        System.out.println("apply = " + apply);
        System.out.println("apply1 = " + apply1);
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> then = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        System.out.println("then = " + then);
    }
}

class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + "Kind regards";
    }
    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
