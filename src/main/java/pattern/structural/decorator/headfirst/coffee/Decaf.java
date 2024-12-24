package pattern.structural.decorator.headfirst.coffee;

import pattern.structural.decorator.headfirst.Beverage;

public class Decaf extends Beverage {

    public Decaf() {
        this.description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return switch (this.getSize()) {
            case TALL -> 1.05;
            case GRANDE -> 1.15;
            case VENTI -> 1.35;
        };
    }
}
