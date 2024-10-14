package Structural.bridge;

// Implementor interface
interface Color {
    void fillColor();
}

// Abstraction
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}

// Refined Abstraction
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Circle filled with ");
        color.fillColor();
    }
}

// Concrete Implementors
class RedColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("red color.");
    }
}

class BlueColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("blue color.");
    }
}

public class BridgeDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        redCircle.applyColor(); // Output: Circle filled with red color.

        Shape blueCircle = new Circle(new BlueColor());
        blueCircle.applyColor(); // Output: Circle filled with blue color.
    }
}
