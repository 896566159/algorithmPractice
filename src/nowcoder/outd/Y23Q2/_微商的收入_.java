package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 微商模式比较典型，下级每赚 100 元就要上交 15 元，给出每个级别的收入，求出金字塔尖上的人收入。
 * 输入描述:
 * 	第一行输入N，表示有N个代理商上下级关系接下来输入N行，每行三个数:
 * 	代理商代号 上级代理商代号 代理商赚的钱
 * 输出描述:
 * 	输出一行，两个以空格分隔的整数，含义如下
 * 	金字塔顶代理商 最终的钱数
 *
 * 示例1：
 * 	输入:
 * 	    3
 * 		1 0 223
 * 		2 0 323
 * 		3 2 1203
 * 	输出:
 * 		0 105
 * 说明:
 * 	2的最终收入等于 323 + 1203/100*15 = 323 + 180
 * 	0的最终收入等于 (323 + 180 + 223) / 100 * 15 = 105
 *
 * 示例2：
 * 	输入:
 * 	    4
 * 		1 0 100
 * 		2 0 200
 * 		3 0 300
 * 		4 0 200
 * 	输出:
 * 		0 120
 */
public class _微商的收入_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, Node> set = new HashMap<>();

        // 输入 n 行
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");

            // 当前节点
            Node cur = new Node();
            int curValue = Integer.parseInt(line[2]);
            cur.value = curValue;
            set.put(Integer.parseInt(line[0]), cur);

            // 父节点
            Node parent = new Node();
            int pNo = Integer.parseInt(line[1]);
            // 父节点是否已经创建过
            if (set.containsKey(pNo)) {
                parent = set.get(pNo);
                // 把收入变成 整百
                curValue = curValue / 100 * 100;
                parent.value += (int) (curValue * 0.15);
                int tmp = 2;

                // 向上更新
                while (parent.parent != null) {
                    parent = parent.parent;
                    parent.value += curValue * Math.pow(0.15, tmp++);
                }
            } else {
                // 父节点没有创建过
                parent.children = new ArrayList<>();
                parent.value = (int) (curValue * 0.15);
                set.put(pNo, parent);
            }

            // 设置父节点
            cur.parent = parent;
            parent.children.add(cur);
        }

        // 输出答案
        for (Map.Entry<Integer, Node> entry : set.entrySet()) {
            // 最顶级的代理商没有父节点，输出其值
            if (entry.getValue().parent == null) {
                System.out.println(entry.getValue().value);
            }
        }
    }

    static class Node {
        int value;
        Node parent;
        List<Node> children;
    }
}
