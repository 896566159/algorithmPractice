package ltcd.timeExercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _2409_统计共同度过的日子数 {

    private static final int[] DAYS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int calcDays(String S) {
        char[] s = S.toCharArray();
        int day = (s[3] - '0') * 10 + s[4] - '0';
        int month = (s[0] - '0') * 10 + s[1] - '0';

        // 除了最后一个月份，前面的月份直接累加
        for (int i = 0; i < month - 1; ++i) {
            day += DAYS[i];
        }
        return day;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int left = calcDays(arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob); // 直接比较字符串再计算
        int right = calcDays(leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob);
        return Math.max(right - left + 1, 0); // 答案不能为负数
    }

}
