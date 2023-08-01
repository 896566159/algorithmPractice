package nowcoder.outd.hard;

import java.util.*;

/**
 * 某购物城有m个商铺，现决定举办一场活动选出人气最高店铺。
 * 活动共有n位市民参与，每位市民只能投一票，但1号店铺如果给该市民发放q元的购物补贴，该市民会改为投1号店铺。
 * 请计算1号店铺需要最少发放多少元购物补贴才能成为人气最高店铺(即获得的票数要大于其他店铺)，如果1号店铺本身就是票数最高店铺，返回0。
 *
 * 输入描述:
 * 	第一行为小写逗号分割的两个整数n，m，其中第一个整数n表示参与的市民总数，第二个整数m代表店铺总数，1<= n, m <= 3000.
 * 	第2到n+1行，每行为小写逗号分割的两个整数p，q，表示市民的意向投票情况，其中每行的第一个整数p表示该市民意向投票给p号店铺，第二个整数q表示其改投1号店铺所需给予的q元购物补贴，1 <= p <= m,1<= q <= 10^9.不考虑输入的格式问题
 * 输出描述:
 * 	1号店铺需要最少发放购物补贴金额。
 *
 * 示例1:
 * 	输入:
 * 		5,5
 * 		2,10
 * 		3,20
 * 		4,30
 * 		5,40
 * 		5,90
 * 	输出:
 * 		50
 * 说明:
 * 	有5个人参与，共5个店铺。
 * 	如果选择发放 10元+20元+30元=60元 的补贴来抢2.3.4号店铺的票，总共发放了60元补贴
 * 	(5号店铺有2票，1号店铺要3票才能胜出)
 * 	如果选择发放 10元+40元=50元 的补贴来抢2.5号店铺的票，总共发放了50元补贴
 * 	(抢了5号店铺的票后，现在1号店铺只要2票就能胜出)
 * 	所以最少发放50元补贴
 *
 * 示例2:
 * 	输入:
 * 		5,5
 * 		2,10
 * 		3,20
 * 		4,30
 * 		5,80
 * 		5,90
 * 	输出:
 * 		60
 * 说明:
 * 	有5个人参与，共5个店铺.
 * 	如果选择发放 10元+20元+30元=60元 的补贴来抢2.3.4号店铺的票，总共发放了60元补贴(5号店铺有2票，1号店铺要3票才能胜出)
 * 	如果选择发放 10元+80元=90元 的补贴来抢2,5号店铺的票，总共发放了90元补贴(抢了5号店铺的票后，现在1号店铺只要2票就能胜出)
 * 	所以最少发放60元补贴
 */
public class _人气最高的店铺_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[0]);
        List<int[]> others = new ArrayList<>();
        // 统计店铺的票数
        int[] count = new int[m + 1];
        // 1号店铺的票数
        int oneStoreStickets = 0;
        // 最多票数的店铺拥有的票数
        int maxStickets = 0;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(",");
            int store = Integer.parseInt(line[0]);
            int price = Integer.parseInt(line[1]);

            // 更新店铺的票数，并且统计拥有最多票数的店铺拥有的票数
            if (maxStickets < ++count[store]) {
                maxStickets = count[store];
            }

            // 没有给 1 号店铺投票的人
            if (store != 1) {
                others.add(new int[]{store, price});
            } else {
                oneStoreStickets++;
            }
        }

        // 看 1 好店铺是不是票数最多的: 检查从 2 号店铺~m 号店铺
        boolean oneStoreIsMax = true;
        for (int i = 2; i < m; i++) {
            if (count[i] >= oneStoreStickets) {
                oneStoreIsMax = false;
                break;
            }
        }

        // 1 号店铺是票数最多的，无需贿赂，返回 0
        if (oneStoreIsMax) {
            System.out.println(0);
            return;
        }

        // 没有投票给 1 号店铺的选手按照代价排序
        Collections.sort(others, (a, b)->a[1] - b[1]);
        // 除 1 号以外的店铺编号，以及这些投票人改投 1 号店铺所需要的代价列表（有序的——从小到大）
        Map<Integer, List<Integer>> storesStickets = new HashMap<>();
        for (int i = 0; i < others.size(); i++) {
            int[] voter = others.get(i);
            int store = voter[0];

            if (!storesStickets.containsKey(store)) {
                storesStickets.put(store, new ArrayList<>());
            }
            storesStickets.get(store).add(voter[1]);
        }

        // 穷举 1 号店铺的投票数 [oneStoreStickets + 1, n]，看在那个票数下，贿赂的金额最少
        int minGlove = Integer.MAX_VALUE;
        for (int i = oneStoreStickets + 1; i < n; i++) {
            // 拷贝
            int[] copyCount = new int[m + 1];
            System.arraycopy(count, 0, copyCount, 0, m + 1);
            Map<Integer, List<Integer>> tmpStoresStickets = new HashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : storesStickets.entrySet()) {
                tmpStoresStickets.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }

            int bribery = f(i, oneStoreStickets, tmpStoresStickets, m + 1, copyCount);
            if (bribery != -1 && minGlove > bribery) {
                minGlove = bribery;
            }
        }

        System.out.println(minGlove);
    }

    /**
     * 如果 1 号店铺的票数为 target 时，是不是人气王，同时，如果是的话返回要贿赂多少才能让 1 号店的票数从 original 变成 target
     * @param target 1 号店铺的票数为 target 时，是不是人气王
     * @param original 1 号店铺的票数的原始票数
     * @param storesStickets 其他店铺以及店铺的得票列表
     * @param m 店铺数量
     * @param count 店铺对应的投票数量
     * @return
     */
    private static int f(int target, int original, Map<Integer, List<Integer>> storesStickets, int m, int[] count) {
        // 需要贿赂多少名额
        int diff = target - original;
        // 贿赂的金额
        int bribery = 0;

        // 要让 target 是人气王，则需要先贿赂其他票数 >= target 的店铺的人
        for (int i = 2; i < m; i++) {
            if (count[i] >= target) {
                // 可贿赂的名额不够了
                if (--diff < 0) {
                    return -1;
                }

                List<Integer> list = storesStickets.get(i);
                while (list.size() >= target) {
                    bribery += list.remove(0);
                }

                if (list.isEmpty()) {
                    count[i] = 0;
                    storesStickets.remove(i);
                }
            }
        }

        // 还需要继续贿赂， 1 好店铺的人数才是人气王
        while (diff > 0) {
            // 从 m 个店铺中找出代价最低的那个，标记他的店铺 id
            int id = -1;
            int tmp = Integer.MAX_VALUE;
            for (Map.Entry<Integer, List<Integer>> entry : storesStickets.entrySet()) {
                List<Integer> value = entry.getValue();
                if (value.get(0) < tmp) {
                    tmp = value.get(0);
                    id = entry.getKey();
                }
            }

            // 贿赂代价最低的这个人
            diff--;
            bribery += storesStickets.get(id).remove(0);
            if (storesStickets.get(id).isEmpty()) {
                storesStickets.remove(id);
            }
        }

        return bribery;
    }

}
