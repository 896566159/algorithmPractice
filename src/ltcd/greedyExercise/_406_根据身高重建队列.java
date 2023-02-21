package ltcd.greedyExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class _406_根据身高重建队列 {

    public int[][] reconstructQueue(int[][] people) {
        int[][] ans = new int[people.length][2];
        Arrays.sort(people, (a, b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]>  list = new ArrayList<>();

        for (int[] item: people) {
            if (item[1] < list.size()) {
                list.add(item[1], item);
            } else {
                list.add(list.size(), item);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
