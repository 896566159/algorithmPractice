package ltcd.sort;

import java.util.Arrays;

public class _2418_按身高排序 {

    public String[] sortPeople(String[] names, int[] heights) {
        Object[][] arr = new Object[names.length][2];

        for (int i = 0; i < names.length; i++) {
            arr[i][0] = heights[i];
            arr[i][1] = names[i];
        }

        Arrays.sort(arr, (a, b) -> {
            return (Integer) b[0] - (Integer)a[0];
        });

        for (int i = 0; i < names.length; i++) {
            names[i] = (String) arr[i][1];
        }

        return names;
    }

}
