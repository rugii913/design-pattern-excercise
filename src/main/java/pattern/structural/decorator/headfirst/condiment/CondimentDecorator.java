package pattern.structural.decorator.headfirst.condiment;

import pattern.structural.decorator.headfirst.Beverage;

public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;

    @Override
    public abstract String getDescription(); // 모든 subtype에서 새로 구현하도록 하기 위해 abstract method로 재정의

    @Override
    public Size getSize() {
        return this.beverage.getSize(); // CondimentDecorator에서 별도로 setSize를 호출하지 않을 것이므로 감싸고 있는 Beverage의 size를 가져오게 함
    }
}
