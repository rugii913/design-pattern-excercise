package pattern.structural.decorator.headfirst.coffee;

import pattern.structural.decorator.headfirst.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        this.description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return switch (this.getSize()) {
            case TALL -> 0.99;
            case GRANDE -> 1.19;
            case VENTI -> 1.39;
        };
    }
}
