package ltcd.timeExercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _539_最小时间差 {

    public int findMinDifference(List<String> timePoints) {

        int min = Integer.MAX_VALUE;
        int[] time = new int[timePoints.size()];
        int index = 0;

        for (int k = 0; k < timePoints.size(); k++) {
            Integer h = Integer.valueOf(timePoints.get(k).split(":")[0]);
            Integer m = Integer.valueOf(timePoints.get(k).split(":")[1]);

            time[index] = h * 60 + m;
            index++;
        }

        Arrays.sort(time);
        int p = 12 * 60;
        int abs = Math.abs(time[0] - time[time.length - 1]);
        if (abs > p) {
            min = abs % 1438 > p ? 1440 - abs : abs % 1438;
        } else {
            min = abs;
        }

        for (int i = 1; i < time.length; i++) {
            abs = Math.abs(time[i] - time[i - 1]);
            abs = abs % 1438 > p ? 1440 - abs : abs % 1438;
            min = Math.min(min, abs);
        }

        return min;
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("04:00");
        list.add("22:00");
        list.add("00:00");
        new _539_最小时间差().findMinDifference(list);
    }

}
