package ltcd.treeExercise;

import java.util.*;

public class _671_二叉树中第二小的节点 {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int[] arr = new int[25];
        queue.add(root);
        int index = 0;
        int level_size = queue.size();

        while (!queue.isEmpty()) {

            while (level_size-- > 0) {
                TreeNode pollNode = queue.poll();
                arr[index++] = pollNode.val;

                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                    queue.add(pollNode.right);
                }
            }

            level_size = queue.size();
        }

        if (arr.length == 1) {
            return -1;
        }


        int[] arr1 = new int[index];
        for (int i = 0; i < index; i++) {
            arr1[i] = arr[i];
        }

        Arrays.sort(arr1);
        System.out.println(arr.length);

        for (int i = 0; i < arr1.length; i++) {
            if (i <= arr1.length - 1 && arr[i] < arr[i + 1]) {
                return arr[i + 1];
            }
        }
        return -1;
    }

}
