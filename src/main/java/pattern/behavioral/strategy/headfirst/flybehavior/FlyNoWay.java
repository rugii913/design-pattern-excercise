package pattern.behavioral.strategy.headfirst.flybehavior;

public class FlyNoWay implements FlyBehavior {

    public void fly() {
        System.out.println("I cannot fly.");
    }
}
