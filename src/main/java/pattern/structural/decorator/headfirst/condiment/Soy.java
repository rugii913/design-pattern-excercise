package pattern.structural.decorator.headfirst.condiment;

import pattern.structural.decorator.headfirst.Beverage;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double costBeforeCondiment = this.beverage.cost();

        return switch (this.getSize()) {
            case TALL -> costBeforeCondiment + 0.15;
            case GRANDE -> costBeforeCondiment + 0.20;
            case VENTI -> costBeforeCondiment + 0.25;
        };
    }
}
