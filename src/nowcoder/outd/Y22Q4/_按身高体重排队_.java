package nowcoder.outd.Y22Q4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，
 * 现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；
 * 对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
 *
 * 输入描述：
 * 	两个序列，每个序列由 n 个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
 * 输出描述：
 * 	排列结果，每个数值都是原始序列中的学生编号，编号从1开始，身高从低到高，身高相同体重从轻到重，体重相同维持原来顺序。
 *
 * 示例1：
 * 	输入：
 * 		4
 * 		100 100 120 130
 * 		40 30 60 50
 * 	输出：
 * 		2 1 3 4
 *
 * 示例 2：
 * 	输入：
 * 		3
 * 		90 110 90
 * 		45 60 45
 * 	输出：
 * 		1 3 2
 */
public class _按身高体重排队_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] height = scanner.nextLine().split(" ");
        String[] weight = scanner.nextLine().split(" ");
        int[][] nums = new int[n][3];

        for (int i = 0; i < n; i++) {
            nums[i] = new int[] {Integer.parseInt(height[i]), Integer.parseInt(weight[i]), i + 1};
        }

        Arrays.sort(nums, (a,b)->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        for (int i = 0; i < n - 1; i++) {
            System.out.print(nums[i][2] + " ");
        }
        System.out.print(nums[n - 1][2]);
    }

}
