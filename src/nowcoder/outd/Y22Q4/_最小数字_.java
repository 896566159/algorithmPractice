package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个整型数组，请从该数组中选择 3 个元素组成最小数字并输出（如果数组长度小于3，则选择数组中所有元素来组成最小数字）。
 *
 * 输入描述：
 * 	一行用半角逗号分割的字符串记录的整型数组，0 < 数组长度 <= 100，0 < 整数的取值范围 <= 10000。
 *
 * 输出描述：
 * 	由3个元素组成的最小数字，如果数组长度小于3，则选择数组中所有元素来组成最小数字。
 *
 * 示例1：
 * 	输入：
 * 		21,30,62,5,31
 * 	输出：
 * 		21305
 * 说明：
 * 	数组长度超过3，需要选3个元素组成最小数字，21305由21,30,5三个元素组成的数字，为所有组合中最小的数字
 *
 * 示例2：
 * 	输入：
 * 		5,21
 * 	输出：
 * 		215
 * 说明：
 * 	数组长度小于3，选择所有元素组成最小值，215为最小值
 */
public class _最小数字_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");

        // 排序，先按照字符串长度升序，长度相等，再按照字典序序
        Arrays.sort(split, (a, b)->{
            int lenA = a.length();
            int lenB = b.length();
            if (lenA != lenB) {
                return lenA - lenB;
            } else {
                return a.compareTo(b);
            }
        });

        if (split.length == 1) {
            System.out.println(split[0]);
        } else if (split.length == 2) {
            String s1 = split[0] + split[1];
            String s2 = split[1] + split[0];
            System.out.println(s1.compareTo(s2) < 0 ? s1 : s2);
        } else {
            String[] res = new String[3];
            res[0] = split[0];
            res[1] = split[1];
            res[2] = split[2];
            Arrays.sort(res);
            for (int i = 0; i < 3; i++) {
                System.out.print(res[i]);
            }
        }
    }

}
