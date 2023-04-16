package activities;

import java.util.ArrayList;
import java.util.Date;

public class Plane {

    private int maxPassengers;
    private ArrayList<String> pass;
    private Date takeOffTime;
    private Date landedTime;

    Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        pass = new ArrayList<>();

    }

    public void onboard(String newPass) {
        pass.add(newPass);
    }

    public Date takeOff() {
        return takeOffTime = new Date();
    }

    public void land() {
        landedTime = new Date();
        this.pass.clear();
;    }

    public Date getLastTimeLanded() {
        return landedTime;
    }

    public ArrayList<String> getPassengers() {
        return pass;
    }

}
