package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class KEmptySlots {

    public static void main(String[] args) {
        int[] flowers = {1, 3, 2, };
        int[] flowers2 = {1, 2, 3, 4, 5, 7, 6};
        int[] flowers3 = {7, 4, 8};
        System.out.println(kEmptySlots(flowers2, 1));
    }

    public static int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> active = new TreeSet<>();
        int day = 0;
        for (int flower: flowers) {
            day++;
            active.add(flower);
            Integer lower = active.lower(flower);
            Integer higher = active.higher(flower);
            if (lower != null && flower - lower - 1 == k ||
                    higher != null && higher - flower - 1 == k)
                return day;
        }
        return -1;
    }
}
