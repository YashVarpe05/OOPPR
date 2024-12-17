// Abstract base class
abstract class Car {
    protected String type;

    public abstract void allocateAccessories();

    public abstract void assembleBody();

    public abstract void paintBody();

    public abstract void finalMakeup();

    public void manufacture() {
        allocateAccessories();
        assembleBody();
        paintBody();
        finalMakeup();
        System.out.println(type + " car manufactured successfully!");
    }
}

class Hatchback extends Car {
    public Hatchback() {
        type = "Hatchback";
    }

    @Override
    public void allocateAccessories() {
        System.out.println("Allocating Hatchback accessories");
    }

    @Override
    public void assembleBody() {
        System.out.println("Assembling Hatchback body");
    }

    @Override
    public void paintBody() {
        System.out.println("Painting Hatchback body");
    }

    @Override
    public void finalMakeup() {
        System.out.println("Final makeup for Hatchback");
    }
}

class Sedan extends Car {
    public Sedan() {
        type = "Sedan";
    }

    @Override
    public void allocateAccessories() {
        System.out.println("Allocating Sedan accessories");
    }

    @Override
    public void assembleBody() {
        System.out.println("Assembling Sedan body");
    }

    @Override
    public void paintBody() {
        System.out.println("Painting Sedan body");
    }

    @Override
    public void finalMakeup() {
        System.out.println("Final makeup for Sedan");
    }
}

class SUV extends Car {
    public SUV() {
        type = "SUV";
    }

    @Override
    public void allocateAccessories() {
        System.out.println("Allocating SUV accessories");
    }

    @Override
    public void assembleBody() {
        System.out.println("Assembling SUV body");
    }

    @Override
    public void paintBody() {
        System.out.println("Painting SUV body");
    }

    @Override
    public void finalMakeup() {
        System.out.println("Final makeup for SUV");
    }
}

class CarFactory {
    public Car createCar(String carType) {
        switch (carType.toLowerCase()) {
            case "hatchback":
                return new Hatchback();
            case "sedan":
                return new Sedan();
            case "suv":
                return new SUV();
            default:
                throw new IllegalArgumentException("Unknown car type: " + carType);
        }
    }
}

public class FactoryPatternTest10 {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        Car hatchback = factory.createCar("Hatchback");
        hatchback.manufacture();

        Car sedan = factory.createCar("Sedan");
        sedan.manufacture();

        Car suv = factory.createCar("SUV");
        suv.manufacture();
    }
}