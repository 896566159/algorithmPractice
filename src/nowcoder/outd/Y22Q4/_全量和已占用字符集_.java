package nowcoder.outd.Y22Q4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述：
 * 给定两个字符集合， 一个是全量字符集， 一个是已占用字符集， 已占用字符集中的字符不能再使用， 要求输出剩余可用字符集。
 *
 * 输入描述:
 * 	输入一个字符串 一定包含@，@前为全量字符集 @后的为已占用字符集
 * 	已占用字符集中的字符，一定是全量字符集中的字符，字符集中的字符跟字符之间使用英文逗号隔开
 * 	每个字符都表示为字符 + 数字的形式，用英文冒号分隔，比如 a:1 标识一个 a 字符
 * 	字符只考虑英文字母，区分大小写，数字只考虑正整型 不超过100
 * 	如果一个字符都没被占用，@标识仍存在
 * 输出描述:
 * 	输出可用字符集，
 * 	不同的输出字符集之间用回车换行，
 * 注意：输出的字符顺序要跟输入的一致，不能输出 b:3,a:2,c:2
 * 	如果某个字符已全部占用，则不需要再输出
 *
 * 示例1：
 * 	输入：
 * 		a:3,b:5,c:2@a:1,b:2
 * 	输出：
 * 		a:2,b:3,c:2
 * 说明：
 * 	全量字符集为 3个a，5个b，2个c
 * 	已占用字符集为 1个a，2个b
 * 	由于已占用字符不能再使用
 * 	因此剩余可用字符为 2个a，3个b，2个c
 * 示例 2：
 * 	输入：
 * 		a:3,b:5,c:2@
 * 	输出：
 * 		a:3,b:5,c:2@
 */
public class _全量和已占用字符集_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split("@");
        Map<Character, Integer> map = new HashMap<>();

        // 全集
        String[] all = split[0].split(",");
        for (String s : all) {
            String[] charCount = s.split(":");
            char key = s.charAt(0);
            map.put(key, map.getOrDefault(key, 0) + Integer.parseInt(charCount[1]));
        }

        // 已使用集
        if (split.length > 1) {
            String[] used = split[1].split(",");
            for (String s : used) {
                String[] charCount = s.split(":");
                char key = s.charAt(0);
                map.put(key, map.get(key) - Integer.parseInt(charCount[1]));

                if (map.get(key) <= 0) {
                    map.remove(key);
                }
            }
        }

        // 输出
        // 记录最后一个
        char lastKey = 'a';
        for (int i = 0; i < all.length; i++) {
            char key = all[i].charAt(0);

            if (map.containsKey(key)) {
                if (map.size() > 1) {
                    System.out.print(key + ":" + map.get(key) + ",");
                    map.remove(key);
                } else {
                    lastKey = key;
                }
            }
        }
        System.out.println(lastKey + ":" + map.get(lastKey));
    }

}
