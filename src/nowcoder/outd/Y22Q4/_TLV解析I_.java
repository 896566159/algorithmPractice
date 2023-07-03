package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * TLV编码是按 [Tag Length Value] 格式进行编码的，一段码流中的信元用 Tag 标识，Tag 在码流中唯一不重复，Length 表示信元 Value 的长度，Value 表示信元的值。
 * 码流以某信元的 Tag 开头，Tag固定占 一个字节，Length固定占 两个字节，字节序为 小端序。
 * 现给定TLV格式编码的码流，以及需要解码的信元Tag，请输出该信元的 Value。
 * 输入码流的16进制字符中，不包括小写字母，且要求输出的 16 进制字符串中也不要包含小写字母；码流字符串的最大长度不超过 50000 个字节。
 *
 * 输入描述：
 * 	输入的第一行为一个字符串，表示待解码信元的Tag；
 * 	输入的第二行为一个字符串，表示待解码的16进制码流，字节之间用空格分隔。
 * 输出描述：
 * 	输出一个字符串，表示待解码信元以16进制表示的Value。
 *
 * 示例1：
 * 	输入：
 * 		31
 * 		32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * 	输出：
 * 		32 33
 * 说明：
 * 	需要解析的信元的 Tag 是31，从码流的起始处开始匹配，Tag 为 32的信元长度为 1（01 00，小端序表示为1）；
 * 	第二个信元的 Ta g是90，其长度为 2；第三个信元的Tag是30，其长度为3；
 * 	第四个信元的 Tag 是31，其长度为 2（02 00），所以返回长度后面的两个字节即可，即32 33。
 *
 * 知识点：
 * 大端序Big-Endian：将数据的低位字节存放在内存的高地址，高位字节存放在低地址。这种排序方式与数据用自己表示时的书写顺序一致，符合人类的阅读习惯。
 * 小端序Little-Endian:将数的低位字节存放在内存的低地址，高位字节存放在高地址。小端序与人类的阅读习惯相反，但更符合计算机读取内存的方式，因为CPU读取内存中的数据时，是从低地址向高地址方向进行读取的。
 */
public class _TLV解析I_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tag = scanner.nextLine();
        String[] tlvs = scanner.nextLine().split(" ");

        for (int i = 0; i < tlvs.length; i++) {
            // tag
            String t = tlvs[i];

            // 小端序排列 还原长度时要交换位置
            int length = Integer.parseInt(tlvs[i+2] + tlvs[i+1], 16);
            // 跳过长度的 2 个字节
            i += 2;
            
            if (t.equals(tag)) {
                StringBuilder value = new StringBuilder();

                while (length > 0) {
                    value.append(tlvs[++i]).append(" ");
                    length--;
                }

                System.out.println(value.toString());
                break;
            } else {
                i += length;
            }
        }
    }

}
