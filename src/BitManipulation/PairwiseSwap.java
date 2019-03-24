package BitManipulation;

public class PairwiseSwap {

    public static void main(String[] args) {

    }

    public static int swap(int x) {
        return (((x & 0xaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }
}
