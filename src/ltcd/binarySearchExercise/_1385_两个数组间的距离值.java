package ltcd.binarySearchExercise;

import java.util.Arrays;

public class _1385_两个数组间的距离值 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;

        for (int i = 0; i < arr1.length; i++) {
            boolean f = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) < d) {
                    f = false;
                    break;
                }
            }
            if (f) {
                ans++;
            }
        }

        return ans;
    }

}
