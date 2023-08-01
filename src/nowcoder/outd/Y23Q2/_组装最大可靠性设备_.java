package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 一个设备由N种类型元器件组成(每种类型元器件只需要一个，类型type编号从0~N-1),
 * 每个元器件均有可靠性属性reliability，可靠性越高的器件其价格price越贵。
 * 而设备的可靠性由组成设备的所有器件中可靠性最低的器件决定。
 * 给定预算S，购买N种元器件(每种类型元器件都需要购买一个)，在不超过预算的情况下，请给出能够组成的设备的最大可靠性.
 * 输入描述：
 * 	S N // S总的预算，N元器件的种类
 * 	total // 元器件的总数，每种型号的元器件可以有多种:
 * 	此后有total行具体器件的数据
 * 	type reliability price // type 整数类型，代表元器件的类型编号从0 ~ N-1; reliabily 整数类型，代表元器件的可靠性: price 整数类型，代表元器件的价格
 * 输出描述：
 * 	符合预算的设备的最大可靠性，如果预算无法买产N种器件，则返回 -1
 * 备注：
 * 0 <= S,price <= 10000000
 * 0 <= N <= 100
 * 0 <= type <= N-1
 * 0 <= total <= 100000
 * 0 < reliability <= 100000
 *
 * 示例1：
 * 	输入：
 * 		500 3
 * 		6
 * 		0 80 100
 * 		0 90 200
 * 		1 50 50
 * 		1 70 210
 * 		2 50 100
 * 		2 60 150
 * 	输出：
 * 		60
 * 说明：
 * 	预算500，设备需要3种元件组成，方案类型0的第一个(可靠性80),
 * 	类型1的第二个(可靠性70).
 * 	类型2的第二个(可靠性60).
 * 	可以使设备的可靠性最大 60
 *
 * 示例2：
 *
 * 	输入：
 * 		100 1
 * 		1
 * 		0 90 200
 * 	输出：
 * 		-1
 * 说明：组成设备需要1个元件，但是元件价格大于预算，因此无法组成设备，返回-1
 */
public class _组装最大可靠性设备_ {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int plan = Integer.parseInt(split[0]);
        int demand = Integer.parseInt(split[1]);
        int tatol = Integer.parseInt(scanner.nextLine());
        Map<Integer, List<int[]>> bom = new HashMap<>();

        for (int i = 0; i < tatol; i++) {
            split = scanner.nextLine().split(" ");
            int type = Integer.parseInt(split[0]);
            int reliability = Integer.parseInt(split[1]);
            int price = Integer.parseInt(split[2]);

            if (!bom.containsKey(type)) {
                bom.put(type, new ArrayList<>());
            }
            bom.get(type).add(new int[] {type, reliability, price});
        }

        // 每一种中挑选一个，总价格不能超过预算
        dfs(0, plan, demand, bom, 0, Integer.MAX_VALUE);
        System.out.println(max == Integer.MIN_VALUE ? -1 : max);
    }

    private static void dfs(int i, int plan, int demand, Map<Integer, List<int[]>> bom, int sum, int reliability) {
        if (i >= demand) {
            // 已经挑选完，且没有超过预算，更新是否是最可靠的
            max = Math.max(max, reliability);
            return;
        }

        // 挑选第 i 种
        List<int[]> list = bom.get(i);
        for (int[] one : list) {
            // 选了这种产品后，没有超预算
            if (sum + one[2] < plan) {
                dfs(i + 1, plan, demand, bom, sum + one[2], Math.min(reliability, one[1]));
            }
        }
    }

}
