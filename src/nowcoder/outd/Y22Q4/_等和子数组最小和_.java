package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _等和子数组最小和_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            int in = scanner.nextInt();
            arr[i] = in;
            sum += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        if (max == min) {
            System.out.println(min);
            return;
        }

        Arrays.sort(arr);
        // 每个子数组的和，最小也要从数组中的最大值开始，因为子数组的和肯定 >= max。
        for (int i = max; i <= sum; i++) {
            // 如果能够整除分组的和，则可以考虑能把数组均分成和为 i 的组合
            if (sum % i == 0) {
                if (dfs(arr, arr.length - 1, i, new int[sum / i])) {
                    System.out.println(i);
                    // 只要找到了最小的匹配的，就结束，返回结果
                    return;
                }
            }
        }
    }

    private static boolean dfs(int[] arr, int index, int target, int[] buckets) {
        if (index < 0) {
            return true;
        }

        for (int i = 0; i < buckets.length; i++) {
            // 如果放在上一个桶的方案最终不能完全放完球，且当前桶和前一个桶的值相等，则跳过这次尝试
            if (i > 1 && buckets[i - 1] == buckets[i]) {
                continue;
            }

            // 可以放入桶中
            if (arr[index] + buckets[i] <= target) {
                buckets[i] += arr[index];
                // 放下一个球
                if (dfs(arr, index - 1, target, buckets)) {
                    return true;
                }
                // 放在这个桶中，最终并不能放完所有的球，拿出该球重新尝试下一个桶
                buckets[i] -= arr[index];
            }
        }

        return false;
    }

}
