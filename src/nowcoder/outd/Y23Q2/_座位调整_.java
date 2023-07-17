package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 疫情期间课堂的座位进行了特殊的调整，不能出现两个同学紧挨着，必须隔至少一个空位
 * 给你一个整数数组 desk 表示当前座位的占座情况，由若干 0 和 1 组成，其中 0 表示没有占位，1 表示占位。
 * 在不改变原有座位秩序情况下，还能安排坐几个人?
 *
 * 输入描述:
 * 	第一行是个了数组表示作为占座情况，由若干 0 和 1 组成，其中 0 表示没有占位，1 表示占位
 * 输出描述:
 * 	输出数值表示还能坐几个人
 * 补充说明: 1 <= desk.length <= 2 * 10^4
 *
 * 示例1
 * 	输入:
 * 		1,0,0,0,1
 * 	输出:
 * 		1
 * 说明: 只有desk[2]的位置可以坐一个人
 */
public class _座位调整_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = split.length;
        int[] nums = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int right = i + 1;

                while (right < n + 1 && nums[right] == 0 && nums[right + 1] == 0) {
                    right += 2;
                    res++;
                }

                i = right;
            }
        }

        System.out.println(res);
    }

}
