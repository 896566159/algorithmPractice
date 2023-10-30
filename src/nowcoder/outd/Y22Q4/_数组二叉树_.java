package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 二叉树也可以用数组来存储，给定一个数组，树的根节点的值存储在下标1，对于存储在下标N的节点，它的左子节点和右子节点分别存储在下标2N和2N+1，并且我们用值-1代表一个节点为空。
 * 给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。
 *
 * 输入描述:
 * 	输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分隔。
 * 	注意第一个元素即为根节点的值，即数组的第N个元素对应下标N，下标0在树的表示中没有使用，所以我们省略了。
 * 	输入的树最多为7层。
 * 输出描述:
 * 	输出从根节点到最小叶子节点的路径上，各个节点的值，由空格分隔，用例保证最小叶子节点只有一个。
 *
 * 示例1：
 * 	输入:
 * 		3 5 7 -1 -1 2 4
 * 	输出:
 * 		3 7 2
 * 说明: 最小叶子节点的路径为3 7 2
 *
 * 示例2：
 * 	输入:
 * 		5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
 * 	输出:
 * 		5 8 7 6
 * 说明:
 * 	最小叶子节点的路径为5 8 7 6，注意数组仅存储至最后一个非空节点，故不包含节点“7”右子节点的-1
 */
public class _数组二叉树_ {

    static List<Integer> res = new ArrayList<>();
    static int[] nodes;
    static int minLeaf = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        nodes = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            nodes[i] = Integer.parseInt(split[i - 1]);
        }

        List<Integer> path = new ArrayList<>();
        dfs(1, path);
        int size = res.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                System.out.print("," + res.get(i));
            } else {
                System.out.print(res.get(i));
            }
        }
    }

    private static void dfs(int i, List<Integer> path) {
        if (i >= nodes.length || nodes[i] == -1) {
            return;
        }

        path.add(nodes[i]);
        // 没有子节点了
        if (2 * i >= nodes.length) {
            if (minLeaf >= nodes[i]) {
                minLeaf = nodes[i];
                res = new ArrayList<>(path);
            }
            return;
        }

        // 左子树
        if (2 * i < nodes.length) {
            dfs(2 * i, new ArrayList<>(path));
        }

        // 右子树
        if (2 * i + 1 < nodes.length) {
            dfs(2 * i + 1, new ArrayList<>(path));
        }
    }

}
