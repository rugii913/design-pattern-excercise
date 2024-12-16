package pattern.behavioral.strategy.headfirst.duck;

import pattern.behavioral.strategy.headfirst.flybehavior.FlyNoWay;
import pattern.behavioral.strategy.headfirst.quackbehavior.MuteQuack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck.");
    }
}
