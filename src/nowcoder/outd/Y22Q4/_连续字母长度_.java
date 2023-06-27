package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 给定一个字符串，只包含大写字母，求在包含同一字母的子串中，长度第 k 长的子串的长度，相同字母只取最长的那个子串。
 * 输入描述：
 * 	第一行有一个子串(1<长度<=100)，只包含大写字母。
 * 	第二行为 k 的值
 * 输出描述：
 * 	输出连续出现次数第k多的字母的次数。
 * 示例1：
 * 	输入：
 * 		AAAAHHHBBCDHHHH
 * 		3
 * 	输出：
 * 		2
 * 说明：
 * 	同一字母连续出现的最多的是 A 和 H，四次；
 * 	第二多的是 H，3次，但是 H 已经存在4个连续的，故不考虑；
 *  下个最长子串是 BB，所以最终答案应该输出 2。
 *
 * 示例2：
 * 输入：
 * 	AABAAA
 * 	2
 * 输出：
 * 	1
 * 说明
 * 	同一字母连续出现的最多的是 A，三次；
 * 	第二多的还是 A，两次，但 A 已经存在最大连续次数三次，故不考虑；
 * 	下个最长子串是 B，所以输出 1。
 */
public class _连续字母长度_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        int k = Integer.parseInt(scanner.nextLine());
        // 第一遍的方法
        System.out.print("第一遍的解法：");
        method1(chars, k);
        // 网上做法
        System.out.print("网上的解法：");
        m3(line, k);

        int n = chars.length;
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>((a, b)->b - a);

        int same = 1;
        for (int i = 1; i < n; i++) {

            if (chars[i] == chars[i - 1]) {
                same++;
            } else {
                // 更新该字母的最大连续个数
                Integer old = map.getOrDefault(chars[i - 1], 0);
                int max = Math.max(old, same);
                map.put(chars[i - 1], max);

                // 重新计算新的连续字母的数量
                same = 1;
            }
        }

        // 最后一段连续的
        // 更新该字母的最大连续个数
        Integer old = map.getOrDefault(chars[n - 1], 0);
        int max = Math.max(old, same);
        map.put(chars[n - 1], max);

        // 将所有字母的最大连续次数放入set中
        Iterator<Character> characterIterator = map.keySet().iterator();
        while (characterIterator.hasNext()) {
            set.add(map.get(characterIterator.next()));
        }

        // 通过有序的set集合找到第 k 大的次数
        Iterator<Integer> iterator = set.iterator();
        Integer next = 0;
        while (k > 0 && iterator.hasNext()) {
            next = iterator.next();
            k--;
        }

        if (k > 0) {
            System.out.println(-1);
        } else {
            System.out.print("第二遍解法：");
            System.out.println(next);
        }
    }

    private static void method1(char[] chars, int k) {
        // 统计每个字母连续出现的最大次数
        int[] count = new int[26];
        // 统计每一段连续字母的长度
        int n = chars.length;
        // 从前面到 i 位置，字母不连续了，记录该段连续字母的长度
        List<int[]> indexLen = new ArrayList<>();
        // 答案
        char ans = 'z';

        int same = 1;
        for (int i = 1; i < n; i++) {

            if (chars[i] == chars[i - 1]) {
                same++;
            } else {
                // 更新该字母的最大连续个数
                int index = chars[i - 1] - 'A';
                count[index] = Math.max(count[index], same);
                // 将出现的次数都
                int[] successive = {i - 1, same};
                indexLen.add(successive);

                // 重新计算新的连续字母的数量
                same = 1;
            }
        }

        // 加上最后一段
        int index = chars[n - 1] - 'A';
        count[index] = Math.max(count[index], same);
        int[] successive = {n - 1, same};
        indexLen.add(successive);
        // 排序，按照长度倒排
        Collections.sort(indexLen, (a, b) -> b[1] - a[1]);

        // 找出第 k 大的数
        int preMax = indexLen.get(0)[1];

        for (int i = 1; i < indexLen.size(); i++) {
            k--;

            // 出现次数第一、二、三...k - 1 大的字母已经遍历完，检查剩下的字母中，次数最大，且该字母的次数 = 该字母连续出现在原字符串中的最长长度
            if (k <= 0) {
                // 这里的 i 要往前移动一位
                i--;
                while (i < indexLen.size() && indexLen.get(i)[1] != count[chars[indexLen.get(i)[0]] - 'A']) {
                    i++;
                }

                System.out.println(indexLen.get(i)[1]);
                return;
            }

            // 出现次数相同的，一样大，都是第 n 大，要将这个次数去掉
            while (preMax == indexLen.get(i)[1]) {
                i++;
            }
            preMax = indexLen.get(i)[1];
        }
    }

    // 网上做法
    public static void m3(String input_str, int k) {
        int index = 0;
        //出现次数统计
        HashMap<Character, Integer> char_count_map = new HashMap<>();
        while (index < input_str.length()) {
            char c = input_str.charAt(index);
            int count = 1;
            while (index < input_str.length()-1 && input_str.charAt(index+1) == input_str.charAt(index)) {
                count++;
                index++;
            }
            if (!char_count_map.containsKey(c)) {
                char_count_map.put(c, count);
            } else {
                if (char_count_map.get(c) < count) {
                    char_count_map.put(c, count);
                }
            }
            index++;
        }

        //排序取最长
        List<Character> chars = new ArrayList<>(char_count_map.keySet());
        chars.sort((c1, c2) -> {
            return char_count_map.get(c2) - char_count_map.get(c1);
        });
        if (k > chars.size() || chars.size() == 0 || k <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(char_count_map.get(chars.get(k-1)));
        }

    }

}
