package activities;

public class Activity8 {

    public static void main(String[] args) {
        try {
            exceptionTest("Good Morning ! Happy Friday !!");
        } catch (Exception e) {
            System.out.println("Exception caught here" + e.getMessage());
        }

        try {
            exceptionTest(null);
            exceptionTest("This text wont execute");
        } catch (Exception e) {
            System.out.println("Exception caught here" + e.getMessage());
        }

    }

    public static void exceptionTest(String str) throws  CustomException {
        if (str == null) {
            throw new CustomException(" The string value is null") ;
        } else {
            System.out.println(str);
        }
    }
}
