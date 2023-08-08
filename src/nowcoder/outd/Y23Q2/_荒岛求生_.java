package nowcoder.outd.Y23Q2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * 有一个荒岛，只有左右两个港口，只有一座桥连接这两个港口，
 * 现在有一群人需要从两个港口逃生，有的人往右逃生，有的往左逃生，
 * 如果两个人相遇，则PK，体力值大的能够打赢体力值小的，体力值相同则同归干尽，赢的人才能继续往前逃生，并减少相应的体力
 *
 * 输入描述:
 * 	一行非 0 整数，用空格隔开，正数代表向右逃生，负数代表向左逃生
 * 输出描述:
 * 	最终能够逃生的人数
 * 示例1：
 * 	输入:
 * 		5 10 8 -8 -5
 * 	输出:
 * 		2
 * 说明:
 * 	8与-8 相遇，同归于尽，10 遇到-5，打赢并减少五点体力，最终逃生的为5，5，均从右侧港口逃生，输出2
 */
public class _荒岛求生_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 栈
        Deque<Integer> statck = new ArrayDeque<>();
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int cur = array[i];
            if (!statck.isEmpty() && statck.peekLast() * cur < 0) {
                if (cur > 0) {
                    while (!statck.isEmpty() && statck.peekLast() * cur < 0) {
                        Integer pollLast = statck.pollLast();
                        if (Math.abs(pollLast) > cur) {
                            cur = pollLast + cur;
                            break;
                        } else {
                            cur = cur - Math.abs(pollLast);
                        }
                    }
                } else {
                    while (!statck.isEmpty() && statck.peekLast() * cur < 0) {
                        Integer pollLast = statck.pollLast();
                        if (pollLast > -cur) {
                            cur = pollLast + cur;
                            break;
                        } else {
                            cur += pollLast;
                        }
                    }
                }
            }

            // 入栈
            if (cur != 0) {
                statck.offerLast(cur);
            }
        }

        System.out.println(statck.size());
    }

}
