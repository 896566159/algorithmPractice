package nowcoder.outd.Y22Q4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定两个整数数组 array1、array2，数组元素按升序排列。
 * 假设从 array1、array2 中分别取出一个元素可构成一对元素，现在需要取出k对元素，
 * 并对取出的所有元素求和，计算和的最小值。
 * 注意：两对元素如果对应于 array1、array2 中的两个下标均相同，则视为同一对元素。
 *
 * 输入描述：
 * 	输入两行数组 array1、array2，每行首个数字为数组大小size(0 < size <= 100);
 * 	0 < array1[i] <= 1000
 * 	0 < array2[i] <= 1000
 * 	接下来一行为正整数k
 * 	0 < k <= array1.size() * array2.size()
 * 输出描述：
 * 	满足要求的最小和
 *
 * 示例1：
 * 	输入：
 * 		3 1 1 2
 * 		3 1 2 3
 * 		2
 * 	输出：
 * 		4
 * 说明：
 * 	用例中，需要取 2 对元素
 * 	取第一个数组第 0 个元素与第二个数组第 0 个元素组成 1 对元素[1,1];
 * 	取第一个数组第 1 个元素与第二个数组第 0 个元素组成 1 对元素[1,1];
 * 	求和为 1 + 1 + 1 + 1 = 4，为满足要求的最小和。
 */
public class _整数对最小和_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        String[] split1 = scanner.nextLine().split(" ");
        int k = Integer.parseInt(scanner.nextLine());

        int len1 = Integer.parseInt(split[0]);
        int len2 = Integer.parseInt(split1[0]);
        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];

        for (int i = 0; i < len1; i++) {
            nums1[i] = Integer.parseInt(split[i + 1]);
        }

        for (int i = 0; i < len2; i++) {
            nums2[i] = Integer.parseInt(split1[i + 1]);
        }

        // 暴力
        int[] all = new int[len1 * len2];
        int index = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                all[index++] = nums1[i] + nums2[j];
            }
        }

        // 排序
        Arrays.sort(all);
        int minSum = 0;
        for (int i = 0; i < k; i++) {
            minSum += all[i];
        }

        // 输出
        System.out.println(minSum);
    }

}
