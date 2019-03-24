package RecursionAndDynamicProgramming;

import java.util.Arrays;

public class TripleStep {

    public static void main(String[] args) {
        System.out.print(countWays(4));
    }

    public static int waysRecursive(int n) {
        if (n < 0) return 0;
        if (n == 1) return 1; // 1
        if (n == 2) return 2; // 1+1, 2
        if (n == 3) return 4; // 1+1+1, 1+2, 2+1, 3
        return waysRecursive(n - 3) + waysRecursive(n - 2) + waysRecursive(n - 1);
    }

    public static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    public static int countWays(int n, int[] memo) {
        if ( n < 0) return 0;
        else if (n == 0) return 1;
        else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
        }
        return memo[n];
    }
}
