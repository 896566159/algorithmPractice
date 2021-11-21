package ltcd.treeExercise.difficult;


import java.util.Stack;

/**
 * 两种解法：
 *  一是二叉树的特点：非叶子节点至少有一个非空（#）的子节点：
 *      - 两个子节点非空
 *      - 一个子节点是空节点#，另一个不是空节点
 *      从底往上、从左到右（这个顺序刚好是 前序遍历的 逆序），将叶子节点都当做是空节点null，网上递归，最后整棵树会消失掉
 *  二是利用二叉树的  出度 = 入度 的关系来判断（但是不能单单统计数量关系，因为即使整体的出入度相等，但是在子树上出入度可能不相等）
 */
public class _331_验证二叉树的前序序列化 {

    //根据出入度来解决：树的出度的入度
        //每个叶子节点入度为 1 出度为 0
        //每个非叶子节点出度为2，入度为1
        //root节点没有入度
    public boolean isValidSerialization(String preorder) {
        int count = 0;//记录出入度的差值

        for (String node : preorder.split(",")) {
            //无论是否是空节点，遍历到即出度+1，差值-1
            count--;

            if (count < 0) {//如果遍历到某个节点时，出度
                return false;
            }

             if (!node.equals("#")){//不是空节点，入度为1，出度为2，差值+2
                count += 2;
            }
        }

        return count == 0;
    }

    public boolean isValidSerialization1(String preorder) {
        if (preorder == null) {
            return true;
        }

        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("#") || stack.size() < 2) {//如果不是空节点 或者 栈中节点数小于2，直接入栈
                stack.push(nodes[i]);
                continue;
            }

            //表名当前节点是空，且栈的长度大于2
            while (stack.size() >= 2 && stack.peek().equals("#")) {//如果栈的最顶层是空节点，将栈的最顶上2个都弹出来
                stack.pop();
                if (stack.pop().equals("#")) {//如果连续弹出来的两个都是空节点，直接return false
                    return false;
                }
            }

            //将当前的空节点入栈
            stack.push(nodes[i]);
        }

        return stack.size() == 1 && stack.pop().equals("#");
    }

}
