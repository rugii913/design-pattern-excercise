package pattern.structural.decorator.headfirst;

public abstract class Beverage {

    protected Size size = Size.TALL;

    protected String description = "Unknown Beverage";

    public String getDescription() {
        return String.format("%s %s", this.size, this.description);
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    public abstract double cost();

    public enum Size { TALL, GRANDE, VENTI }
}
