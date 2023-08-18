package nowcoder.outd.Y22Q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小明今年升学到了小学1年级来到新班级后，发现其他小朋友身高参差不齐，然后就想 基于各小朋友和自己的身高差，对他们进行排序，
 * 请帮他实现排序。
 *
 * 输入描述：
 * 	第一行为正整数 h和n，0<h<200 为小明的身高，0<n<50 为新班级其他小朋友个数。
 * 	第二行为n个正整数，h1 ~ hn分别是其他小朋友的身高，取值范围0<hi<200，且n个正整数各不相同。
 *
 * 输出描述：
 * 	输出排序结果，各正整数以空格分割，
 * 	和小明身高差绝对值最小的小朋友排在前面，
 * 	和小明身高差绝对值最大的小朋友排在后面，
 * 	如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
 *
 * 示例1：
 * 	输入：
 * 		100 10
 * 		95 96 97 98 99 101 102 103 104 105
 * 	输出：
 * 		99 101 98 102 97 103 96 104 95 105
 */
public class _小朋友排队_寻找身高相近的小朋友_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int h = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[][] arr = new int[n][2];
        split = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(split[i]);
            arr[i][1] = Math.abs(h - arr[i][0]);
        }

        Arrays.sort(arr, (a, b)->a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(arr[i][0]);
        }
    }

}
