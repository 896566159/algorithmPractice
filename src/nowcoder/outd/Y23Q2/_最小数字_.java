package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个整型数组，请从该数组中选择3个元素组成最小数字并输出（如果数组长度小于3，则选择数组中所有元素来组成最小数字）。
 *
 * 输入描述：
 * 	一行用半角逗号分割的字符串记录的整型数组，0 < 数组长度 <= 100，0 < 整数的取值范围 <= 10000。
 * 输出描述：
 * 	由3个元素组成的最小数字，如果数组长度小于3，则选择数组中所有元素来组成最小数字。
 *
 * 示例 1：
 * 	输入：
 * 		21,30,62,5,31
 * 	输出：
 * 		21305
 * 说明：
 * 	数组长度超过3，需要选3个元素组成最小数字，21305由21,30,5三个元素组成的数字，为所有组合中最小的数字
 *
 * 示例 2：
 * 	输入：
 * 		5,21
 * 	输出：
 * 		215
 * 说明：
 * 	数组长度小于3，选择所有元素组成最小值，215为最小值
 *
 * 	示例 3：
 * 	输入：
 * 		345,62,14,2,67,34,21,14,25,23,13,23,54,12
 * 	输出：
 * 		12132
 */
public class _最小数字_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(",");

        // 排序，先按照字符串长度升序，长度相等，再按照字典序序
        Arrays.sort(line, (a, b)->{
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        if (line.length == 1) {
            System.out.println(line[0]);
        } else if (line.length == 2) {
            String s1 = line[0] + line[1];
            String s2 = line[1] + line[0];
            System.out.println(s1.compareTo(s2) < 0 ? s1 : s2);
        } else {
            String[] res = new String[3];
            res[0] = line[0];
            res[1] = line[1];
            res[2] = line[2];
            Arrays.sort(res);
            for (int i = 0; i < 3; i++) {
                System.out.print(res[i]);
            }
        }
    }

}
