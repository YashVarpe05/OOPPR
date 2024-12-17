abstract class Shape {
    protected double dimension1;
    protected double dimension2;

    public void inputDimensions(double d1, double d2) {
        this.dimension1 = d1;
        this.dimension2 = d2;
    }

    public abstract double computeArea();
}

class Triangle extends Shape {
    @Override
    public double computeArea() {
        return 0.5 * dimension1 * dimension2;
    }
}

class Rectangle extends Shape {
    @Override
    public double computeArea() {
        return dimension1 * dimension2;
    }
}

public class DynamicBindingDemo04 {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape rectangle = new Rectangle();

        triangle.inputDimensions(10, 5);
        System.out.println("Triangle Area: " + triangle.computeArea());

        rectangle.inputDimensions(8, 6);
        System.out.println("Rectangle Area: " + rectangle.computeArea());

        Shape[] shapes = { triangle, rectangle };
        System.out.println("\nDynamic Binding Demonstration:");
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.computeArea());
        }
    }
}