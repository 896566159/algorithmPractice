package ltcd.treeExercise.Trie;

public class _211_添加与搜索单词_数据结构设计 {

    TrieNode root;

    public _211_添加与搜索单词_数据结构设计() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode p = root;

        for (char c : word.toCharArray()) {
            // char -> int
            int index = c - 'a';

            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }

            p = p.children[index];
        }

        // 设置是某
        p.isWordEnd = true;
    }

    public boolean search(String word) {
        return isContains(word.toCharArray(), root, 0);
    }

    private boolean isContains(char[] chars, TrieNode root, int index) {
        if (root == null) {
            return false;
        }

        if (index == chars.length) {
            return root.isWordEnd;
        }

        if (chars[index] == '.') {
            boolean flag = false;
            for (TrieNode child : root.children) {
                if (isContains(chars, child, index + 1)) {
                    flag = true;
                    break;
                }
            }

            return flag;
        }

        return isContains(chars, root.children[chars[index] - 'a'], index + 1);
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd;
    }

}
