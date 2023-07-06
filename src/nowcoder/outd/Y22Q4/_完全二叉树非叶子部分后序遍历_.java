package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个以顺序储存结构存储整数值的完全二叉树序列（最多1000个整数），请找出此完全二叉树的所有非叶子节点部分，然后采用后序遍历方式将此部分树（不包含叶子）输出。
 * 1、只有一个节点的树，此节点认定为根节点（非叶子）。
 * 2、此完全二叉树并非满二叉树，可能存在倒数第二层出现叶子或者无右叶子的情况
 * 其他说明：二叉树的后序遍历是基于根来说的，遍历顺序为：左-右-根
 *
 * 输入描述：
 * 	一个通过空格分割的整数序列字符串
 *
 * 输出描述：
 * 	非叶子部分树结构
 *
 * 示例 1：
 * 	输入：
 * 		1 2 3 4 5 6 7
 * 		1
 * 	输出：
 * 		2 3 1
 * 		1
 * 说明：
 * 	找到非叶子部分树结构，然后采用后序遍历输出
 */
public class _完全二叉树非叶子部分后序遍历_ {

    static String[] tree;
    static List<String> notLeaf = new ArrayList<>();
    static int nodes;

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        tree = scanner.nextLine().split(" ");
        nodes = tree.length;

        dfs(0);
        int size = notLeaf.size();
        for (int i = 0; i < size - 1; i++) {
            System.out.print(notLeaf.get(i) + " ");
        }
        System.out.print(notLeaf.get(size - 1));
    }

    private static void dfs(int i) {
        // 如果该节点已经没有左右孩子——该节点是叶节点
        if (2 * i + 1 >= nodes) {
            return;
        }

        // 左子树
        dfs(2 * i + 1);
        // 右子树
        dfs(2 * i + 2);
        // 当前节点
        notLeaf.add(tree[i]);
    }

}
