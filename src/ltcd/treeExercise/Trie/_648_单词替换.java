package ltcd.treeExercise.Trie;
import java.util.List;

public class _648_单词替换 {

    // 前缀树的根节点
    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        bulidTrie(dictionary);

        StringBuilder sb = new StringBuilder();
        String[] split = sentence.split(" ");

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String shotPrefix = shotPrefix(s);

            if (!shotPrefix.equals("") && shotPrefix.length() > 0) {
                sb.append(shotPrefix);
            } else {
                sb.append(s);
            }

            if (i + 1 < split.length) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private String shotPrefix(String s) {

        TrieNode p = root;

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int index = c - 'a';

            if (p.children[index] == null) {
                break;
            } else if (p.isWordEnd) {
                return sb.toString();
            }

            sb.append(c);
            p = p.children[index];
        }

        return p.isWordEnd ? sb.toString() : "";
    }

    private void bulidTrie(List<String> dictionary) {
        for (String s : dictionary) {

            // 从根节点开始构建树
            TrieNode p = root;
            for (char c : s.toCharArray()) {
                // char -> int
                int index = c - 'a';

                // 如果对应的孩子节点为空，则新建
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode();
                }

                // 节点下移
                p = p.children[index];
            }

            // 设置 p 指向的节点是单词的结尾
            p.isWordEnd = true;
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd = false;
    }

}
