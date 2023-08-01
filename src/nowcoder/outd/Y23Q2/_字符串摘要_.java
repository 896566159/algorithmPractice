package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 给定一个字符串的摘要算法，请输出给定字符串的摘要值
 * 	1、去除字符串中非字母的符号
 * 	2、如果出现连续字符 (不区分大小写) ，则输出: 该字符 (小) + 连续出现的次数
 * 	3、如果是非连续的字符(不区分大小写) ，则输出: 该字符(小写) 该字母之后字符串中出现的该字符的次数
 * 	4、对按照以上方式表示后的字符串进行排序: 字母和紧随的数字作为一组进行排序，数字大的在前，数字相同的则按字母进行排序，字母小的在前。
 *
 * 输入描述:行字符串，长度为[1,200]
 * 输出描述:摘要字符串
 *
 * 示例1:
 * 	输入:
 * 		aabbcc
 * 	输出:
 * 		a2b2c2
 *
 * 示例2:
 * 	输入:
 * 		bAaAcBb
 * 	输出:
 * 		a3b2b2c0
 * 说明:
 * 	第一个b非连续字母，该字母之后字符串中还出现了2次 (最后的两个Bb)，所以输出b2，a连续出现3次，输出a3，
 * 	c非连续，该字母之后字符串再没有出现过c，输出c0，Bb连续2次，输出b2
 * 	对b2a3c0b2进行排序，最终输出a3b2b2c0
 */
public class _字符串摘要_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        int n = input.length();
        int[] preSum = new int[26];
        StringBuilder sb = new StringBuilder();

        // 统计次数，同时去掉非字母符号
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            }
        }

        char[] line = sb.toString().toCharArray();
        n  = line.length;
        // 统计次数
        for (int i = 0; i < n; i++) {
            map.put(line[i], map.getOrDefault(line[i], 0) + 1);
        }

        int right = 0;
        List<int[]> res = new ArrayList<>();
        while (right < n) {
            int left = right;
            while (right < n && right + 1 < n && line[right] == line[right + 1]) {
                right++;
            }

            int distance = right - left + 1;
            // 更新字母个数
            preSum[line[left] - 'a'] += distance;

            // 保存字母的 ASCII码 和次数
            if (distance == 1) {
                res.add(new int[] {line[left], map.get(line[left]) - preSum[line[left] - 'a']});
            } else {
                res.add(new int[] {line[left], distance});
            }

            right++;
        }

        // 排序
        Collections.sort(res, (a, b)->{
            if (a[1] != b[1]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 输出
        for (int i = 0; i < res.size(); i++) {
            System.out.print((char) res.get(i)[0] + "" + res.get(i)[1]);
        }
    }

}
