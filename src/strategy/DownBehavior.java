package strategy;

public class DownBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("DOWN!");
    }
}
