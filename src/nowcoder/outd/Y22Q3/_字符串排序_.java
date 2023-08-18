package nowcoder.outd.Y22Q3;

import java.util.*;

/**
 * 对输入的单词进行字典序排序输出：
 * 字典序定义：
 * 	1. 单词中字母比较不区分大小写，两个单词先以第一个字母作为排序的基准，如果第一个字母相同，就用第二个字母为基准，如果第二个字母相同就以第三个字母为基准。依此类推，
 * 		如果到某个字母不相同，字母顺序在前的那个单词顺序在前。
 * 	2. 当一个短单词和一个长单词的开头部分都相同（即短单词是长单词从首字母开始的一部分），短单词顺序在前。
 * 	3. 字母大小写不同的相同单词，只输出一次。
 *
 * 输入描述：
 * 	不超过255个字符中,单词间用空格进行分隔，为简单起见，单词不包含连字符，无其它标点符号。
 * 输出描述：
 * 	输出排序后的单词，单词之间用空格隔开（最后不带空格），重复的单词只输出一次。
 *
 * 示例1：
 * 	输入：
 * 		Hello hello world
 * 	输出：
 * 		Hello world
 *
 * 示例 2：
 * 	输入：
 * 		i LOVE Cc I love CC Hello Hel Hellow
 * 	输出：
 * 		Cc Hel Hello Hellow i LOVE
 */
public class _字符串排序_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        List<String> duplicate = new ArrayList<>();
        // 先使用 Set 对字母大小写不同的相同单词，去重
        Set<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i].toLowerCase();
            if (!set.contains(s)) {
                set.add(s);
                duplicate.add(split[i]);
            }
        }

        // 排序
        Collections.sort(duplicate, (a, b)->{
            // 都转成小写来比较
            char[] s1 = a.toLowerCase().toCharArray();
            char[] s2 = b.toLowerCase().toCharArray();
            int n1 = s1.length;
            int n2 = s2.length;

            // 如果到某个字母不相同，字母顺序在前的那个单词顺序在前。
            for (int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
                if (s1[i] != s2[j]) {
                    return s1[i] - s2[j];
                }
            }

            // 当一个短单词和一个长单词的开头部分都相同（即短单词是长单词从首字母开始的一部分），短单词顺序在前。
            return n1 - n2;
        });

        for (int i = 0; i < duplicate.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(duplicate.get(i));
        }
    }

}
