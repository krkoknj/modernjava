package strategy;

public class LeftBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("LEFT");
    }
}
