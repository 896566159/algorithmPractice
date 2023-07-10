package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 日志采集是运维系统的的核心组件。日志是按行生成，每行记做一条，由采集系统分批上报。
 * 如果上报太频繁，会对服务端造成压力;如果上报太晚，会降低用户的体验;如果一次上报的条数太多，会导致超时失败。为此，项目组设计了如下的上报策略:
 * 	1、每成功上报一条日志，奖励 1分
 * 	2、每条日志每延迟上报 1 秒，扣 1分
 * 	3、积累日志达到 100 条，必须立即上报
 * 给出日志序列，根据该规则，计算首次上报能获得的最多积分数
 *
 * 输入描述:
 * 	按时序产生的日志条数 T1,T2...Tn，其中 1 <= n <= 1000，0 <= Ti <= 100
 * 输出描述:
 * 	首次上报最多能获得的积分数
 *
 * 示例1:
 * 	输入:
 * 		1 98 1
 * 	输出
 * 		98
 * 说明：
 * 	T1 时刻上报得 1 分
 * 	T2 时刻上报得98分，最大
 * 	T3 时刻上报得 0 分
 *
 * 示例2:
 * 	输入:
 * 		3 7 40 10 60
 * 	输出:
 * 		37
 * 说明：
 * 	T1 时刻上报得 3 分
 * 	T2 时刻上报得 7 分
 * 	T3 时刻上报得 37 分，最大
 * 	T4 时刻上报得 -3 分
 * 	T5 时刻上报，因为已经超了100条的限制，所以只能上报100条，得 -23 分
 */
public class _日志首次上报最多积分_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        // 记录从一开始到当前秒的总条数
        int sum = 0;
        // 记录从一开始到当前秒之前的总条数
        // 每一轮都会减一次
        int preSum = 0;
        // 记录到当前秒首次上报要减去的分数
        int diffScore = 0;
        // 记录到首次上报的最大得分
        int maxScore = 0;

        for (int i = 0; i < n; i++) {
            preSum = sum;
            sum += nums[i];
            diffScore += preSum;

            if (sum >= 100) {
                // 累计数量超过100，必须进行第一次日志上传
                sum = 100;
                maxScore = Math.max(maxScore, sum - diffScore);
                break;
            }
            maxScore = Math.max(maxScore, sum - diffScore);
        }

        System.out.println(maxScore);
    }

}
