package ltcd.treeExercise.difficult;

import java.util.LinkedList;
import java.util.List;

public class _1104_二叉树寻路 {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        list.add(label);//first, add the label

        int start = 1;
        int level = 1;

        while (start << 1 <= label) {
            level++;
            start <<= 1;
        }

        for (int i = level - 1; i > 1; i--) {
            int cur = label >> 1;
            if (i % 2 != level % 2) {//this level's order is desc
                //it's parent: the up one level's min + max - current/2
                list.add(0, (1 << (i - 1)) + ((1 << i) - 1) - cur);
            } else {//this level is even level
                list.add(cur);
            }

            label = cur;
        }

        //last, add the 1
        list.add(0, 1);
        return list;
    }

}
