package pattern.structural.decorator.headfirst.condiment;

import pattern.structural.decorator.headfirst.Beverage;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        double costBeforeCondiment = this.beverage.cost();

        return switch (this.getSize()) {
            case TALL -> costBeforeCondiment + 0.20;
            case GRANDE -> costBeforeCondiment + 0.25;
            case VENTI -> costBeforeCondiment + 0.30;
        };
    }
}
