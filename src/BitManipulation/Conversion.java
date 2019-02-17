package BitManipulation;

public class Conversion {

    public static void main(String[] args) {
        System.out.println(conversion(29,15));

    }

    static int conversion(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }
        return count;
    }
}
