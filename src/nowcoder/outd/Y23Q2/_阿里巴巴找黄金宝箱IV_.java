package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 一贫如洗的椎夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0-N的子，
 * 每个箱子上面有一人数字，箱了排列成一个环，编号最大的箱子的下一个是编号为0的箱子。
 * 请输出每个箱了贴的数字之后的第一个比它大的数，如果不存在则输出-1。
 * 输入描述：
 * 	输入一个数字字串，数字之间使用逗号分隔，例如: 1,2,3,1
 * 	1≤ 字串中数字个数 ≤10000:
 * 	-100000≤每个数字值≤100000
 * 输出描述：
 * 	下一个大的数列表，以逗号分隔，例如: 2,3,6,-1,6
 *
 * 示例1：
 * 	输入：
 * 		2,5,2
 * 	输出：
 * 		5,-1,5
 * 说明：
 * 	第一个2的下一个更大的数是5；
 * 	数字5找不到下一个更大的数；
 * 	第二个2的下一个最大的数需要循环搜索，结果也是 5
 *
 * 示例2：
 * 	输入：
 * 		3,4,5,6,3
 * 	输出：
 * 		4,5,6,-1,4
 */
public class _阿里巴巴找黄金宝箱IV_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = split.length;
        int[] nums = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
            max = Math.max(max, nums[i]);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (max == nums[i]) {
                res[i] = -1;
                continue;
            }

            for (int j = 0; j < 2 * n; j++) {
                if (nums[i] < nums[j % n]) {
                    res[i] = nums[j];
                    break;
                }
            }
        }

        System.out.print(res[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(" " + res[i]);
        }

        // 单调栈做法
        System.out.println("\n单调栈做法");
        m1(nums);
    }

    private static void m1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        // 单调递减栈，栈中的元素保存数组的下标
        Deque<Integer> stack = new ArrayDeque<>();
        int length = nums.length;

        // 遍历两次数组 length * 2 - 1，即模拟出循环数组
        for (int i = 0; i < length * 2 - 1; i++) {
            // 如果当前元素 > 栈顶元素，则说明当前元素就是栈顶元素右边第一个比 (栈顶元素大的数)
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % length];
            }

            // 入栈
            stack.push(i % length);
        }


//        for (int i = n - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
//                Integer pop = stack.pop();
//                while (!stack.isEmpty()) {
//                    pop = stack.pop();
//                }
//                res[pop] = nums[i];
//            }
//
//            if (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
//                res[i] = nums[i];
//            }
//
//            // 入栈
//            stack.push(i);
//        }

        System.out.print(res[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(" " + res[i]);
        }
    }

}
