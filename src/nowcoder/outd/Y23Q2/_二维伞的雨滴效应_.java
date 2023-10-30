package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 普通的伞在二维平面世界中，左右两侧均有一条边，而两侧伞边最下面各有一个伞坠子，雨滴落到伞面，逐步流到伞坠处，会将伞坠的信息携带并落到地面，随着日积月累，地面会呈现伞坠的信息。
 * 1、为了模拟伞状雨滴效应，用二叉树来模拟二维平面伞(如下图所示)，现在输入一串正整数数组序列(不含0，数组成员至少是1个) ，若此数组序列是 二叉搜索树的前序遍历 的结果，那么请输出一个返回值1，否则输出0.
 * 2、同时请将此序列构成的伞状效应携带到地面的数字信息输出来(左边伞坠信息，右边伞坠信息，详细参考示例图地面上数字)，若此树不存在左或右扇坠，则对应位置返回0。同时若 非二叉排序树 那么左右伞坠信息也返回0。
 *
 * 输入描述:
 * 	1个通过空格分割的整数序列字符串，数组不含0，数组成员至少1个，输入的数组的任意两个数字都互不相同，最多1000个正整数，正整数值范围1~655350
 * 输出描述:
 * 	输出如下三个值，以空格分隔: 是否二叉排序树，左侧地面呈现的伞坠数字值，右侧地面呈现的伞坠数字值.
 * 	若是二叉排序树，则输出1，否则输出0 (其左右伞坠值也直接赋值0) 。
 * 	若不存存在左侧或者右侧伞坠值，那么对应伞坠值直接赋值0。
 * 示例1
 * 	输入:
 * 		8 3 1 6 4 7 10 14 13
 * 	输出:
 * 		1 1 13
 * 说明:
 * 	1表示是二叉搜索树前序遍历结果，
 * 	1表示左侧地面呈现的伞坠数字值，
 * 	13表示右侧地面呈现的伞坠数字值
 */
public class _二维伞的雨滴效应_ {

    static Node root;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        int[] nums = new int[n];

        // 输入处理
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        // 只有一个节点，根节点
        if (nums.length == 1) {
            System.out.println(1 + " " + nums[0] + " " + nums[0]);
            return;
        }

        root = new Node();
        root.value = nums[0];
        // 判断数组是否能够构造出二叉搜索树
        if (!isBinarySearchTree(nums, root, 0, nums.length - 1)) {
            System.out.println("0 0 0");
            return;
        }

        // 能够造成二叉搜索树，则需要找出其左右子树的伞坠——两边最边上的一个分支的叶节点
        StringBuilder res = new StringBuilder("1");
        // 找到树的最左边的分支的叶节点
        Node tmp = root;
        if (root.left != null) {
            tmp = root.left;
            // 找出最左边的分支的叶节点
            while (tmp.left != null || tmp.right != null) {
                tmp = tmp.left == null ? tmp.right : tmp.left;
            }
            res.append(" ").append(tmp.value);
        } else {
            // 不存在左子树，则伞坠是 0
            res.append(" ").append(0);
        }

        // 找到树的最右边的一个节点
        tmp = root;
        if (root.right != null) {
            tmp = root.right;
            // 找出最右边的分支的叶节点
            while (tmp.left != null || tmp.right != null) {
                tmp = tmp.right == null ? tmp.left : tmp.right;
            }
            res.append(" ").append(tmp.value);
        } else {
            // 不存在右子树，则伞坠是 0
            res.append(" ").append(0);
        }

        System.out.println(res.toString());
    }

    /**
     * 判断是否可以组成二叉搜索树树，同时记录下形成的树状情况
     * @param nums 构造树的数组
     * @param root 根节点
     * @param start 构造树的数组左边界
     * @param end 构造树的数组右边界
     * @return 是否能够构成树
     */
    private static boolean isBinarySearchTree(int[] nums, Node root, int start, int end) {
        // 如果所有元素都用来构造树了，说明构造成功
        if (end - start < 1) {
            return true;
        }

        // 左子树的根节点是 [start+1, end]区间中，并且它是第一个比根节点值小的数
        int leftIndex = start + 1;
        // 找出左子树
        while (leftIndex <= end && nums[leftIndex] < nums[start]) {
            leftIndex++;
        }

        // 看右子树中是否存在比 root 大的值
        int rightIndex = leftIndex;
        while (rightIndex <= end) {
            if (nums[rightIndex] < nums[start]) {
                return false;
            }
            rightIndex++;
        }

        // 构造左子树，[start+1, leftIndex - 1]区间都是左子树，并且左子树根节点是root节点右边第一个数
        if (leftIndex > start + 1) {
            root.left = new Node();
            root.left.value = nums[start + 1];
            if (!isBinarySearchTree(nums, root.left, start + 1, leftIndex - 1)) {
                return false;
            }
        }

        // 构造右子树， leftIndex < nums.length 确保有没有超出数组的范围，超出了范围说明都是左子树，没有右子树
        if (rightIndex == end + 1 && leftIndex < nums.length) {
            root.right = new Node();
            root.right.value = nums[leftIndex];
            if (!isBinarySearchTree(nums, root.right, leftIndex, end)) {
                return false;
            }
        }

        return true;
    }

    // 树中节点类
    static class Node {
        Node left;
        Node right;
        int value;
    }
}
