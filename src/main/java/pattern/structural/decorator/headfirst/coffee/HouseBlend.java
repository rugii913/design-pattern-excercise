package pattern.structural.decorator.headfirst.coffee;

import pattern.structural.decorator.headfirst.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return switch (this.getSize()) {
            case TALL -> 0.89;
            case GRANDE -> 1.09;
            case VENTI -> 1.29;
        };
    }
}
