package BitManipulation;

public class Insertion {

    public static void main(String[] args) {
        int n = Integer.parseInt("10000000000", 2);
        int m = Integer.parseInt("10011", 2);

        int x = updateBits(n, m, 2, 6);

        System.out.println(Integer.toBinaryString(x));
    }

    static int updateBits(int n, int m, int i, int j) {
        /* Create a mask to clear bits i through j in n. Example: i = 2, j = 4.
        Result should be 11100011. For simplicity, we'll use just 8 bits for the example. */

        int allOnes = ~0; // will equal sequence of all 1s

        // 1s before position j, then 0s. left = 11100000
        int left = allOnes << (j + i);

        // 1's after position i. right = 00000011
        int right = ((1 << 1) - 1);

        // All 1s, except for 0s between i and j. mask = 11100011
        int mask = left | right;

        /* Clear bits j through i then put m in there */
        int n_cleared = n & mask; // Clear bits j through i

        System.out.println(n_cleared);

        int m_shifted = m << i; // Move m into correct position.

        return n_cleared | m_shifted; // OR them, and we're done!
    }
}
