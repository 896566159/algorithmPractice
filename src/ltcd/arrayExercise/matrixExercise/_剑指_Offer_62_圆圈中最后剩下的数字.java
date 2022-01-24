package ltcd.arrayExercise.matrixExercise;

import java.util.*;

public class _剑指_Offer_62_圆圈中最后剩下的数字 {

    public int lastRemaining(int n, int m) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, true);
        }

        int index = -1;
        for (int i = 0; i < n - 1; i++) {
            index = (index + m) % n;

            for (int j = index; j >= 0;) {
                if (map.get(j)) {
                    j--;
                }
                j = j++ % n;
            }

            map.put(index, false);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new _剑指_Offer_62_圆圈中最后剩下的数字().lastRemaining(5, 3));
    }
}
