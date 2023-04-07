package ltcd.intervalExercise;

import java.util.Arrays;

public class _252_会议室 {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }

        return true;
    }

}
