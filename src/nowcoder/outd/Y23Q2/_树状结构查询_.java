package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 通常使用多行的节点、父节点表示一棵树，
 * 比如:
 * 	西安 陕西
 * 	陕西 中国
 * 	江西 中国
 * 	中国 亚洲
 * 	泰国 亚洲
 * 输入一个节点之后，请打印出来树中他的所有下层节点
 *
 * 输入描述:
 * 	第一行输入行数，下面是多行数据，每行以空格区分节点和父节点
 * 	接着是查询节点
 * 输出描述:
 * 	输出查询节点的所有下层节点。
 * 	以字典序排序
 * 备注: 树中的节点是唯一的，不会出现两个节点，是同一个名字
 *
 * 示例1：
 * 	输入:
 * 		5
 * 		b a
 * 		c a
 * 		d c
 * 		e c
 * 		f d
 * 		c
 * 	输出:
 * 		d
 * 		e
 * 		f
 */
public class _树状结构查询_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Node> nodes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");

            Node parent = null;
            Node child = null;
            if (!nodes.containsKey(split[1])) {
                parent = new Node();
                parent.value = split[1];
                nodes.put(split[1], parent);
            } else {
                parent = nodes.get(split[1]);
            }

            if (!nodes.containsKey(split[0])) {
                child = new Node();
                child.value = split[0];
                nodes.put(split[0], child);
            } else {
                child = nodes.get(split[0]);
            }

            // 确保
            if (parent.children == null) {
                parent.children = new ArrayList<>();
            }
            parent.children.add(child);
        }

        String target = scanner.nextLine();
        List<Node> children = nodes.get(target).children;
        Set<String> res = new TreeSet<>();
        for (Node child : children) {
            dfs(child, res);
        }

        for (String s : res) {
            System.out.println(s);
        }
    }

    private static void dfs(Node child, Set<String> res) {
        if (child == null) {
            return;
        }

        res.add(child.value);
        if (child.children != null) {
            for (Node node : child.children) {
                dfs(node, res);
            }
        }
    }

    static class Node {
        String value;
        List<Node> children;
    }

}
