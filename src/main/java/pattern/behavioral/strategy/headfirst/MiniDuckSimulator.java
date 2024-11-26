package pattern.behavioral.strategy.headfirst;

import pattern.behavioral.strategy.headfirst.duck.Duck;
import pattern.behavioral.strategy.headfirst.duck.MallardDuck;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();
    }
}
