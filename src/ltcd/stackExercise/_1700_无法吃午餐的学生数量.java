package ltcd.stackExercise;

import java.util.ArrayList;
import java.util.List;

public class _1700_无法吃午餐的学生数量 {

    // 三明治必须按顺序吃，但是人的顺序可以任意，因此只需要找到这样一个三明治的位置：就是喜欢此时的三明治种类的人在队中已经不存在了，此时这个三明治永远不会被吃掉，那么此时剩下的人吃不上
    public static int countStudents1(int[] students, int[] sandwiches) {
        int countZero = 0;
        int countOne = 0;

        //统计学生中喜欢吃方形和圆形的同学数量
        for (int student : students) {
            if (student == 0) {
                countZero++;
            } else {
                countOne++;
            }
        }

        int ans = 0;
        while (ans < sandwiches.length) {
            //如果当前三明治是圆形，判断还没有吃的学生中是否还有喜欢吃圆形的
            if (sandwiches[ans] == 0) {
                countZero--;
                if (countZero < 0) {
                    break;
                }
            } else {
                //如果当前三明治是方形，判断还没有吃的学生中是否还有喜欢吃方形的
                countOne--;
                if (countOne < 0) {
                    break;
                }
            }

            ans++;
        }

        return sandwiches.length - ans;
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;

        for (int student : students) {
            list.add(student);
        }

        while (idx < sandwiches.length) {
            int tmp = sandwiches.length - idx;
            int count = list.size();

            while (tmp > 0) {
                Integer first = list.get(0);
                list.remove(0);
                if (sandwiches[idx] == first) {
                    idx++;
                } else {
                    list.add(first);
                }
                tmp--;
            }

            if (count == list.size()) {
                break;
            }
        }

        return sandwiches.length - idx;
    }

}
