package nowcoder.outd.Y22Q3;

import java.util.*;

/**
 * 单词接龙的规则是：
 * 	可用于接龙的单词首字母必须要前一个单词的尾字母相同；
 * 	当存在多个首字母相同的单词时，取长度最长的单词，如果长度也相等，则取字典序最小的单词；已经参与接龙的单词不能重复使用。
 * 现给定一组全部由小写字母组成单词数组，并指定其中的一个单词作为起始单词，进行单词接龙，
 * 请输出最长的单词串，单词串是单词拼接而成，中间没有空格。
 *
 * 输入描述:
 * 	输入的第一行为一个非负整数，表示起始单词在数组中的索引K，0 <= K < N ；
 * 	输入的第二行为一个非负整数，表示单词的个数N；
 * 	接下来的N行，分别表示单词数组中的单词。
 * 输出描述:
 * 	输出一个字符串，表示最终拼接的单词串。
 * 备注:
 * 	单词个数N的取值范围为[1, 20]；
 * 	单个单词的长度的取值范围为[1, 30]；
 *
 * 示例1：
 * 	输入：
 * 		0
 * 		6
 * 		word
 * 		dd
 * 		da
 * 		dc
 * 		dword
 * 		d
 * 	输出：
 * 	worddwordda
 * 说明：
 * 	先确定起始单词word，
 * 	再接以d开头的且长度最长的单词dword，
 * 	剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，
 * 	所以最后输出worddwordda。
 *
 * 示例2：
 * 	输入：
 * 		4
 * 		6
 * 		word
 * 		dd
 * 		da
 * 		dc
 * 		dword
 * 		d
 * 	输出：
 * 		dwordda
 * 说明：
 * 	先确定起始单词dword，
 * 	剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，
 * 	所以最后输出dwordda。
 */
public class _单词接龙_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        Map<Character, List<String>> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        String pre = "";

        // 构造map，单词首字母为 key，value为以 key 开头的所有单词
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            if (i == k) {
                // 第一个单词，不放入接龙的单词中
                pre = word;
            } else {
                char c = word.charAt(0);
                if (!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(word);
            }
        }

        // 给 map 中的单词排序
        for (Map.Entry<Character, List<String>> entry : map.entrySet()) {
            // 当存在多个首字母相同的单词时，取长度最长的单词，如果长度也相等，则取字典序最小的单词；已经参与接龙的单词不能重复使用。
            Collections.sort(entry.getValue(), (a,b)->a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        }

        res.append(pre);
        while (!map.isEmpty()) {
            char c = pre.charAt(pre.length() - 1);
            if (!map.containsKey(c)) {
                break;
            }

            List<String> list = map.get(c);
            pre = list.remove(0);
            res.append(pre);

            // 如果以改首字母开头的单词都用完了，则删除
            if (list.isEmpty()) {
                map.remove(c);
            }
        }

        // 输出
        System.out.println(res.toString());
    }

}
