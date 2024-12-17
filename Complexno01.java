class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        real = 0;
        imaginary = 0;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(
                this.real + other.real,
                this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(
                this.real - other.real,
                this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        return new Complex(
                (this.real * other.real) - (this.imaginary * other.imaginary),
                (this.real * other.imaginary) + (this.imaginary * other.real));
    }

    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }
}

public class Complexno01 {
    public static void main(String[] args) {
        Complex c1 = new Complex(2.3, 4.5);
        Complex c2 = new Complex(3.4, 5.0);

        Complex sum = c1.add(c2);
        Complex difference = c1.subtract(c2);
        Complex product = c1.multiply(c2);

        System.out.println("First Complex Number: " + c1);
        System.out.println("Second Complex Number: " + c2);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
    }
}
