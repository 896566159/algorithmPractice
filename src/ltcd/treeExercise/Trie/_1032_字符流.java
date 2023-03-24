package ltcd.treeExercise.Trie;

import java.util.ArrayList;
import java.util.List;

public class _1032_字符流 {

    TrieNode root = new TrieNode();
    List<Character> letters = new ArrayList<>();

    public _1032_字符流(String[] words) {

        for (String word : words) {

            TrieNode p = root;
            char[] chars = word.toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                // char -> int
                int index = chars[i] - 'a';

                // 如果孩子节点是空，则创建节点
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode();
                }

                // 节点下移
                p = p.children[index];
            }

            // 单词遍历结束，节点设置为 单词的结尾
            p.isWordEnd = true;
        }
    }

    public boolean query(char letter) {
        TrieNode p = root;
        letters.add(0, letter);

        for (int i = 0; i < letters.size() && i < 200; i++) {
            int index = letters.get(i) - 'a';

            if (p.children[index] == null) {
                break;
            } else if (p.isWordEnd) {
                return true;
            }

            p = p.children[index];
        }

        return p.isWordEnd;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd;
    }


    // 超时
//    public _1032_字符流(String[] words) {
//        this.words = words;
//    }
//    public boolean query(char letter) {
//        Set<String> tmp = new HashSet<>();
//        for (String s : set) {
//            tmp.add(s + letter);
//        }
//        tmp.add(letter + "");
//
//        set = tmp;
//        for (String word : words) {
//            if (set.contains(word)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

}
