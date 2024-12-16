package pattern.behavioral.strategy.headfirst;

import pattern.behavioral.strategy.headfirst.duck.Duck;
import pattern.behavioral.strategy.headfirst.duck.MallardDuck;
import pattern.behavioral.strategy.headfirst.duck.ModelDuck;
import pattern.behavioral.strategy.headfirst.flybehavior.FlyRocketPowered;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();
        System.out.println("---------------");
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered()); // 실행 중 행동을 변경하고 싶으면, 다른 행동을 하는 객체로 구성을 변경할 수 있음(여기서는 setter를 사용하여 변경)
        modelDuck.performFly();
    }
}
