interface Vehicle {
    void changeGear(int newGear);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}

class Bicycle implements Vehicle {
    private int speed;
    private int gear;

    public Bicycle() {
        this.speed = 0;
        this.gear = 1;
    }

    @Override
    public void changeGear(int newGear) {
        if (newGear > 0 && newGear <= 5) {
            this.gear = newGear;
            System.out.println("Bicycle Gear changed to: " + gear);
        } else {
            System.out.println("Invalid gear for Bicycle");
        }
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bicycle speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        speed = Math.max(0, speed - decrement);
        System.out.println("Bicycle speed reduced to: " + speed);
    }

    public void display() {
        System.out.println("Bicycle - Current Speed: " + speed + ", Gear: " + gear);
    }
}

class Bike implements Vehicle {
    private int speed;
    private int gear;

    public Bike() {
        this.speed = 0;
        this.gear = 1;
    }

    @Override
    public void changeGear(int newGear) {
        if (newGear > 0 && newGear <= 6) {
            this.gear = newGear;
            System.out.println("Bike Gear changed to: " + gear);
        } else {
            System.out.println("Invalid gear for Bike");
        }
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bike speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        speed = Math.max(0, speed - decrement);
        System.out.println("Bike speed reduced to: " + speed);
    }

    public void display() {
        System.out.println("Bike - Current Speed: " + speed + ", Gear: " + gear);
    }
}

class Car implements Vehicle {
    private int speed;
    private int gear;

    public Car() {
        this.speed = 0;
        this.gear = 1;
    }

    @Override
    public void changeGear(int newGear) {
        if (newGear > 0 && newGear <= 5) {
            this.gear = newGear;
            System.out.println("Car Gear changed to: " + gear);
        } else {
            System.out.println("Invalid gear for Car");
        }
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Car speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        speed = Math.max(0, speed - decrement);
        System.out.println("Car speed reduced to: " + speed);
    }

    public void display() {
        System.out.println("Car - Current Speed: " + speed + ", Gear: " + gear);
    }
}

public class VehicleInterfaceDemo05 {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        Bike bike = new Bike();
        Car car = new Car();

        System.out.println("Bicycle Operations:");
        bicycle.changeGear(2);
        bicycle.speedUp(10);
        bicycle.display();
        bicycle.applyBrakes(5);
        bicycle.display();

        System.out.println("\nBike Operations:");
        bike.changeGear(3);
        bike.speedUp(20);
        bike.display();
        bike.applyBrakes(10);
        bike.display();

        System.out.println("\nCar Operations:");
        car.changeGear(4);
        car.speedUp(30);
        car.display();
        car.applyBrakes(15);
        car.display();
    }
}