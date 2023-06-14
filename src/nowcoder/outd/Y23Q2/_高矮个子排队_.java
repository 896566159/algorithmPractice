package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 现在有一队小朋友，他们高矮不同，我们以 正整数数组Q 表示这一队小朋友的身高，如数组 {5,3,1,2,3}
 * 我们现在希望小朋友排队，以“高”“矮”“高”“矮”顺序排列,每一个“高”位置的小朋友要比相邻的位置高或者相等；
 * 每一个“矮”位置的小朋友要比相邻的位置矮或者相等；
 * 要求小朋友们移动的距离和最小，第一个从“高”位开始排，输出最小移动距离即可。
 * 移动距离的定义如下所示：第二位小朋友移到第三位小朋友后面，移动距离为 1，若移动到第四位小朋友后面，移动距离为 2。
 *
 * 输入描述:
 *  排序前的小朋友，以英文空格的正整数：4 3 5 7 8
 *  小朋友 < 100个
 * 输出描述:
 *  排序后的小朋友，以英文空格分割的正整数：4 3 7 5 8
 *  输出结果为最小移动距离，只有 5 和 7 交换了位置，移动距离都是 1
 * 输入:
 *  4 3 5 7 8
 * 输出:
 *  4 3 7 5 8
 * 输入:
 *  1 1 1 1 1
 * 输出:
 *  1 1 1 1 1
 *  说明: 相邻位置可以相等
 * 输入:
 *  xxx
 * 输出:
 *  []
 *  说明: 出现非法参数情况，返回空数组
 */
public class _高矮个子排队_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] arr = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            char[] chars = split[i].toCharArray();
            for (char c : chars) {
                if (c < '0' || c > '9') {
                    System.out.println("[]");
                    return;
                }
            }

            arr[i] = Integer.parseInt(split[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            // 规则：偶数位大，奇数位小
            if (i % 2 == 0) {
                if (i + 1 < arr.length && arr[i] < arr[i + 1]) {
                    // 交换
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            } else {
                if (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                    // 交换
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}
