package pattern.structural.decorator.headfirst.condiment;

import pattern.structural.decorator.headfirst.Beverage;

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        double costBeforeCondiment = this.beverage.cost();

        return switch (this.getSize()) {
            case TALL -> costBeforeCondiment + 0.10;
            case GRANDE -> costBeforeCondiment + 0.15;
            case VENTI -> costBeforeCondiment + 0.20;
        };
    }
}
