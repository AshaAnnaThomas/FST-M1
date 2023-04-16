package activities;

public class Activity7 {
    public static void main(String[] args) {

        MountainBike obj = new MountainBike(2, 10, 5);
        System.out.println(obj.bicycleDesc());
        System.out.println("The new speed after increment is : " + obj.speedUp(10));
        System.out.println("The new speed after applying brake is : " + obj.applyBrake(3));
    }

}
