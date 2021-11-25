package ltcd.treeExercise;

import java.util.Deque;
import java.util.LinkedList;

public class _993_二叉树的堂兄弟节点 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> deque=new LinkedList<>();
        boolean existX=false;
        boolean existY=false;
        if(root==null) return false;
        deque.offer(root);
        while(!deque.isEmpty()){
            int length=deque.size();
            for(int i=0;i<length;i++){
                TreeNode node=deque.poll();

                if(node.left!=null){
                    if(node.left.val==x) existX=true;
                    if(node.left.val==y) existY=true;
                    deque.add(node.left);

                }
                if(node.right!=null){
                    if(node.right.val==x) existX=true;
                    if(node.right.val==y) existY=true;
                    deque.add(node.right);
                }
                if(node.left!=null&&node.right!=null){
                    if((node.left.val==x&&node.right.val==y)||(node.left.val==y&&node.right.val==x)) return false;
                }
                if(existY&&existX) return true;
            }
            existY=false;
            existX=false;
        }

        return false;
    }

}
