package nowcoder.outd.Y22Q4;

import java.util.*;

public class _租车骑绿岛_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> weights = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int in = scanner.nextInt();
            arr[i] = in;
            weights.add(in);
        }

        System.out.println(minSyscles1(arr, m));
        System.out.println(minSyscles2(weights, m));
    }

    private static int minSyscles1(int[] arr, int limit) {
        int ans = 0;
        int n = arr.length;
        int right = n - 1;
        int left = 0;

        Arrays.sort(arr);

        // 从后往前遍历，看看那些人需要一个自行车
        while (n >= 0 && arr[right] >= limit) {
            ans++;
            right--;
        }

        // 尝试让两个人拼一辆车
        while (left < right) {
            if (arr[left] + arr[right] > limit) {
                // 剩余的最重的那个人和最轻的没法拼车
                right--;
                ans++;
            } else {
                left++;
                right--;
                ans++;
            }
        }

        // 还有一个人时，也需要一辆车
        if (left == right) {
            ans++;
        }

        return ans;
    }

    private static int minSyscles2(List<Integer> weights, int m) {

        Collections.sort(weights);

        //第二步，左右指针向中间移动
        int left=0;
        int right = weights.size()-1;

        //结果
        int min_bikes = 0;

        //当前重量
        int temp_weight = weights.get(right) + weights.get(left);

        // 题目中有两个隐含的条件
        // 1: 一辆车最多骑两个人
        // 2：人的重量不可能大于车的载重
        while(left<right) {
            if (temp_weight > m) {
                right --;
                min_bikes += 1;
                temp_weight = weights.get(right) + weights.get(left);
            } else{
                right --;
                left ++;
                min_bikes += 1;
                temp_weight = weights.get(right) + weights.get(left);
            }
        }

        // 感谢评论区老铁点拨
        if (left == right) {
            min_bikes++;
        }

        return min_bikes;
    }

}