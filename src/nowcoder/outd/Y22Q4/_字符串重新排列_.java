package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 给定一个字符串s，s包括以空格分隔的若干个单词，请对s进行如下处理后输出：
 * 1、单词内部调整：对每个单词字母重新按字典序排序
 * 2、单词间顺序调整：
 * 1）统计每个单词出现的次数，并按次数降序排列
 * 2）次数相同，按单词长度升序排列
 * 3）次数和单词长度均相同，按字典升序排列
 * 请输出处理后的字符串，每个单词以一个空格分隔。
 *
 * 输入描述：
 * 	一行字符串，每个字符取值范围：【a-zA-z0-9】以及空格，字符串长度范围：【1，1000】
 * 输出描述：
 * 	输出处理后的字符串，每个单词以一个空格分隔。
 * 例1：
 * 	输入：
 * 		This is an apple
 * 	输出：
 * 		an is This aelpp
 * 例2：
 * 	输入：
 * 		My sister is in the house not in the yard
 * 	输出：
 * 		in in eht eht My is not adry ehosu eirsst
 */
public class _字符串重新排列_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        System.out.println(produce(next));
    }

    /**
     * 1、单词字典序调整
     * 2、单词之间顺序调整：
     *      ① 词频高的排前面
     *      ② 词频相等，长度短的排前面
     *      ③ 词频、长度相等，按照字典序排序
     * @param next
     * @return
     */
    private static String produce(String next) {
        String[] split = next.split(" ");
        Map<String, Integer> frequency = new HashMap<>();

        for (String s : split) {
            char[] chars = s.toCharArray();
            // 按照字典序排序
            Arrays.sort(chars);

            // 词频统计
            String key = new String(chars);
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        }

        Set<Map.Entry<String, Integer>> entries = frequency.entrySet();
        List<Map.Entry<String, Integer>> wordAndFrequency = new ArrayList<>(entries);

        Collections.sort(wordAndFrequency, (a, b) -> {
            Map.Entry<String, Integer> o1 = (Map.Entry<String, Integer>) a;
            Map.Entry<String, Integer> o2 = (Map.Entry<String, Integer>) b;

            // 词频不同，则逆序返回
            if (!o1.getValue().equals(o2.getValue())) {
                return Integer.compare(o2.getValue(), o1.getValue());
            } else {
                // 长度不同
                if (o1.getKey().length() != o2.getKey().length()) {
                    return Integer.compare(o1.getKey().length(), o2.getKey().length());
                } else {
                    // 按照字典序返回
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : wordAndFrequency) {
            Integer value = entry.getValue();

            while (value-- > 0) {
                sb.append(entry.getKey()).append(" ");
            }
        }

        String string = sb.toString();
        return string.substring(0, string.length() - 1);
    }

}
