package ltcd.depthFirstSearchExercise;

public class _剑指_Offer_12_矩阵中的路径 {

    public boolean exist(char[][] board, String word) {

        char[] chars = word.toCharArray();
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0, board, chars)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int len, char[][] board, char[] chars) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != chars[len]) {
            return false;
        }

        if (len == chars.length - 1) {
            return true;
        }

        board[i][j] = '\0';
        boolean res = dfs(i - 1, j, len + 1, board, chars) || dfs(i + 1, j, len + 1, board, chars) ||
                dfs(i, j - 1, len + 1, board, chars) || dfs(i, j + 1, len + 1, board, chars);
        board[i][j] = chars[len];

        return res;
    }

}
