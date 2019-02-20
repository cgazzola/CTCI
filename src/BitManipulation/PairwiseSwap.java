package BitManipulation;

public class PairwiseSwap {

    public static void main(String[] args) {
        int x = 13;
        System.out.println(Integer.toBinaryString(x));
        int result = swap(x);
        System.out.println(Integer.toBinaryString(result));
    }

    public static int swap(int x) {
        return ( ((x & 0xaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }
}
