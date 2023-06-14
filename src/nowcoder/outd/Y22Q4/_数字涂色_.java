package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。
 * 黑板上已经写上了 N 个正整数，同学们需要给这 每个数分别上一种颜色。
 * 为了让黑板报既美观又有学习意义，老师要求 同种颜色的所有数都可以被这种颜色中最小的那个数整除。
 * 现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这 N 个数进行上色。
 * 输入描述：
 * 第一行有一个正整数 N，其中。
 * 第二行有 N个int型数(保证输入数据在[1,100]范围中)，表示黑板上各个正整数的值。
 * 输出描述：
 * 输出只有一个整数，为最少需要的颜色种数。
 *
 * 示例1：
 * 	输入:
 * 		3
 * 		2 4 6
 * 	输出:
 * 		1
 * 说明:所有数都能被2整除
 *
 * 示例2:
 * 	输入:
 * 		4
 * 		2 3 4 9
 * 	输出:
 * 		2
 * 说明: 2与4涂一种颜色，4能被2整除；
 * 	  3与9涂另一种颜色，9能被3整除。
 * 	  不能4个数涂同一个颜色，因为3与9不能被2整除。
 * 	  所以最少的颜色是两种。
 *
 * 示例3：
 *  输入：
 *      7
 *      58 14 20 67 41 4 63
 *  输出：
 *      6
 */
public class _数字涂色_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        String[] origin = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(origin[i]);

            // 如果出现数字 1，直接返回结果，因为所有正整数都可以被 1 整除
            if (nums[i] == 1) {
                System.out.println(1);
                return;
            }
        }

        // 排序
        Arrays.sort(nums);
        // 存放不能被整除的数
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                // 当前数和上一个相等，则跳过
                continue;
            }

            // 标记该数是否能够被他小的某个数整除
            boolean flag = false;
            int cur = nums[i];

            for (int j = 0; j < res.size(); j++) {
                if (cur % res.get(j) == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                res.add(cur);
            }
        }

        System.out.println(res.size());
    }

}
