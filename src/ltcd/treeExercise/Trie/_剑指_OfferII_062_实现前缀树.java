package ltcd.treeExercise.Trie;

public class _剑指_OfferII_062_实现前缀树 {

    TrieNode root = new TrieNode();

    public static void main(String[] args) {
        _剑指_OfferII_062_实现前缀树 v = new _剑指_OfferII_062_实现前缀树();
        v.insert("abc");
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = this.root;

        for (char c : chars) {
            // char -> int
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            // 更新node
            node = node.children[index];
        }

        // 将叶子结点设置为单词的结尾
        node.isWorldEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = this.root;

        for (char c : chars) {
            // char -> int
            int index = c - 'a';

            // 孩子节点为空，则说明前缀树上没有该单词
            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        // 返回是否是某个单词的结尾
        return node.isWorldEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode node = this.root;

        for (char c : chars) {
            // char -> int
            int index = c - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        return true;
    }

    class TrieNode {
        // 孩子节点
        TrieNode[] children = new TrieNode[26];
        // 是否是某个单词的结尾
        boolean isWorldEnd;
    }
}
