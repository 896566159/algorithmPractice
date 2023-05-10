package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _1105_填充书架 {

    public static void main(String[] args) {
        _1105_填充书架 v = new _1105_填充书架();
        System.out.println(v.minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4));
    }

    int[][] books;
    int[] memos;
    int shelfWidth;

    // 按照顺序排放、且不能不能超过宽度
    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.shelfWidth = shelfWidth;
        this.memos = new int[books.length];
        Arrays.fill(memos, -1);
        return dfs(0);
    }

    private int dfs(int start) {
        // 书本已经放完，返回 0
        if (start >= books.length) {
            return 0;
        }

        if (memos[start] != -1) {
            return memos[start];
        }

        int res = Integer.MAX_VALUE;
        int maxH = 0;
        int leftW = shelfWidth;

        for (int i = start; i < books.length; i++) {
            leftW -= books[i][0];
            // 该层宽度不够
            if (leftW < 0) {
                break;
            }

            // [start, i]之间的最高的书
            maxH = Math.max(maxH, books[i][1]);
            res = Math.min(res, dfs(i + 1) + maxH);
        }

        return memos[start] = res;
    }


}
