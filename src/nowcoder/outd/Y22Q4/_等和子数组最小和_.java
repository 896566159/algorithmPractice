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
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            int in = scanner.nextInt();
            arr[i] = in;
            map.put(in, map.getOrDefault(in, 0) + 1);
            sum += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        if (max == min) {
            System.out.println(min);
            return;
        }

        Arrays.sort(arr);
        // 每组的和
        for (int i = max; i <= sum; i++) {
            // 能够整除分组的和，则可以考虑能把数组均分成和为 i 的组合
            if (sum % i == 0) {

            }
        }
    }

}
