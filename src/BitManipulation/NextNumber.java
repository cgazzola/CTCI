package BitManipulation;

public class NextNumber {

    public static void main(String[] args) {

        int num = 13948;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(getNext(num)));
    }

    static int getNext(int n) {
        /* Compute c0 and c1 */
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && c != 0) {
            c0++;
            c >>= 1;
        }
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        /* Error: if n == 11..1100...00, then there is no bigger number with the same
         number of 1s
          */
        int p = c0 + c1; // position of rightmost non-trailing zero
        n |= (1 << p); // Flip rightmost non-trailing zero
        n &= ~((1 << p) - 1); // Clear all bits to the right of p
        n |= (1 << (c1 - 1)) - 1; // Insert (c1-1) ones on hte right
        return n;


    }
}
