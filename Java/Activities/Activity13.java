package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Random indexGen = new Random();

        System.out.println("Enter numbers");
        System.out.println("(EOF or non-integer to terminate): ");

        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        Integer nums[] = list.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);

        System.out.println("value generated :" + index);
        System.out.println("value at that index value :" + nums[index]) ;
    }
}
