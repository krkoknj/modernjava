package strategy;

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

    }
}
