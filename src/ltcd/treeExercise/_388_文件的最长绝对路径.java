package ltcd.treeExercise;

public class _388_文件的最长绝对路径 {

    int res = 0, i = 0;

    public int lengthLongestPath(String input) {
        dfs(input.split("\n"), 0, 0);
        return res;
    }

    void dfs(String[] arr, int level, int len) {
        String str = "";
        for (int j = 1; j <= level; ++j) {
            str += "\t";
        }
        while (i < arr.length) {
            if (str.length() > 0 && arr[i].startsWith(str) && !arr[i].startsWith(str + "\t") || str.length() == 0 && !arr[i].startsWith("\t")) {
                if (arr[i].contains(".")) {
                    res = Math.max(res, len + arr[i++].length() - level);
                } else {
                    dfs(arr, level + 1, len + arr[i++].length() - level + 1);
                }
            } else {
                return;
            }
        }
    }

}
