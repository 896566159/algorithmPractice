package ltcd.bethFirstSearchExercise;

import java.util.*;

public class _1345_跳跃游戏IV {

    public int minJumps(int[] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();//存储同值列表
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);//-1标记未计算过其最小跳跃

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {//如果之前没有同值出现，新建一个set
                map.put(arr[i], new TreeSet<>());
            }

            map.get(arr[i]).add(i);//加入同值的坐标
        }

        dp[0] = 0;
        Queue<Integer> queue = new LinkedList<>();//存储下一跳：前移一、后移一、或者同值跳跃
        queue.offer(0);//起始跳为 0 坐标

        while (!queue.isEmpty()) {//队列中每次循环内的元素的次数应该是一致的
            int cur = queue.poll();
            Set<Integer> set = map.get(arr[cur]);//取出当前节点的同值set

            for (int next : set) {
                if (dp[next] == -1) {
                    dp[next] = dp[cur] + 1;//同值的下标的最小跳跃 = 当前最小跳跃 + 1
                    queue.offer(next);//同值跳跃入队
                }
            }

            set.clear();//同值跳跃后需清除set，以避免循环调用，所有同值以第一次跳计数
            if (cur - 1 >= 0 && dp[cur - 1] == -1) {//向前跳
                dp[cur - 1] = dp[cur] + 1;//向前跳的最小跳跃 = 当前最小跳跃 + 1
                queue.offer(cur - 1);//向前跳入队
            }

            if (cur + 1 < n && dp[cur + 1] == -1) {//向后跳
                dp[cur + 1] = dp[cur] + 1;//向后跳的最小跳跃 = 当前最小跳跃 + 1
                queue.offer(cur + 1);//向后跳入队
            }

            if (dp[n - 1] != -1) {//已经求出最小跳，直接退出
                return dp[n - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        new _1345_跳跃游戏IV().minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404});
    }

}
