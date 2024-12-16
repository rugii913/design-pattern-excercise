package pattern.behavioral.strategy.headfirst.duck;

import pattern.behavioral.strategy.headfirst.flybehavior.FlyWithWings;
import pattern.behavioral.strategy.headfirst.quackbehavior.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        this.quackBehavior = new Quack();
        this.flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a mallard duck.");
    }
}
