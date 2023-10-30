package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定非空字符串s，将该字符串分割成一些子串，使每个子串的ASCII码值的和 均为水仙花数。
 * 	1、若分割不成功，则返回0；
 * 	2、若分割成功且分割结果不唯一，则返回-1；
 * 	3、若分割成功且分割结果唯一，则返回分割后子串的数目。
 *
 * 输入描述：
 * 	输入字符串的最大长度为200
 * 输出描述：
 * 	根据题目描述中情况，返回相应的结果。
 *
 * 示例1：
 * 	输入：
 * 		abc
 * 	输出：
 * 		0
 * 	说明：
 * 		分割不成功
 *
 * 示例2：
 * 	输入：
 * 		f3@d5a8
 * 	输出：
 * 		-1
 * 	说明：
 * 		分割成功但分割结果不唯一，可以分割为两组，
 * 		一组：""f3"" 和 ""@d5a8""
 * 		另一组: ""f3@d5"" 和 ""a8""
 *
 * 示例3：
 * 	输入：
 * 		AXdddF
 * 	输出：
 * 		2
 * 	说明：分割成功且结果唯一，可以分割为AX""(153) 和""dddF""(370)
 *
 * 备注：此题表示 “水仙花数”是指一个三位数，每位上数字的立方和等于该数字本身，如371是'水仙花数'，因371=3^3+7^3+1^3
 */
public class _水仙花数II_字符串分割_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();

        // 无论怎么分割，最后一个字母一定是在分割后的到的字符串末尾


    }

}
