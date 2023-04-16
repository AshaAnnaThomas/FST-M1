package activities;

public class Activity4 {

    public static void main (String[] args) {

        int[] num = new int[] {9,1,5,8,3};

        System.out.print("Elements before sorting : " );
        printArray(num);

        sortInAsc(num);
    }

    public static void printArray(int[] numArr) {

        for (int i = 0 ; i<numArr.length; i++) {

            System.out.print(numArr[i] + ", ");
        }

        System.out.println();
    }


    public static void sortInAsc(int[] arrData) {

        int temp = 0;

            for (int i = 0; i<arrData.length; i++){
                for(int j = i + 1; j < arrData.length; j ++) {

                    if (arrData[i] > arrData[j]) {
                        temp = arrData[i];
                        arrData[i] = arrData[j];
                        arrData[j] = temp;
                    }
                }
            }

            System.out.print("Elements after sorting is : " );
            printArray(arrData);

    }


    /**
     *  1. 9>1 a[0] >a[1]
     *  temp = 9
     *  a[0] = 1
     *  a[1] = 9
     *  1, 9, 5, 8, 3
     *
     *  2. a[0] , a[2] --> 1<5
     *  3. a[0], a[3] ---> 1 < 8
     *  4. a[0], a[4] ---> 1<3
     *
     *  5. a[1], a[2] --> 9 > 5
     *  temp = 9
     *  a[1] = 5
     *  a[2] = 9
     *  1, 5, 9, 8, 3
     *
     *  6. a[1], a[2] ---> 5 <9
     *  7. a[1], a[3] ---> 5 <8
     *  8. a[1], a[4] ---> 5 > 3
     *  temp = 5
     *  a[1] = 3
     *  a[4] = 5
     *  1, 3, 9, 8, 5
     *
     *
     *
     *
     *
     */
}
