package nowcoder.outd.Y22Q4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 在一行中输入一个字符串数组，如果其中一个字符串的所有 以索引 0 开头的子串在数组中都有，那么这个字符串就是潜在密码，
 * 在所有潜在密码中 最长的是真正的密码，如果有多个长度相同的真正的密码，那么取字典序最大的为唯一的真正的密码，求唯一的真正的密码。
 *
 * 示例1：
 * 	输入：
 * 		h he hel hell hello o ok n ni nin ninj ninja
 * 	输出：
 * 		ninja
 * 说明： 按要求，hello、ok、ninja都是潜在密码。检查长度，hello、ninja是真正的密码。检查字典序，ninja是唯一真正密码。
 *
 * 示例2：
 * 	输入：
 * 		a b c d f
 * 	输出：
 * 		f
 * 说明： 按要求，a b c d f 都是潜在密码。检查长度，a b c d f 是真正的密码。检查字典序，f是唯一真正密码
 */
public class _真正的密码_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        System.out.println("前缀树-------" + trie(split));
        // ---------------------- 暴力做法--------------------
        Set<String> set = new HashSet<>();

        for (String s : split) {
            set.add(s);
        }

        String ans = "";
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            boolean flag = true;

            // 检查 s 的从 0 开始到每一位字母 形成的子串在 set 中是否都有
            for (int j = s.length() - 1; j > 0; j--) {
                if (!set.contains(s.substring(0, j))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                if (ans.length() < s.length()) {
                    ans = s;
                } else if (ans.length() == s.length()) {
                    ans = ans.compareTo(s) < 0 ? s : ans;
                }
            }
        }

        System.out.println(ans);
    }

    private static String trie(String[] split) {
        // 前缀树 根节点
        TrieNode root = new TrieNode();

        // 建树
        build(root, split);

        String ans = "";
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            boolean flag = true;

            // 检查 s 的从 0 开始到每一位字母 形成的子串在 set 中是否都有
            char[] chars = s.toCharArray();
            TrieNode node = root;
            for (char c : chars) {
                int index = c - 'a';

                // 如果没有子节点或者子节点不是某个单词的结尾，则不是
                if (node.children[index] == null || !node.children[index].isWordEnd) {
                    flag = false;
                }
                node = node.children[index];
            }

            if (flag) {
                if (ans.length() < s.length()) {
                    ans = s;
                } else if (ans.length() == s.length()) {
                    ans = ans.compareTo(s) < 0 ? s : ans;
                }
            }
        }

        return ans;
    }

    private static void build(TrieNode root, String[] split) {
        for (String s : split) {
            TrieNode node = root;
            char[] chars = s.toCharArray();

            for (char c : chars) {
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            // 标记单词结尾
            node.isWordEnd = true;
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd;
    }

}
