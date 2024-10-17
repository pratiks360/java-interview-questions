package Creational.prototype;

class Shape implements Cloneable {
    private String type;

    public Shape(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // Returns a shallow copy of the object
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Shape original = new Shape("Circle");
            Shape copy = (Shape) original.clone();

            System.out.println("Original: " + original.getType());  // Circle
            System.out.println("Copy: " + copy.getType());          // Circle

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
