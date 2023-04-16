package activities;

public class Activity3 {

    public static void main (String[] args) {

        double seconds = 1000000000;
        double earthSec = 31557600;
        double mercurySec = 0.2408467;
        double venusSec = 0.61519726;
        double marsSec = 1.8808158;
        double jupiterSec = 11.862615;
        double saturnSec = 29.447498;
        double uranusSec = 84.016846;
        double neptuneSec = 164.79132;

        System.out.println("The age on Mercury is : " + ageOnOtherPlanet(mercurySec, earthSec, seconds));
        System.out.println("The age on Venus is : " + ageOnOtherPlanet(venusSec, earthSec, seconds));
        System.out.println("The age on Earth is : " + ageOnEarth(earthSec, seconds));
        System.out.println("The age on Mars is : " + ageOnOtherPlanet(marsSec, earthSec, seconds));
        System.out.println("The age on Jupiter is : " + ageOnOtherPlanet(jupiterSec, earthSec, seconds));
        System.out.println("The age on Saturn is : " + ageOnOtherPlanet(saturnSec, earthSec, seconds));
        System.out.println("The age on Uranus is : " + ageOnOtherPlanet(uranusSec, earthSec, seconds));
        System.out.println("The age on Neptune is : " + ageOnOtherPlanet(neptuneSec, earthSec, seconds));
    }

    public static double ageOnOtherPlanet(double mercSec, double earSec, double ageSec) {

             double age = ageSec/earSec/mercSec;
             return age;

    }

    public static double ageOnEarth(double earSec, double ageSec) {

        double age = ageSec/earSec;
        return age;

    }
}
