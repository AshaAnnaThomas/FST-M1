package activities;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Activity9 {

    public static void main(String[] args) {

        ArrayList<String> myList = new ArrayList<>();
        myList.add("Asha");
        myList.add("Anna");
        myList.add("Thomas");
        myList.add("Serah");
        myList.add("Renju");

        for (String name : myList) {
            System.out.println(name);
        }

        System.out.println("The third name is : " + myList.get(2));

//        for (String name : myList) {
//            if (name.contains("Thomas")){
//                System.out.println("Thomas is present");
//            }
//        }
        //true or false
        System.out.println("Is Thomas Present : " + myList.contains("Thomas"));

        System.out.println("The number of names in the Array List is : " + myList.size());

        myList.remove(3);
        System.out.println("The number of names now in Array List is : " + myList.size());

    }
}
