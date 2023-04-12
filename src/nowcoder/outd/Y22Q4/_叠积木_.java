package nowcoder.outd.Y22Q4;

import java.util.*;

public class _叠积木_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int length = split.length;
        int[] arr = new int[length];

        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> bricks = new TreeMap<>();
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
            for (int i = length - 1; i >= 0; i--) {
                int firstBrick = arr[i];

                // 看map中是否有另一块砖和当前这块砖能够拼接使得长度为 len
                if (bricks.containsKey(len - firstBrick) && bricks.get(len - firstBrick) > 0) {
                    bricks.put(firstBrick, bricks.get(firstBrick) - 1);
                    bricks.put(len - firstBrick, bricks.get(len - firstBrick) - 1);
                    break;
                }

                // 上面的两块砖的组合不存在，说明需要使用至少三块以上的砖头
                for (int j = 0; j < length - i; j++) {
                    int secondBrick = arr[j];
                    firstBrick += secondBrick;

                    // 已经长度已经超出了目标墙的长度
                    if (firstBrick > len) {
                        break;
                    }

                    if (bricks.containsKey(len - firstBrick) && bricks.get(len - firstBrick) > 0) {
                        bricks.put(firstBrick, bricks.get(firstBrick) - 1);
                        bricks.put(len - firstBrick, bricks.get(len - firstBrick) - 1);
                        break;
                    }
                }
            }
        }

    }

}
