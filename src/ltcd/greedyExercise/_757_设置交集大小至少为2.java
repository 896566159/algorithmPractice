package ltcd.greedyExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _757_设置交集大小至少为2 {

    public static void main(String[] args) {
        System.out.println(new _757_设置交集大小至少为2().intersectionSizeTwo(new int[][]{{2,10},{3,7},{3,15},{4,11},{6,12},{6,16},{7,8},{7,11},{7,15},{11,12}}));
//        System.out.println(new _757_设置交集大小至少为2().intersectionSizeTwo1(new int[][]{{3,13},{2,8},{5,10}}));
//        System.out.println(new _757_设置交集大小至少为2().intersectionSizeTwo1(new int[][]{{7,16},{3,12},{7,16},{2,15},{14,19}}));
    }

    public int intersectionSizeTwo1(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }

        int index = 0;
        int count = 0;

        while (index < list.size()) {
            int[] tmp = list.get(index);
            boolean del = false;

            for (int i = 0; i < list.size(); i++) {
                if (i == index) {
                    continue;
                }

                if (tmp[0] <= list.get(i)[0] && tmp[1] >= list.get(i)[1]) {
                    tmp = list.get(i);
                    list.remove(index);
                    del = true;
                    count--;
                    break;
                }
            }

            if (count++ > list.size()) {
                break;
            }
            index = del ? index + 1 : index == 0 ? index + 1 : 0;
        }

        int ans = 2;
        int end = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] > end) {
                ans += 2;
            } else if (list.get(i)[0] == end){
                ans++;
            }

            end = Math.min(list.get(i)[1], end);
        }

        return ans;
    }

    public int intersectionSizeTwo(int[][] intervals) {

        Arrays.sort(intervals, (a, b)->a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int ans = 2;
        int firstBiggest = intervals[0][1];
        int secondBiggest = Math.max(intervals[0][0], intervals[0][1] - 1);

        for (int i = 1; i < intervals.length; i++) {
            //没有重叠
            if (intervals[i][0] > firstBiggest) {
                ans += 2;
                firstBiggest = intervals[i][1];
                secondBiggest = Math.max(intervals[i][0], intervals[i][1] - 1);
            } else {//有重叠部分
                if (intervals[i][0] <= secondBiggest && firstBiggest <= intervals[i][1]) {//包含两个指针
                    continue;
                } else if (intervals[i][0] > secondBiggest) {//包含较大的指针
                    secondBiggest = firstBiggest == intervals[i][1] ? intervals[i][1] - 1 : firstBiggest;
                    firstBiggest = intervals[i][1];
                } else if (intervals[i][1] < firstBiggest) {//包含较小的指针
                    secondBiggest = firstBiggest;
                    firstBiggest = intervals[i][1];
                }
                ans++;
            }
        }

        return ans;
    }

}
