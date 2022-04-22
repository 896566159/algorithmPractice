package ltcd.treeExercise.difficult;

import java.util.*;

public class _1932_合并多棵二叉搜索树 {

    Map<Integer, TreeNode> valueToNode = new HashMap<>();
    int pre = Integer.MIN_VALUE;

    public TreeNode canMerge(List<TreeNode> trees) {
        //set用于存储叶子结点
        Set<Integer> leaves = new HashSet<>();

        //遍历所有树的叶子结点
        for (TreeNode node: trees) {
            if (node.left != null) {
                if (leaves.contains(node.left.val)) {//若当前树的叶子结点出现过，即某两棵树有重复的叶子结点，不能构成树，返回空null
                    return null;
                }
                leaves.add(node.left.val);
            }

            if (node.right != null) {
                if (leaves.contains(node.right.val)) {//若当前树的叶子结点出现过，即某两棵树有重复的叶子结点，不能构成树，返回空null
                    return null;
                }
                leaves.add(node.right.val);
            }
        }

        //将每棵树的根节点，和根节点的值封装成K-V对插入map中
        for (TreeNode node: trees) {
            valueToNode.put(node.val, node);
        }

        //仅有一个根节点不在leaves内:因为合并的时候，两棵树合并时会删除其中一颗树的根节点，如果
        //叶子结点的数量 - 根节点的数量 != 1， 则无法构成树，返回空
        Set<Integer> roots = new HashSet<>();
        roots.addAll(valueToNode.keySet());
        roots.removeAll(leaves);

        //叶子结点的数量 - 根节点的数量 != 1， 则无法构成树，返回空
        if (roots.size() != 1) {
            return null;
        }

        //开始合并，挑选存储所有根节点的map中的其中一个根节点作为root节点，开始构建树
        Integer rootValue = roots.iterator().next();
        TreeNode root = valueToNode.get(rootValue);
        dfs(root);

        //构建树完成，将存储树的map中的选为根节点的root删除
        valueToNode.remove(rootValue);
        if (!valueToNode.isEmpty()) {//如果删除了root节点，map中还有没有合并到的根节点，则不能构成一棵树
            return null;
        }

        //完成以上步骤，说明能够构成一棵树，接下来通过中序遍历来验证是否是二叉搜索树
        if (inOrderTraverse(root)) {
            return null;
        }

        return root;
    }

    private boolean inOrderTraverse(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!inOrderTraverse(root.left)) {
            return false;
        }

        if (pre >= root.val) {
            return false;
        }
        pre = root.val;

        if (!inOrderTraverse(root.right)) {
            return false;
        }

        return true;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            TreeNode child = valueToNode.get(node.val);

            //如果该节点没有孩子，则返回
            if (child == null) {
                return;
            }

            //如果该节点有孩子，则将孩子节点的做左孩子和右孩子接在该节点上，并删除该节点
            node.left = child.left;
            node.right = child.right;
            valueToNode.remove(node.val);
        }

        dfs(node.left);
        dfs(node.right);
    }

}
