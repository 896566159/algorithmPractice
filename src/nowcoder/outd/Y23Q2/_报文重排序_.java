package nowcoder.outd.Y23Q2;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 对报文进行重传和重排序是常用的可靠性机制，重传缓冲区内有一定数量的子报文，每个子报文在原始报文中的顺序已知，现在需要恢复出原始报文。
 * 输入描述：
 * 	输入第一行为N，表示子报文的个数，0 < N <= 1000。
 * 	输入第二行为N个子报文，以空格分开，子报文格式为字符串报文内容+后缀顺序索引，字符串报文内容由|a-z,A-Z)组成后缀为整形值，表示顺序。顺序值唯一，不重复。
 * 输出描述:
 * 	输出恢复出的原始报文。按照每个子报文的顺序的升席排序恢复出原始报文，顺序后缀需要从恢复出的报文中删除掉
 * 用例1：
 * 	输入:
 * 		4
 * 		rolling3 stone4 like1 a2
 * 	输出:
 * 		like a rolling stone
 * 说明:
 * 	4个子报文的内容分别为roling,stone,like,a，顺序值分别为3，4，1，2，
 * 	按照顺序值升序并删除掉顺序后缀得到恢复的原始报文: like a rolling stone
 *
 * 用例2：
 * 	输入:
 * 		8
 * 		gifts6 and7 Exchanging1 all2 precious5 things8 kinds3 of4
 * 		// 注: 这里需要注意:and7与Exchanging1有两个空格
 * 	输出:
 * 	Exchanging all kinds of precious gifts and things
 */
public class _报文重排序_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());
        Map<Integer, String> map = new TreeMap<>();

        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int right = 0;
        int left = 0;

        while (right < len) {
            int index = 0;
            while (right < len && !(chars[right] > '0' && chars[right] < '9')) {
                right++;
            }

            index = right;
            while (index < len && chars[index] > '0' && chars[index] < '9') {
                index++;
            }

            // 截取字符串和子报文的顺序
            int idx = Integer.parseInt(s.substring(right, index));
            map.put(idx, s.substring(left, right));

            // 更新 left和right 的坐标
            while (index < len && chars[index] == ' ') {
                index++;
            }
            right = index;
            left = index;
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        Map.Entry<Integer, String> next = iterator.next();
        sb.append(next.getValue());

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            sb.append(" ").append(entry.getValue());
        }

        System.out.println(sb.toString());
    }

}
