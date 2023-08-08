package nowcoder.outd.Y23Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个英文文章片段，翻转指定区间的单词顺序，标点符号和普通字母一样处理。
 * 例如输入字符串 “I am a developer.”，区间[0,3]则输出 “developer. a am I”。
 *
 * 输入描述：
 * 	使用换行隔开三个参数
 * 	第一个参数为英文文章内容即英文字符串
 * 	第二个参数为反转起始单词下标，下标从0开始
 * 	第三个参数为结束单词下标，
 * 输出描述：
 * 	反转后的英文文章片段，所有单词之间以一个半角空格分割进行输出
 *
 * 示例1：
 * 	输入：
 * 		I am a developer.
 * 		1
 * 		2
 * 	输出：
 * 		I a am developer.
 * 示例2：
 * 	输入：
 * 		Hello world!
 * 		0
 * 		1
 * 	输出：
 * 		world! Hello
 * 说明：
 * 	输入字符串可以在前面或者后面包含多余的空格，但是反转后的不能包含多余空格。
 *
 * 示例3：
 * 	输入：
 * 		I am a developer.
 * 		0
 * 		3
 * 	输出：
 * 		developer. a am I
 * 说明：
 * 	如果两个单词见有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 示例4：
 * 	输入：
 * 		Hello!
 * 		0
 * 		3
 * 	输出：
 * 		Hello!
 * 说明：
 * 	指定反转区间只有一个单词，或无有效单词则统一输出原字符串。
 */
public class _按单词下标区间翻转文章内容_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().trim().toCharArray();
        List<String> words = new ArrayList<>();

        // 字符串去除多余的空格
        int right = 0;
        while (right < chars.length) {
            StringBuilder sb = new StringBuilder();
            // 单词
            while (right < chars.length && chars[right] != ' ') {
                sb.append(chars[right]);
                right++;
            }
            words.add(sb.toString());
            // 空格
            while (right < chars.length && chars[right] == ' ') {
                right++;
            }
        }

        // 需要翻转的有效区间
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        end = end > words.size() ? words.size() : end;

        // 翻转单词
        while (start < end) {
            String tmp = words.get(start);
            words.set(start, words.get(end));
            words.set(end, tmp);
            start++;
            end--;
        }

        // 结果输出
        System.out.print(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            System.out.print(" " + words.get(i));
        }
    }

}
