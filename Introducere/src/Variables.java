public class Variables {

    public static void main(String[] args) {
        int number = 5;
        String course = "testing";
        char letter = 'N';
        double dec = -0.9;
        boolean test = true;

        System.out.println("This is my first " + course + " course!");

        if (dec >= 0) {
            System.out.println("This is my first " + course + " course!");
        }
        else {
            System.out.println(letter);
        }

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 6;
        arr[3] = 5;
        arr[4] = 9;

        System.out.println(arr[0]);

        int[] arr2 = {1, 3, 3};
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr2[2]);
    }
}
