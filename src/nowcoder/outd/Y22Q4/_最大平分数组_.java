package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个数组nums，可以将元素分为若干个组，使得每组和相等，求出满足条件的所有分组中，最大的平分组个数。
 *
 * 输入描述：
 * 	第一行输入 m
 * 	接着输入 m 个数，表示此数组
 * 	数据范围:1<=M<=50, 1<=nums[i]<=50
 *
 * 输出描述：
 * 	最大的平分组数个数。
 *
 * 示例1：
 * 	输入：
 * 		7
 * 		4 3 2 3 5 2 1
 * 	输出：
 * 	4
 *
 * 说明：可以等分的情况有：
 * 	4 个子集（5），（1,4），（2,3），（2,3）
 * 	2 个子集（5,1,4），（2,3,2,3）
 * 	最大的平分组数个数为4个。
 *
 * 示例2：
 * 	输入：
 * 		9
 * 		5 2 1 5 2 1 5 2 1
 * 	输出：
 * 		4
 * 说明：可以等分的情况有：
 * 	4 个子集（5，1），（5，1），（5，1），（2，2，2）
 * 	2 个子集（5, 1, 5,1），（2,2, 2,5,1）
 * 	最大的平分组数个数为4个。
 */
public class _最大平分数组_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        String[] split = scanner.nextLine().split(" ");
        int sum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
            sum += nums[i];
        }

        // 排序
        Arrays.sort(nums);

        // 如果元素都一样，则可以分成 n 个一样的子数组
        if (nums[0] == nums[n - 1]) {
            System.out.println(n);
            return;
        }

        // 可以子数组分成个数
        int count = n - 1;
        while (count > 1) {
            // sum % count == 0 说明可以尝试将数组均分成相等的集合
            if (sum % count == 0) {
                int[] buckets = new int[count];
                if (dfs(nums, buckets, n - 1, sum / count)) {
                    System.out.println(count);
                    return;
                }
            }
            count--;
        }

        // 只能分成一组
        System.out.println(1);
    }

    /**
     * 放置nums数组的第 index 个元素，看是否能够放在某个桶，使得每个桶的值都相等
     * @param nums 数组
     * @param buckets 桶（每个子数组）
     * @param index 当前要放置的元素下标
     * @param target 放完所有元素后，每个桶中的元素和
     */
    private static boolean dfs(int[] nums, int[] buckets, int index, int target) {
        if (index == nums.length) {
            // 如果所有元素都放完了，则代表每个桶的值都相等，满足要求
            return true;
        }

        for (int i = 0; i < buckets.length; i++) {
            // 上一个桶和当前桶的值相等，则放在当前桶的结果也一样不可行，跳过当前桶
            if (i > 0 && buckets[i - 1] == buckets[i]) {
                continue;
            }

            if (buckets[i] + nums[index] <= target) {
                // 当前元素放置在桶里面
                buckets[i] += nums[index];
                if (dfs(nums, buckets, index + 1, target)) {
                    return true;
                }
                // 放在当前桶并不能使得放完每个元素时，每个桶的元素和相同，拿出元素，尝试重新放置下一个桶
                buckets[i] -= nums[index];
            }
        }

        return false;
    }

}
