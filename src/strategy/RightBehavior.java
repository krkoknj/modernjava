package strategy;

public class RightBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("RIGHT");
    }
}
