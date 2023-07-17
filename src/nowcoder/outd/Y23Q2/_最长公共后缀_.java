package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 编写一个函数来查找 字符串数组 中的最长公共后缀如果不存在公共后缀，返回固定字符串:@Zero.
 * 	补充说明:
 * 	1、字符串长度范围:[2,1000];
 * 	2、字符串中字符长度范围为[1，126]
 * 输入描述：
 * 	["abc" "bbc" c]
 * 输出描述：
 * 	"c"
 *
 * 示例1：
 * 	输入:
 * 		["abc","bbc","c"]
 * 	输出:
 * 		"c"
 * 说明: 返回公共后缀: c
 *
 *
 * 示例2：
 * 	输入:
 * 		["aa","bb","cc"]
 * 	输出:
 * 		"@Zero"
 * 说明: 不存在公共后缀，返回固定结果: @Zero
 */
public class _最长公共后缀_ {

    static TrieNode root = new TrieNode();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().replace("[", "")
                            .replace("]", "")
                            .replace("\"", "").split(",");

        for (int k = 0; k < split.length; k++) {
            char[] chars = split[k].toCharArray();
            // 从后向前遍历
            TrieNode node = root;
            for (int i = chars.length - 1; i >= 0; i--) {
                int index = (int) chars[i];

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();

                    // 如果该单词的第一个字母就和之前的字母不相同，则直接返回
                    if (k != 0 && node == root && i == chars.length - 1) {
                        System.out.println("@Zero");
                        return;
                    }
                }

                node = node.children[index];
            }

            node.isWordEnd = true;
        }

        StringBuilder sb = new StringBuilder();
        TrieNode node = root;
        while (node != null) {
            int count = 0;
            int index = -1;

            for (int i = node.children.length - 1; i >= 0; i--) {
                if (node.children[i] != null) {
                    count++;
                    index = i;
                }
            }

            if (count > 1) {
                break;
            }
            sb.append((char) index);
            if (node.children[index].isWordEnd) {
                break;
            }
            node = node.children[index];
        }

        System.out.println(sb.reverse().toString());
    }

    static class TrieNode {
        boolean isWordEnd;
        TrieNode[] children = new TrieNode[128];
    }

}
