package nowcoder.outd.Y22Q4;

import java.util.*;

import java.util.Scanner;


public class _叠积木_ {

    // 统计不同长度的积木的数量，且按照积木的长度进行了排序，可以减少递归次数
    static Map<Integer, Integer> bricks = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int length = split.length;
        int[] arr = new int[length];

        // 积木的长度总和
        int sum = 0;
        // 最长的积木
        int maxLen = 0;

        // 处理输入
        for (int i = 0; i < split.length; i++) {
            int brick = Integer.parseInt(split[i]);
            arr[i] = brick;

            // 记录不同长度的积木的数量
            bricks.put(brick, bricks.getOrDefault(brick, 0) + 1);
            maxLen = Math.max(arr[i], maxLen);
            sum += arr[i];
        }

        // 最终砌好的墙的长度范围： [maxLen, sum]，墙越长，层数越少
        for (int wallLen = maxLen; wallLen <= sum; wallLen++) {

            // 如果总的长度和不能整除当前尝试的长度，则无法砌成
            if (sum % wallLen != 0) {
                continue;
            }
            // 当每层的长度为wallLen时，层数level = sum / wallLen
            int level = sum / wallLen;

            // 遍历每块积木，因为需要将所有积木都使用掉
            for (int i = 0; i < length; i++) {

                int curBrick = arr[i];
                // 如果当前长度的积木的数量还大于零，则改长度的积木可以被使用
                if (bricks.get(curBrick) > 0) {
                    // 积木被使用后，该长度的砖数量 - 1
                    bricks.put(curBrick, bricks.get(curBrick) - 1);

                    // 当前积木长度正好可以搭建一层，或者可以找到和curBrick拼接使得长度为wallLen的积木，则说明搭好了一层，高度减一
                    if (curBrick == wallLen || dfs(wallLen, curBrick)) {
                        level--;
                    } else {
                        // 如果使用该砖头没法拼接达到目标长度，则将该砖头的数量恢复
                        bricks.put(curBrick, bricks.get(curBrick) + 1);
                    }
                }
            }

            // 如果搭建的高度达到预期的高度，则返回结果。
            // 因为最终砌好的墙的长度范围： [maxLen, sum]，墙越长，层数越少。
            // 从maxLen开始到sum结束，找到可以搭建的长度，那么一旦搭建成墙，则是层数最高的
            if (level == 0) {
                System.out.println(sum / wallLen);
                return;
            }
        }

        System.out.println(1);
    }

    private static boolean dfs(int wallLen, int curLen) {
        // 看map中是否有另一块砖和当前这块积木能够拼接使得长度为 wallLen，或者当前长度已经达到 wallLen，不需要在拼接其他的积木了
        if (curLen == wallLen || (bricks.containsKey(wallLen - curLen) && bricks.get(wallLen - curLen) > 0)) {
            bricks.put(wallLen - curLen, bricks.get(wallLen - curLen) - 1);
            return true;
        }

        // 遍历不同长度的积木
        Iterator<Integer> keysIterator = bricks.keySet().iterator();
        while (keysIterator.hasNext()) {
            int brick = keysIterator.next();
            int newLen = curLen + brick;

            // 如果遍历到该积木，长度已经超过墙的长度，则说明后面挑选的都会超过长度，因为Map是TreeMap，是有序的
            if (newLen > wallLen) {
                return false;
            }

            // 如果该长度的积木数量 > 0, 选中该积木后继续拼接
            if (bricks.get(brick) > 0) {

                // 选中砖后，该长度的砖数量 - 1
                bricks.put(brick, bricks.get(brick) - 1);

                if (newLen == wallLen || dfs(wallLen, newLen)) {
                    return true;
                } else {
                    // 如果使用该积木没法拼接达到目标长度，则将该积木的数量恢复
                    bricks.put(brick, bricks.get(brick) + 1);
                }
            }
        }

        return false;
    }

}
