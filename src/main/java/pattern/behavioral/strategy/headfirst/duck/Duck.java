package pattern.behavioral.strategy.headfirst.duck;

import pattern.behavioral.strategy.headfirst.flybehavior.FlyBehavior;
import pattern.behavioral.strategy.headfirst.quackbehavior.QuackBehavior;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    abstract public void display();

    public void performFly() {
        this.flyBehavior.fly();
    }
    public void performQuack() {
        this.quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys.");
    }
}
