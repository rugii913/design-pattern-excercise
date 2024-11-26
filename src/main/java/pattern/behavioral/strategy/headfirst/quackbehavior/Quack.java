package pattern.behavioral.strategy.headfirst.quackbehavior;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack.");
    }
}
