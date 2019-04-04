package RecursionAndDynamicProgramming;

public class MagicIndex {

    public static void main(String[] args) {
        int[] arr = new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int[] arr2 = new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(magicFast2(arr2));
    }

    private static int magicFast(int[] arr) {
        return magicFast(arr, 0, arr.length - 1);
    }

    private static int magicFast(int[] array, int start, int end) {
        if (end < start) return -1;
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    private static int magicFast2(int[] array) {
        return magicFast2(array, 0, array.length - 1);
    }

    private static int magicFast2(int[] array, int start, int end) {
        if (end < start) return -1;

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }

        /* Search Left */
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast2(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        /* Search right */
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast2(array, rightIndex, end);

        return right;
    }


}
