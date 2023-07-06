package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 磁盘的容量单位常用的有M，G，T这三个等级，它们之间的换算关系为1T = 1024G，1G = 1024M，
 * 现在给定 n 块磁盘的容量，请对它们按从小到大的顺序进行稳定排序，
 * 例如：给定 5 块盘的容量，1T，20M，3G，10G6T，3M12G9M排序后的结果为20M，3G，3M12G9M，1T，10G6T。
 * 注意单位可以重复出现，上述3M12G9M表示的容量即为3M+12G+9M，和12M12G相等。
 * 输入描述：
 * 	输入第一行包含一个整数 n(2 <= n <= 100)，表示磁盘的个数，
 * 	接下的 n 行，每行一个字符串(长度大于2，小于30)，表示磁盘的容量，
 * 	由一个或多个格式为 mv 的子串组成，其中 m 表示容量大小，v表示容量单位，
 * 	例如20M，1T，30G，10G6T，3M12G9M。
 * 	磁盘容量 m 的范围为1到1024的正整数，容量单位v的范围只包含题目中提到的M，G，T三种，换算关系如题目描述。
 *
 * 输出描述：
 * 	输出n行，表示 n 块磁盘容量排序后的结果。
 * 示例1：
 * 	输入：
 * 		3
 * 		1G
 * 		2G
 * 		1024M
 * 	输出：
 * 		1G
 * 		1024M
 * 		2G
 * 说明：
 * 	1G和1024M容量相等，稳定排序要求保留它们原来的相对位置，故1G在1024M之前
 *
 * 示例 2：
 * 	输入：
 * 		3
 * 		2G4M
 * 		3M2G
 * 		1T
 * 	输出：
 * 		3M2G
 * 		2G4M
 * 		1T
 * 说明：1T的容量大于2G4M，2G4M的容量大于3M2G
 */
public class _磁盘容量排序_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] disks = new int[n][2];
        String[] original = new String[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            original[i] = line;
            int len = line.length();
            int left = 0;
            int right = 1;
            int sum = 0;

            while (right < len) {
                char c = line.charAt(right);
                if (c == 'M' || c == 'G' || c == 'T') {
                    int m = Integer.parseInt(line.substring(left, right));
                    sum += c == 'M' ? m : 0;
                    sum += c == 'G' ? m * 1024 : 0;
                    sum += c == 'T' ? m * 1024 * 1024 : 0;
                    // 更新 left
                    left = right + 1;
                }
                right++;
            }
            disks[i] = new int[] {sum, i};
        }

        // 排序
        Arrays.sort(disks, (a, b)->{
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        // 输出
        for (int i = 0; i < n; i++) {
            System.out.println(original[disks[i][1]]);
        }
    }

}
