package strategy;

import java.util.Arrays;
import java.util.function.Consumer;

public class CarMain {
    public static void main(String[] args) {
        Car up = new Car(new UpBehavior());
        up.move();

        Car down = new Car(new DownBehavior());
        down.move();

        down.setMoveBehavior(new LeftBehavior());
        down.move();

        down.setMoveBehavior(new RightBehavior());
        down.move();

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        System.out.println(Arrays.toString(arr));
    }
}
