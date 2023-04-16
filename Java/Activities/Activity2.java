package activities;

public class Activity2 {

    public static void main(String[] args) {

        int[] numArr = new int[] {10, 77, 10, 54, -11, 10};

        checkIfSame(numArr);
    }

    public static void checkIfSame(int[] numArr) {
             int temp = 0;

            for (int i=0; i<numArr.length; i++) {

                if (numArr[i] ==10) {
                    temp = temp + numArr[i];
                }

            }

            if (temp==30) {
                System.out.println("The Value is 30");
            }
    }
}
