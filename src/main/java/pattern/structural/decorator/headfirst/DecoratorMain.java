package pattern.structural.decorator.headfirst;

import pattern.structural.decorator.headfirst.coffee.DarkRoast;
import pattern.structural.decorator.headfirst.coffee.Decaf;
import pattern.structural.decorator.headfirst.coffee.Espresso;
import pattern.structural.decorator.headfirst.coffee.HouseBlend;
import pattern.structural.decorator.headfirst.condiment.Milk;
import pattern.structural.decorator.headfirst.condiment.Mocha;
import pattern.structural.decorator.headfirst.condiment.Soy;
import pattern.structural.decorator.headfirst.condiment.Whip;

public class DecoratorMain {

    public static void main(String[] args) {
        Beverage beverage1 = new Espresso();
        printBeverage(beverage1);

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Milk(beverage2);
        beverage2 = new Whip(beverage2);
        printBeverage(beverage2);

        Beverage beverage3 = new HouseBlend();
        beverage3.setSize(Beverage.Size.GRANDE);
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        printBeverage(beverage3);

        Beverage beverage4 = new Decaf();
        beverage4.setSize(Beverage.Size.VENTI);
        beverage4 = new Soy(beverage4);
        printBeverage(beverage4);
    }

    private static void printBeverage(Beverage beverage) {
        System.out.printf("%s $%.2f%n", beverage.getDescription(), beverage.cost());
    }
}
