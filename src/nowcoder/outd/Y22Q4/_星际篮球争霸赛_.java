package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在星球争霸篮球赛对抗赛中，最大的宇宙战队希望每个人都能拿到MVP，MVP的条件是单场最高分得分获得者。
 * 可以并列所以宇宙战队决定在比赛中尽可能让更多队员上场，并且让所有得分的选手得分都相同，
 * 然而比赛过程中的每1分钟的得分都只能由某一个人包揽。输出有得分的队员都是MVP时，最少得MVP得分。
 *
 * 输入描述：
 * 	输入第一行为一个数字 t ，表示为有得分的分钟数 1 ≤ t ≤ 50
 * 	第二行为 t 个数字，代表每一分钟的得分 p， 1 ≤ p ≤ 50
 * 输出描述：
 * 	输出有得分的队员都是MVP时，最少得MVP得分。
 *
 * 示例1：
 * 	输入：
 * 		9
 * 		5 2 1 5 2 1 5 2 1
 * 	输出：
 * 		6
 * 说明：4人MVP，每个人都是6分。
 */
public class _星际篮球争霸赛_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] scores = scanner.nextLine().split(" ");
        int[] nums = new int[scores.length];
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            nums[i] = Integer.parseInt(scores[i]);
            sum += nums[i];
        }

        // 得分排序
        Arrays.sort(nums);

        // MVP人数
        int res = 1;
        // 每个子数组的和，最小也要从数组中的最大值开始，因为子数组的和肯定 >= sum。
        for (int i = 2; i <= sum / 2; i++) {
            // 如果总分能够均分到 i 个桶，则尝试每个具体的分是否能够均分到 i 个桶
            if (sum % i == 0) {
                int target = sum / i;
                if (dfs(nums, nums.length - 1, new int[i], target)) {
                    // 最多的桶数量
                    res = Math.max(res, i);
                }
            }
        }

        System.out.println(sum / res);
    }

    private static boolean dfs(int[] nums, int i, int[] bucket, int target) {
        // 已经成功放完所有的分数
        if (i < 0) {
            return true;
        }

        // 尝试把 i 放置在第 j 个桶
        for (int j = 0; j < bucket.length; j++) {
            // 如果这只桶的值和上只桶放的值一样，则跳过
            if (j > 0 && bucket[j] == bucket[j - 1]) {
                continue;
            }

            if (bucket[j] + nums[i] <= target) {
                bucket[j] += nums[i];
                // 放下一个
                if (dfs(nums, i - 1, bucket, target)) {
                    return true;
                }
                // 放在这个桶中，最终并不能放完所有的球，拿出该球重新尝试下一个桶
                bucket[j] -= nums[i];
            }
        }

        return false;
    }

}
