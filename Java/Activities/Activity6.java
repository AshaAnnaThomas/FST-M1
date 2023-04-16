package activities;

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {

        Plane plane = new Plane(10);

        plane.onboard("Asha");
        plane.onboard("Anna");
        plane.onboard("Thomas");
        plane.onboard("Serah");
        plane.onboard("Mariam");
        plane.onboard("Alex");
        plane.onboard("Renju");
        plane.onboard("Jacob");
        plane.onboard("Mannah");
        plane.onboard("Elsa");

        System.out.println("The take off time is : " + plane.takeOff());

        System.out.println(plane.getPassengers());

        Thread.sleep(5000);

        plane.land();

        System.out.println("The last time landed :" + plane.getLastTimeLanded());

        System.out.println("People in plane after landing : " + plane.getPassengers());


    }
}
