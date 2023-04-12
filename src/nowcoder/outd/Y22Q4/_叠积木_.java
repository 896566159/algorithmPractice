package nowcoder.outd.Y22Q4;

import java.util.*;

public class _叠积木_ {

    static Map<Integer, Integer> bricks = new TreeMap<>();
    static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int length = split.length;
        int[] arr = new int[length];

        int sum = 0;
        int maxLen = 0;
        used = new boolean[length];

        for (int i = 0; i < split.length; i++) {
            int brick = Integer.parseInt(split[i]);
            arr[i] = brick;
            bricks.put(brick, bricks.getOrDefault(brick, 0) + 1);
            maxLen = Math.max(arr[i], maxLen);
            sum += arr[i];
        }



        // 最终砌好的墙的长度范围： [maxLen, sum]，墙越长，高度越短
        for (int len = maxLen; len <= sum; len++) {

            // 如果总的长度和不能整除当前尝试的长度，则无法砌成
            if (sum % len != 0) {
                continue;
            }

            // 从长度最长的砖开始使用
            for (int i = 0; i <= length; i++) {
                // 已经找到默写砖块
                if (dfs(len, arr[i], i, arr)) {

                }
            }
        }

    }

    private static boolean dfs(int targetLen, int curLen, int index, int[] arr) {
        // 看map中是否有另一块砖和当前这块砖能够拼接使得长度为 len
        if (bricks.containsKey(targetLen - curLen) && bricks.get(targetLen - curLen) > 0) {
            bricks.put(curLen, bricks.get(curLen) - 1);
            bricks.put(targetLen - curLen, bricks.get(targetLen - curLen) - 1);
            return true;
        }

        // 从下一块转开始
        for (int i = index + 1; i < arr.length; i++) {
            if (dfs(targetLen, curLen + arr[i], i, arr)) {
                return true;
            }
        }

        return false;
    }

}
