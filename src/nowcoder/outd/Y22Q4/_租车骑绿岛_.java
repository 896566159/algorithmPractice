package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _租车骑绿岛_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(minSyscles(arr, m));
    }

    private static int minSyscles(int[] arr, int limit) {
        int ans = 0;
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        Map<Integer, Integer> weightFrequency = new HashMap<>();

        // 统计各个重量的人数
        for (int w : arr) {
            weightFrequency.put(w, weightFrequency.getOrDefault(w, 0) + 1);
        }

        

        return ans;
    }

}
