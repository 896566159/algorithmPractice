package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 同一个数轴 X 上有两个点的集合A={A1, A2, …, Am}和B={B1, B2, …, Bn}，
 * Ai和Bj均为正整数，A、B已经按照从小到大排好序，
 * A、B均不为空，给定一个距离R(正整数)，列出同时满足如下条件的所有（Ai, Bj）数对：
 * 	1) Ai <= Bj
 * 	2) Ai, Bj之间的距离小于等于R
 * 	3) 在满足1) 2)的情况下,每个Ai只需输出距离最近的Bj
 * 	4) 输出结果按Ai从小到大的顺序排序
 *
 * 输入描述：
 * 	第一行三个正整数m,n,R
 * 	第二行m个正整数,表示集合A
 * 	第三行n个正整数,表示集合B
 * 	输入限制：
 * 		1<=R<=100000, 1<=n,m<=100000, 1<=Ai,Bj<=1000000000
 * 输出描述：
 * 	每组数对输出一行Ai和Bj,以空格隔开
 *
 *
 * 示例1：
 * 	输入：
 * 		4 5 5
 * 		1 5 5 10
 * 		1 3 8 8 20
 * 	输出：
 * 		1 1
 * 		5 8
 * 		5 8
 */
public class _事件推送_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];

        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j <= r; j++) {
                // 在数组b中找出第一个 >= a[i] + r 的元素
                int index = binarySearch(b, a[i] + j);
                if (b[index] >= a[i] + j && b[index] - a[i] <= r) {
                    System.out.println(a[i] + " " + b[index]);
                    break;
                }
            }
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        // 在区间 [left, right]
        while (left < right) {
            int mid = (left + right) >>> 1;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

}
