package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 求单向链表中间的节点值，如果奇数个节点取中间，偶数个取偏右边的那个值。
 *
 * 输入描述：
 * 	第一行 链表头节点地址path 后续输入的节点数n
 * 	后续输入每行表示一个节点，格式:   "节点地址  节点值  下一个节点地址(-1表示空指针)“
 * 	输入保证链表不会出现环，并且可能存在一些节点不属于链表。
 * 输出描述：
 * 	链表中间节点值。
 *
 * 测试用例:
 * 	输入:
 * 		00010 4
 * 		00000 3 -1
 * 		00010 5 12309
 * 		11451 6 00000
 * 		12309 7 11451
 * 	输出:
 * 		6
 */
public class _单向链表中间节点_ {

    public static void main(String[] args) {
        Map<String, Node> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String head = scanner.next();
        int count = scanner.nextInt();

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            nodes.add(new Node(scanner.next(), scanner.nextInt(), scanner.next()));
        }

        // 节点地址和节点值映射
        for (Node node : nodes) {
            map.put(node.add, node);
        }

        // 如果节点数是奇数，则就是中间的那个；如果是偶数，则是中间两个中偏右边的那个
        int index = (count >> 1) + 1;
        Node p = map.get(head);
        while (index > 1) {
            p = map.get(p.nextAdd);
            index--;
        }

        System.out.println(p.val);
    }
}

class Node {
    String add;
    Integer val;
    String nextAdd;

    public Node(String add, Integer val, String nextAdd) {
        this.add = add;
        this.val = val;
        this.nextAdd = nextAdd;
    }
}
