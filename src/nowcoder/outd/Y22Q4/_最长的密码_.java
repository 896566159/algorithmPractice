package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 小王在进行游戏大闯关，有一个关卡需要输入一个密码才能通过，密码获得的条件如下：
 * 在一个密码本中，每一页都有一个由 26个小写字母 组成的若干位密码，每一页的密码不同，需要从这个密码本中寻找这样一个最长的密码，
 * 从它的末尾开始依次去掉一位得到的新密码也在密码本中存在。
 * 请输出符合要求的密码，如果有多个符合要求的密码，则返回字典序最大的密码。
 * 若没有符合要求的密码，则返回空字符串。
 *
 * 输入描述：
 * 	密码本由一个字符串数组组成，不同元素之间使用空格隔开，每一个元素代表密码本每一页的密码。
 * 输出描述：
 * 	一个字符串
 *
 * 示例1：
 * 	输入：
 * 		h he hel hell hello
 * 	输出：
 * 		hello
 *
 * 示例2：
 * 	输入：
 * 		b ereddred bw bww bwwl bwwlm bwwln
 * 	输出：
 * 		bwwln
 */
public class _最长的密码_ {

    static TrieNode root;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        // 建立字典树
        root = new TrieNode();
        root.isWordEnd = true;
        build(words);

        // 查找最长的密码
        int max = 0;
        String res = new String();
        for (String word : words) {
            TrieNode node = root;
            boolean isPwd = true;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (!node.isWordEnd) {
                    isPwd = false;
                    break;
                }
                node = node.children[index];
            }

            if (isPwd && max <= words.length && res.compareTo(word) < 0) {
                max = word.length();
                res = word;
            }
        }

        System.out.println(res);
    }

    private static void build(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWordEnd = true;
        }
    }

    static class TrieNode {
        boolean isWordEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

}
