package pattern.structural.decorator.headfirst;

import pattern.structural.decorator.headfirst.coffee.DarkRoast;
import pattern.structural.decorator.headfirst.coffee.Espresso;
import pattern.structural.decorator.headfirst.coffee.HouseBlend;
import pattern.structural.decorator.headfirst.condiment.Milk;
import pattern.structural.decorator.headfirst.condiment.Mocha;
import pattern.structural.decorator.headfirst.condiment.Soy;
import pattern.structural.decorator.headfirst.condiment.Whip;

public class DecoratorMain {

    public static void main(String[] args) {
        Beverage beverage1 = new Espresso();
        System.out.printf("%s $%.2f%n", beverage1.getDescription(), beverage1.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Milk(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.printf("%s $%.2f%n", beverage2.getDescription(), beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.printf("%s $%.2f%n", beverage3.getDescription(), beverage3.cost());
    }
}
