package strategy;

public class UpBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("UP");
    }
}
