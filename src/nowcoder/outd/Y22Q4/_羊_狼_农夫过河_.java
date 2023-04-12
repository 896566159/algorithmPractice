package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 羊、狼、农夫都在岸边，当羊的数量小于狼的数量时，狼会攻击羊，农夫则会损失羊。农夫有一艘容量固定的船，能够承载固定数量的动物。
 * 要求求出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。只计算农夫去对岸的次数，回程时农夫不会运送羊和狼。
 * 备注: 农夫在或农夫离开后羊的数量大于狼的数量时狼不会攻击羊。 农夫自身不占用船的容量。
 * 输入描述
 * 第一行输入为M，N，X，分别代表羊的数量，狼的数量，小船的容量.
 * 输出描述
 * 输出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。(若无法满足条件则输出0)
 * 示例1:
 * 输入:5 33
 * 输出:3
 * 说明:第一次运2只狼 第二次运3只羊 第三次运2只羊和1只狼
 * 示例2:
 * 输入:
 * 5 41
 * 输出: 0
 * 说明: 如果找不到不损失羊的运送方案，输出0
 */
public class _羊_狼_农夫过河_ {

    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        if (m < n) {
            System.out.println("0");
        }

        dfs(m, n, x, 0, 0, 0);

        // 输出有多少种运输方案
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

    /**
     *
     * @param m 还没有运送的羊
     * @param n 还没有运送的狼
     * @param limit 船的运输上线
     * @param sheep 已经运送的羊
     * @param wolf 已经运送的狼
     * @param count 运送了多少次
     */
    private static void dfs(int m, int n, int limit, int sheep, int wolf, int count) {
        // 如果还没有运输过河的狼羊数量为负数，则不合理，退出递归
        if (m < 0 || n < 0) {
            return;
        }

        // 河两岸的羊数量不为零（即已经运输过至少一次了），并且：还没有运过河的 羊 < 狼，或者已经运过河的 羊 < 狼。则此方案不可行，退出递归
        if ((m < n && n != 0) || (sheep < wolf && sheep != 0)) {
            return;
        }

        // 狼羊全部过河，方案可行，更新答案
        if (m == 0 && n == 0) {
            ans = Math.min(count, ans);
            return;
        }

        // 一次至少应该运一只动物，不然死循环
        for (int i = 1; i <= limit; i++) {
            // 运一次最多 limit = i + limit - i，并且不是每一次都会运满 limit 只
            // 运送羊 i 只，运送狼 limit - i 只
            for (int j = 0; j <= limit - i; j++) {
                dfs(m - i, n - j, limit, sheep + i, wolf + j, count + 1);
            }
        }
    }
}
