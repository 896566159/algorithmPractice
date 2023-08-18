package nowcoder.outd.Y22Q3;

import java.util.*;

/**
 * 某文件系统中有 N 个目录，每个目录都有一个独一无二的 ID。
 * 每个目录只有一个父目录，但每个父目录下可以有零个或者多个子目录，目录结构呈树状结构。
 * 假设，根目录的 ID 为 0，且根目录没有父目录，其他所有目录的 ID 用唯一的正整数表示，并统一编号。
 * 现给定目录 ID 和其父目录 ID 的对应父子关系表[子目录 ID，父目录 ID]，以及一个待删除的目录 ID，
 * 请计算并返回一个 ID 序列，表示因为删除指定目录后剩下的所有目录，返回的ID序列以递增序输出。
 *
 * 注意：
 * 1、被删除的目录或文件编号一定在输入的 ID 序列中；
 * 2、当一个目录删除时，它所有的子目录都会被删除。
 *
 * 输入描述：
 * 	输入的第一行为父子关系表的长度 m；
 * 	接下来的 m 行为 m 个父子关系对；
 * 	最后一行为待删除的 ID。
 * 	序列中的元素以空格分割，参见样例。
 *
 * 输出描述：
 * 	输出一个序列，表示因为删除指定目录后，剩余的目录 ID。
 *
 * 示例1：
 * 	输入：
 * 		5
 * 		8 6
 * 		10 8
 * 		6 0
 * 		20 8
 * 		2 6
 * 		8
 * 	输出：
 * 		2 6
 */
public class _目录删除_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        Map<Integer, Node> map = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            String[] split = scanner.nextLine().split(" ");
            int childId = Integer.parseInt(split[0]);
            int parentId = Integer.parseInt(split[1]);

            // 如果父节点还没被创建
            if (!map.containsKey(parentId)) {
                Node parent = new Node();
                parent.id = parentId;
                parent.children = new ArrayList<>();
                // 记录已经创建的节点
                map.put(parentId, parent);
            }
            // 如果子节点还没被创建
            if (!map.containsKey(childId)) {
                Node cur = new Node();
                cur.id = childId;
                cur.children = new ArrayList<>();
                // 记录已经创建的节点
                map.put(childId, cur);
            }

            // 建立父子关系
            map.get(parentId).children.add(map.get(childId));
        }

        // 获取要删除的文件 Id
        int deleteId = Integer.parseInt(scanner.nextLine());
        if (deleteId == 0) {
            // 删除的是根节点，所有目录都删除，输出空
            System.out.println();
            return;
        }
        deleteFile(deleteId, map);

        int index = 0;
        for (Integer integer : map.keySet()) {
            // 根节点 0 没有要求输出出来
            if (integer != 0) {
                if (index++ > 0) {
                    System.out.print(" ");
                }
                System.out.print(integer);
            }
        }
    }

    private static void deleteFile(int deleteId, Map<Integer, Node> map) {
        if (!map.containsKey(deleteId)) {
            return;
        }

        // 递归删除子节点
        for (Node child : map.get(deleteId).children) {
            deleteFile(child.id, map);
        }
        // 删除完子节点后，删除当前节点
        map.remove(deleteId);
    }

    static class Node {
        int id;
        List<Node> children;
    }

}
