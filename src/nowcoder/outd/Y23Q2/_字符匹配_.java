package nowcoder.outd.Y23Q2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 给你一个字符串数组（每个字符串均由小写字母组成）和一个字符规律（由小写字母和.和*组成），识别数组中哪些字符串可以匹配到字符规律上。
 * '.' 匹配任意单个字符，'*' 匹配零个或多个前面的那一个元素，所谓匹配，是要涵盖整个字符串的，而不是部分字符串。
 * <p>
 * 输入描述：
 * 第一行为空格分割的多个字符串，1 <  单个字符串长度 < 100， 1 < 字符串个数 < 100
 * 第二行为字符规律，1 < 字符串个数 < 100  第二行为字符规律，1><= 字符规律长度 <= 50
 * 不需要考虑异常场景
 * 输出描述：
 * 匹配的字符串在数组中的下标（从0开始），多个匹配时下标升序并用,分割，若均不匹配输出-1
 * <p>
 * 示例1：
 * 输入：
 * ab aab
 * .*
 * 输出：
 * 0,1
 */
public class _字符匹配_ {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String strs = scanner.nextLine();
            String reg = scanner.nextLine();
            patternStr(strs, reg.toCharArray());
            solution(strs, reg);
        }
    }

    private static void patternStr(String strs, char[] reg) {
        String[] strings = strs.split(" ");
        List<Integer> resList = new ArrayList<>();

        // 遍历处理每一个字符串
        for (int i = 0; i < strings.length; i++) {
            // 字符串和匹配串的下标
            int sIndex = 0;
            int rIndex = 0;
            char[] chars = strings[i].toCharArray();
            boolean pattern = true;

            while (sIndex < chars.length && rIndex < reg.length) {
                char r = reg[rIndex];
                if (r == '.') {
                    // 任意单个字符，这种情况下，都是匹配的
                    sIndex++;
                } else if (r == '*') {
                    // 匹配零个或多个前面的那一个元素，这种情况下，都是匹配的，且表明该字符后面所有都是匹配的
                    sIndex = chars.length;
                } else {
                    // 要判断字符串和匹配串中对应字幕是否一致，不一致则说明不匹配
                    if (chars[sIndex] != r) {
                        pattern = false;
                        break;
                    }
                    sIndex++;
                }
                rIndex++;
            }

            // 字符串和匹配串中的所有字母都进行了匹配，且都成功匹配
            if (pattern && rIndex == reg.length && sIndex == chars.length) {
                resList.add(i);
            }
        }

        // 结果输出
        if (resList.size() == 0) {
            System.out.print(-1);
        } else {
            for (int i = 0; i < resList.size(); i++) {
                System.out.print(resList.get(i));
                if (i != resList.size() - 1) {
                    System.out.print(",");
                }
            }
        }
    }

    private static void solution(String array, String pattern) {
        String[] strings = array.split(" ");
        List<Integer> resList = new LinkedList<>();
        char[] patterns = pattern.toCharArray();

        // 遍历处理每一个字符串
        for (int n = 0; n < strings.length; n++) {
            String string = strings[n];
            LinkedList<Character> characters = new LinkedList<>();
            for (char c : string.toCharArray()) {
                characters.add(c);
            }

            int i = 0;
            boolean flag = true;
            while (flag && i < patterns.length) {
                if (characters.size() == 0) {
                    break;
                }
                char p = patterns[i];
                switch (p) {
                    case '.':
                        // 任意单个字符，这种情况下，都是匹配的
                        characters.removeFirst();
                        break;
                    case '*':
                        // 匹配零个或多个前面的那一个元素，这种情况下，都是匹配的
                        characters = new LinkedList<>();
                        break;
                    default:
                        // 如果规则中是字母，则需要两个字母相同，否则代表字符串和匹配规则不能匹配
                        if (characters.get(0).equals(p)) {
                            characters.removeFirst();
                        } else {
                            flag = false;
                        }
                        break;
                }
                i++;
            }

            // 字符串中的所有字符、匹配串中所有字符  都全部被扫描匹配，那么说明该字符串是能都被匹配的
            if (characters.size() == 0 && i == patterns.length) {
                resList.add(n);
            }
        }

        if (resList.size() == 0) {
            System.out.print(-1);
        } else {
            for (int i = 0; i < resList.size(); i++) {
                System.out.print(resList.get(i));
                if (i != resList.size() - 1) {
                    System.out.print(",");
                }
            }
        }
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] lines = scanner.nextLine().split(" ");
//        char[] reg = scanner.nextLine().toCharArray();
//
//        // .*
//        int n = lines.length;
//        for (int i = 0; i < n; i++) {
//            int index = 0;
//            int j = 0;
//            boolean flag = true;
//            char[] word = lines[i].toCharArray();
//            char pre = '9';
//
//            while (index < reg.length && j < word.length) {
//                if (reg[i] == '*') {
//                    while (j < word.length) {
//                        if (j > 0 && word[j] != word[j - 1]) {
//                            break;
//                        }
//                        j++;
//                    }
//                } else {
//                    pre = word[j++];
//                }
//                index++;
//            }
//
//            if (flag) {
//                System.out.print(i + " ");
//            }
//        }
//    }

}
