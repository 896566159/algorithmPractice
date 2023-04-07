package nowcoder.outd.Y23Q1;

import java.util.Scanner;

public class _新员工考试_ {
    static int ans = 0;
    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 1表示马上要回答的题目数量，0表示错误的个数
        dfs(n, 1, 0);
        System.out.println(ans);
    }

    /**
     * 已经回答了 i - 1 题目，现在作答 第i道
     * @param target 目标分数
     * @param i 第i道题目
     * @param wrong 已经答错的数量
     */
    private static void dfs(int target, int i, int wrong) {
        // 如果目标分数已经为0，则 归
        if (target == 0) {
            // 又有一种方案可以得到目标分数，方案总数++
            ans++;
            return;
        }

        // 如果答完25道题目，或者错题数达到3，结束考试
        if (i > 25 || wrong >= 3) {
            return;
        }

        if (i <= 10) {
            // TODO 选择题
            // 本题答对
            dfs(target - 2, i + 1, wrong);
            // 本题答错
            dfs(target, i + 1, wrong + 1);
        } else if (i <= 20) {
            // TODO 判断题
            // 本题答对
            dfs(target - 4, i + 1, wrong);
            // 本题答错
            dfs(target, i + 1, wrong + 1);
        } else {
            // TODO 多选题
            // 本题答对
            dfs(target - 8, i + 1, wrong);
            // 本题答错
            dfs(target, i + 1, wrong + 1);
        }
    }

}
