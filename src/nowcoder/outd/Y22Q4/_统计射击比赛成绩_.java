package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 给定一个射击比赛成绩单，包含 多个选手若干次射击的成绩分数，请对 每个选手按其最高3个分数之和进行降序排名，输出降序排名后的选手 ID 序列。
 * 条件如下:
 *  1、一个选手可以有多个射击成绩的分数，且次序不固定。
 *  2、如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手。
 *  3、如果选手的成绩之和相等，则成绩之和相等的选手按照其 ID隆序排列。
 * 输入描述:
 *  输入第一行，一个整数 N，表示该场比赛总共进行了N次射击，产生N个成绩分数 (2<=N<=100)
 *  输入第二行，一个长度为 N 整数序列，表示参与每次射击的选手 ID (0<=ID<=99)。
 *  输入第三行，一个长度为 N 整数序列，表示参与每次射击的选手对应的成绩 (0<=成绩<=100)。
 * 输出描述:
 *  符合题设条件的降序排名后的选手ID序列。
 * 示例1:
 *  输入:
 *      13
 *      3,3,7,4,4,4,4,7,7,3,5,5,5
 *      53,80,68,24,39,76,66,16,100,55,53,80,55
 *  输出:
 *      5,3,7,4
 *  说明: 该场射击比赛进行了13次，参寒的选手为 3,4,5,7。
 *      3号选手成绩: 53.80.55，最高3个成绩的和为: 80+55+53=188。
 *      4号选手成绩: 24,39,76,66，最高3个成绩的和为: 76+66+39=181.
 *      5号选手成绩: 53,80,55，最高3个成绩的和为: 80+55+53=188.
 *      7号选手成绩: 68,16,100，最高3个成绩的和为: 100+68+16=184.
 *      比较各个选手最高3个成绩的和，有 3号=5号>7号>4号，由于3号和5号成绩相等且ID号5>3，所以输出为: 5,3,7,4
 */
public class _统计射击比赛成绩_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] ids = in.nextLine().split(",");
        String[] scores = in.nextLine().split(",");

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        // 选手id
        for (int i = 0; i < n; i++) {
            int id = Integer.parseInt(ids[i]);
            int score = Integer.parseInt(scores[i]);

            if (map.containsKey(id)) {
                PriorityQueue<Integer> priorityQueue = map.get(id);
                priorityQueue.add(score);
            } else {
                PriorityQueue<Integer> sco = new PriorityQueue<>((a, b) -> b - a);
                sco.add(score);
                map.put(id, sco);
            }
        }

        // 统计选手的总成绩
        List<int[]> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, PriorityQueue<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, PriorityQueue<Integer>> next = iterator.next();
            PriorityQueue<Integer> value = next.getValue();
            if (value.size() > 2) {
                int[] contestant = new int[] {next.getKey(), value.poll() + value.poll() + value.poll()};
                list.add(contestant);
            }
        }

        // 排序
        Collections.sort(list, (a, b)->{
            return b[1] == a[1] ? b[0] - a[0] : b[1] - a[1];
        });

        for (int[] ints : list) {
            System.out.print(ints[0] + " ");
        }

    }

}
