package activities;

public class Activity1 {

    public static void main (String[] args) {

        Car ritz = new Car();

        ritz.make = 2014;
        ritz.color = "Black";
        ritz.transmission = "Manual";

        ritz.displayCharacteristics();

        ritz.accelerate();
        ritz.brake();
    }



}
