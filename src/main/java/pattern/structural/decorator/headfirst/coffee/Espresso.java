package pattern.structural.decorator.headfirst.coffee;

import pattern.structural.decorator.headfirst.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return switch (this.getSize()) {
            case TALL -> 1.99;
            case GRANDE -> 2.19;
            case VENTI -> 2.39;
        };
    }
}
