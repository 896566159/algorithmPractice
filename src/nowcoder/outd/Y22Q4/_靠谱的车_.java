package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。
 * 出租车司机解释说他不喜欢数字 4，所以改装了计费表，任何数字位置遇到数字 4 就直接跳过，其余功能都正常。
 * 比如：
 * 	23再多一块钱就变为25；
 * 	39再多一块钱变为50；
 * 	399再多一块钱变为500；
 * 	小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。
 * 	给出计费表的表面读数，返回实际产生的费用。
 * 输入描述：
 * 	只有一行，数字N，表示里程表的读数。(1<=N<=888888888)。
 * 输出描述：
 * 	一个数字，表示实际产生的费用。以回车结束。
 *
 * 示例1：
 * 	输入：
 * 		5
 * 	输出：
 * 		4
 * 说明：
 * 	5表示计费表的表面读数。
 * 	4表示实际产生的费用其实只有4块钱。
 * 示例2：
 * 	输入：
 * 		17
 * 	输出：
 * 		15
 * 说明：
 * 	17表示计费表的表面读数。
 * 	15表示实际产生的费用其实只有15块钱。
 *
 * 示例3：
 * 	输入：
 * 		100
 * 	输出：
 * 		81
 * 说明：
 * 	100表示计费表的表面读数。
 * 	81表示实际产生的费用其实只有81块钱。
 */
public class _靠谱的车_ {

    static char[] chars;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        chars = line.toCharArray();
        int old = Integer.parseInt(line);

        memo = new int[chars.length][10];
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 统计 1 - 0ld 之间包含有数字 4 的个数
        int count = dfs(0, true, 0);
        System.out.println(old - count);


        //---------------------网上的答案--------------
        int price_after = old;
        int ans = price_after;
        redo(price_after, ans);

        countFour(old);
    }

    private static void redo(int price_after, int ans) {
        // k 表示当前跳过了多少个 4
        // cur 表示当前位数
        int skip_money = 0, k = 0, cur = 1;
        while (price_after > 0) {
            //当前位上出现了 4 就 + 1 (并考虑当前的位数)
            if (price_after % 10 > 4) {
                skip_money += (price_after % 10 - 1) * k + cur;
            } else {
                skip_money += (price_after % 10) * k;
            }
            k = k * 9 + cur;
            cur *= 10;
            price_after /= 10;
        }
        System.out.println(ans - skip_money);
    }

    /**
     * 10、100、1000...10^n 以内的正整数中有多少个数包含 4, 规律
     * 10			1                                   只有 4 这个数字
     * 100			9 * 1 + 10 = 19                     以 4 开头的 10 个数(40~49)，不以 4 开头，个位是 4 的有 9个(4,14,24,34,54,64,74,84,94)
     * 1,000		9 * 19 + 100 = 271                  以 4 开头的 100 个数(400~499)， 不以 4 开头个，个位或者十位是 4 的有 9 * 19 (因为每 100 个数中有 19 个)
     * 10,000		9 * 271 + 1000 = 3439               以 4 开头的 1000 个数(400~499)， 不以 4 开头个，个位或者十位是 4 的有 9 * 271 (因为每 1000 个数中有 271 个)
     * 100,000		9 * 3439 + 10,000 = 40,951
     * 1,000,000	9 * 40,951 + 100,000 = 531,441
     * @param n
     */
    private static void countFour(int n) {
        int old = n;
        // 记录 1 ~ n 中有多少个含有 4 的数
        int countFour = 0;
        // 当前数位，从个位、十位、百位、千位...
        int cur = 1;
        // 记录 10、100、1000...10^n 以内的正整数中有多少个数包含 4
        int containsFour = 0;

        while (old > 0) {
            if (old % 10 > 4) {
                countFour += (old % 10 - 1) * containsFour + cur;
            } else {
                countFour += (old % 10) * containsFour;
            }
            containsFour = containsFour + 9 * cur;
            cur *= 10;
            old /= 10;
        }

        System.out.println(n - countFour);
    }

    // 没有百分百的通过，例如：12345、96467875、237949
    private static int dfs(int i, boolean isLimit, int countFour) {
        if (i == chars.length) {
            return countFour;
        }

        if (!isLimit && memo[i][countFour] != -1) {
            return  memo[i][countFour];
        }

        int res = 0;
        int up = isLimit ? chars[i] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            res += dfs(i + 1, isLimit && d == up, countFour + (d == 4 && countFour == 0 ? 1 : 0));
        }

        if (!isLimit) {
            memo[i][countFour] = res;
        }

        return res;
    }

}
