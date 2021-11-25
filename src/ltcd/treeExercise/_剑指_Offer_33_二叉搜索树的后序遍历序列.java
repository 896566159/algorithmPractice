package ltcd.treeExercise;

import java.util.Deque;
import java.util.LinkedList;

public class _剑指_Offer_33_二叉搜索树的后序遍历序列 {

    public boolean verifyPostorder(int[] postorder) {
        return help(postorder, 0, postorder.length - 1);
    }

    private boolean help(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }

        int root = postorder[end];

        int mid = 0;//the bound of left(start,mid-1) and right(mid,end-1)
        for (int i = end; i >= 0; i--) {
            if (postorder[i] < root) {
                mid = i;
                break;
            }
        }

        for (int i = start; i < mid; i++) {
            if (postorder[i] > root) {
                return false;
            }
        }

        for (int i = mid + 1; i < end - 1; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }

        return help(postorder, start, mid - 1) && help(postorder, mid, end - 1);
    }


    public boolean verifyPostorder1(int[] postorder) {
        // 单调栈使用，单调递增的单调栈
        Deque<Integer> stack = new LinkedList<>();
        int pervElem = Integer.MAX_VALUE;
        // 逆向遍历，就是翻转的先序遍历
        for (int i = postorder.length - 1;i>=0;i--){
            // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if (postorder[i] > pervElem){
                return false;
            }
            while (!stack.isEmpty() && postorder[i] < stack.peek()){
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                pervElem = stack.pop();
            }
            // 这个新元素入栈
            stack.push(postorder[i]);
        }
        return true;
    }

}
