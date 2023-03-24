package ltcd.treeExercise.Trie;

public class _208_实现Trie前缀树_ {

    class Trie {

        // 树的根节点
        TrieNode root;

        // 初始化根节点
        public Trie() {
            root = new TrieNode();
        }

        // 往数中添加单词
        public void insert(String word) {
            TrieNode p = root;

            for (char c : word.toCharArray()) {
                // char -> int
                int index = c - 'a';
                // 初始化孩子节点
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode();
                }
                // 节点下移
                p = p.children[index];
            }

            // 单词遍历结束，p 指向单词的最后一个字母，该字母是一个单词结尾 isWordEnd = true
            p.isWordEnd = true;
        }

        public boolean search(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                // char -> int
                int index = c - 'a';

                // 查看对应的孩子节点是否不为空
                if (p.children[index] == null) {
                    return false;
                }

                // 节点下移
                p = p.children[index];
            }

            // 遍历完目标单词中的所有字母，现在 p 指向单词最后一个字母，返回该字母是否是一个单词的结尾
            return p.isWordEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;

            for (char c : prefix.toCharArray()) {
                // char -> int
                int index = c - 'a';

                // 判断对应的孩子节点是否为空
                if (p.children[index] == null) {
                    return false;
                }

                // 节点下移
                p = p.children[index];
            }

            return true;
        }
    }

    class TrieNode {
        // 26个字母孩子
        TrieNode[] children = new TrieNode[26];
        // 是否是一个某个单词的结尾
        boolean isWordEnd;
    }

}
