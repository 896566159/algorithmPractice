package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个N*M矩阵，请先找出M个该矩阵中每列元素的最大值，然后输出这M个值中的最小值
 * 补充说明:N和M的取值范围均为: [0,100]
 *
 * 示例1：
 * 	输入:
 * 		[[1,2],[3,4]]
 * 	输出:
 * 		3
 * 说明:
 * 	第一列元素为: 1和3，最大值为3
 * 	第二列元素为: 2和4，最大值为4
 * 	各列最大值3和4的最小值为3
 */
public class _矩阵元素的边界值_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().replace("],[", "#").replace("[", "").replace("]", "").split("#");
        if (split.length == 0 || split[0].length() == 0 || split[0].equals("")) {
            System.out.println(-1);
            return;
        }

        int m = split[0].split(",").length;
        int[] tmp = new int[m];
        for (int i = 0; i < split.length; i++) {
            String[] elements = split[i].split(",");
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(elements[j]);
                tmp[j] = Math.max(tmp[j], value);
            }
        }

        Arrays.sort(tmp);
        System.out.println(tmp[0]);
    }

}
