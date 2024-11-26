package pattern.behavioral.strategy.headfirst.quackbehavior;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<< silence >>");
    }
}
