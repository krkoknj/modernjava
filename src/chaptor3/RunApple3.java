package chaptor3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class RunApple3 {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        ));

        // [Apple{color=GREEN, weight=80}, Apple{color=RED, weight=120}, Apple{color=GREEN, weight=155}]
//        inventory.sort(new AppleComparator());

//        inventory.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight() - o2.getWeight();
//            }
//        });

//        inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        inventory.set(0, new Apple(155, Color.RED));
        inventory.sort(comparing(Apple::getWeight)
                .thenComparing(Apple::getColor));
        System.out.println(inventory);

        Comparator<Apple> comparing = comparing(Apple::getWeight);

        Predicate<Apple> ap = apple -> apple.getColor().equals(Color.RED);
        System.out.println("ap = " + ap);
    }
}

class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
