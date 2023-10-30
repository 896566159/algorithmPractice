package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 给定一个长度为 n 的整型数组，表示一个选手在 n 轮内可选择的牌面分数。选手基于规则选牌，请计算所有轮结束后其可以获得的最高总分数。
 * 选择规则如下：
 * 	1：在每轮里选手可以选择获取该轮牌面，则其总分数加上该轮牌面分数，为其新的总分数。
 * 	2：选手也可不选择本轮牌面直接跳到下一轮，此时将当前总分数还原为3轮前的总分数，若当前轮次小于等于3（即在第1、2、3轮选择跳过轮次），则总分数置为0。
 * 	3：选手的初始总分数为0，且必须依次参加每一轮。
 * 输入描述：
 * 	第一行为一个小写逗号分割的字符串，表示n轮的牌面分数，1<= n <=20。
 * 	分数值为整数，-100 <= 分数值 <= 100。
 * 	不考虑格式问题。
 * 输出描述：
 * 	所有轮结束后选手获得的最高总分数。
 *
 * 示例 1：
 * 	输入：
 * 	    1,-5,-6,4,3,6,-2
 * 	输出：
 * 	    11
 * 说明：
 * 	总共有7轮牌面。
 * 	第一轮选择该轮牌面，总分数为1。
 * 	第二轮不选择该轮牌面，总分数还原为0。
 * 	第三轮不选择该轮牌面，总分数还原为0。
 * 	第四轮选择该轮牌面，总分数为4。
 * 	第五轮选择该轮牌面，总分数为7。
 * 	第六轮选择该轮牌面，总分数为13。
 * 	第七轮如果不选择该轮牌面，则总分数还原到3轮1前分数，即第四轮的总分数4，如果选择该轮牌面，总分数为11，所以选择该轮牌面。
 * 	因此，最终的最高总分为11。
 */
public class _玩牌高手_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = split.length;
        int[] nums = new int[n];

        //处理输入
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        // 初始化dp数组，长度为 n + 3
        int[] dp = new int[n + 3];
        dp[0] = Math.max(nums[0], 0);
        if (n > 0) {
            dp[1] = Math.max(dp[0] + nums[1], 0);
        }
        if (n > 1) {
            dp[2] = Math.max(dp[1] + nums[2], 0);
        }
        // 填充 dp 数组
        for (int i = 0; i < n; i++) {
            dp[i + 3] = Math.max(dp[i], dp[i + 2] + nums[i]);
        }

        System.out.println(dp[n + 2]);
    }

}
