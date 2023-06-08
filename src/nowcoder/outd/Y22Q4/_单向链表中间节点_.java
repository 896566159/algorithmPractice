package nowcoder.outd.Y22Q4;

import java.util.*;

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
