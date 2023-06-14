package nowcoder.outd.Y22Q4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 在学校中，N 个小朋友站成一队， 第 i 个小朋友的身高为 height[i]，
 * 第 i 个小朋友可以看到的第一个比自己身高更高的小朋友 j ，那么 j 是 i 的好朋友(要求j > i)。
 * 请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，请在该位置用0代替。
 * 小朋友人数范围是 [0, 40000]。
 * 输入描述：
 * 	第一行输入 N，表示有 N 个小朋友
 * 	第二行输入 N 个小朋友的身高 height[i]，都是整数
 * 输出描述：
 * 	输出N个小朋友的好朋友的位置
 * 示例1：
 * 	输入：
 * 		2
 * 		100 95
 * 	输出：
 * 		0 0
 * 说明：
 * 	第一个小朋友身高100，站在队尾位置，向队首看，没有比他身高高的小朋友，所以输出第一个值为0。
 * 	第二个小朋友站在队首，前面也没有比他身高高的小朋友，所以输出第二个值为0。
 *
 * 示例2：
 * 	输入：
 * 		8
 * 		123 124 125 121 119 122 126 123
 * 	输出：
 * 		1 2 6 5 5 6 0 0
 * 说明：
 * 	123的好朋友是1位置上的124
 * 	124的好朋友是2位置上的125
 * 	125的好朋友是6位置上的126
 * 	以此类推
 */
public class _找朋友_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // 如果栈顶的元素比当前小，则弹出
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                stack.pop();
            }

            // 如果栈为空，则说明右边没有比当前数大的数
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek();
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
