package nowcoder.outd.Y22Q4;

import java.util.*;

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
