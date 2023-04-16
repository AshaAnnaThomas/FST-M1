package activities;

public class Bicycle implements BicycleParts, BicycleOperations{

    int gears;
    int currentSpeed;
    Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }
    @Override
    public int applyBrake(int decrement) {
        return( currentSpeed = currentSpeed - decrement);
    }

    @Override
    public int speedUp(int increment) {
       return (currentSpeed = currentSpeed + increment);
    }

    public String bicycleDesc() {

        return ("The gear is : " + gears + " and the Speed of the bicycle is : " + currentSpeed);
    }
}
