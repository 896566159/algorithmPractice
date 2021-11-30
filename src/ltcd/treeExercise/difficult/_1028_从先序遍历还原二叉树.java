package ltcd.treeExercise.difficult;

import java.util.Stack;

public class _1028_从先序遍历还原二叉树 {

    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();

        for (int i = 0; i < traversal.length(); ) {
            //count the level
            int level = 0;
            while (traversal.charAt(i) == '-') {
                level++;
                i++;
            }

            //examine the number
            int val = 0;
            while (i < traversal.length() && traversal.charAt(i) != '-') {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            //find the parent
            while (stack.size() > level) {
                stack.pop();
            }

            //create the node
            ltcd.treeExercise.TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                //if parent has only noe child, it's left
                if (stack.peek().left == null) {
                    stack.peek().left = (TreeNode) node;
                } else {
                    stack.peek().right = (TreeNode) node;
                }
            }

            //push stack
            stack.add((TreeNode) node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.pop();
    }
}
