package activities;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car() {
        tyres=4;
        doors=4;
    }

    public void displayCharacteristics() {
        System.out.println("Color is : " + color);
        System.out.println(("Transmission is : " + transmission));
        System.out.println("Make is :" + make);
        System.out.println("Tyres are : " + tyres);
        System.out.println("Doors are : " + doors);
    }

    public void accelerate() {
        System.out.println("The Car is moving");
    }

    public void brake() {
        System.out.println("The Car has stopped");
    }
}
