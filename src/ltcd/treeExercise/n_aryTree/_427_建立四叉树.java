package ltcd.treeExercise.n_aryTree;

public class _427_建立四叉树 {

    public SNode construct(int[][] grid) {
        //left, right, up, down
        return helper(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private SNode helper(int[][] grid, int left, int right, int up, int down){
        SNode root  = new SNode();
        if(isSame(grid, left, right, up, down)){
            root.val = grid[up][left] == 1 ? true : false;
            root.isLeaf = true;
            return root;
        }

//        root.isLeaf = false;
//        root.topLeft = helper(grid, left,(right + left) / 2,  up, (up + down) / 2);
//        root.topRight = helper(grid, (right + left) / 2 + 1 , right, up, (up + down) / 2);
//        root.bottomLeft = helper(grid, left, (right + left) / 2 , (up + down) / 2 + 1, down);
//        root.bottomRight = helper(grid, (right + left) / 2 + 1, right, (up + down) / 2 + 1, down);

        return root;
    }

    private boolean isSame(int[][] grid, int left, int right, int up, int down){
        int pre = -1;
        for(int i = up; i <= down; i++)
            for(int j = left; j <= right; j++)
                if(pre != -1){
                    if(pre != grid[i][j])
                        return false;
                }else
                    pre = grid[i][j];


        return true;
    }

}
