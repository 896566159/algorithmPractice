package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * 存在一种虚拟IPv4地址，由4小节组成，每节的范围为0~128，以#号间隔，格式如下：
 * (1~128)#(0~255)#(0~255)#(0~255)
 * 请利用这个特性把虚拟IPv4地址转换为一个32位的整数，IPv4地址以字符串形式给出，要求每个IPvV4地址只能对应到唯一的整数上。
 * 如果是非法IPv4，返回invalid IP。
 *
 * 输入描述：
 * 	输入一行，虚拟IPv4地址格式字符串
 * 输出描述：
 * 	输出一行，按照要求输出整型或者特定字符
 *
 * 示例1：
 * 	输入：
 * 		100#101#1#5
 * 	输出：
 * 		1684340997
 *
 * 示例2：
 * 	输入：
 * 		1#2#3
 * 	输出：
 * 		invalid IP
 */
public class _IPv4地址转换成整数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("#");
        if (split.length != 4) {
            System.out.println("invalid IP");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int res = 0;
        for (int i = 0; i < 4; i++) {
            char[] chars = split[i].toCharArray();
            int digit = 0;
            for (int j = 0; j < chars.length; j++) {
                // 数字是否合法
                if (chars[j] < '0' || chars[j] > '9') {
                    System.out.println("invalid IP");
                    return;
                }
                digit = digit * 10 + (chars[j] - '0');
            }

            // 数字段是否合法
            if ((i == 0 && (digit < 0 || digit > 128)) || (i != 0 && (digit < 0 || digit > 255))) {
                System.out.println("invalid IP");
                return;
            }
            // 十进制转成二进制，二进制填充成 8 位
            String int2bin = Integer.toBinaryString(digit);
            int bin2int = Integer.parseInt(int2bin);
            String format8bit = String.format("%08d", bin2int);
            sb.append(format8bit);

            // 位运算方式
            res += digit << (8 * (3 - i));
        }

        System.out.println(res);
        System.out.println(Integer.parseInt(sb.toString(), 2));
    }

}
