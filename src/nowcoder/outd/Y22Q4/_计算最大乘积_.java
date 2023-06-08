package nowcoder.outd.Y22Q4;

import java.util.*;

public class _计算最大乘积_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split(",");
        int max = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 初始化
        for (int i = 0; i < 26; i++) {
            map.put(i, new HashSet<>());
        }

        // 记录每个单词有包含那些字母
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (char c : chars) {
                Set<Integer> set = map.get(c - 'a');
                set.add(i);
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean flag = true;

                // 如果两个单词包含同一个字，则退出循环
                for (int k = 0; k < 26; k++) {
                    Set<Integer> set = map.get(k);
                    if (set.contains(i) && set.contains(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        System.out.println(max);
    }

}
