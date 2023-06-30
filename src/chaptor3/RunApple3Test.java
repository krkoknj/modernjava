package chaptor3;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class RunApple3Test {

    @Test
    void test() {
        Predicate<Apple> a = (s) -> s.getWeight() == 100;
        Apple ap = new Apple(100);
        System.out.println(a.test(ap));
    }
}