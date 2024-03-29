package nowcoder.outd.Y23Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一座保密大楼，你从0楼到达指定楼层m，必须这样的规则乘坐电梯:
 * 给定一个数字序列，每次根据序列中的数字n上升n层或者下降n层，前后两次操作的方向必须相反，规定首次的方向向上，自行组织序列的顺序按规定操作到达指定楼层。
 * 求解到达楼层的序列组合，如果不能到达楼层，给出小于该楼层的最近序列组合。
 *
 * 说明:
 * 	操作电梯时不限定楼层范围
 * 	必须对序列中的每个项进行操作，不能只使用一部分。
 * 输入描述:
 * 	第一行: 期望的楼层，取值范围[1,50]; 序列总个数，取值范围[1,23]
 * 	第二行: 序列，每个值取值范围[1,50]
 * 输出描述:
 * 	能够达到楼层或者小于该楼层最近的序列
 * 补充说明:
 * 	操作电梯时不限定楼层范围
 * 	必须对序列中的每个项进行操作，不能只使用一部分
 *
 * 示例1:
 * 	输入:
 * 		5 3
 * 		1 2 6
 * 	输出:
 * 		6 2 1
 * 说明:
 * 	1 2 6
 * 	6 2 1均为可行解，按先处理大值的原则结果为6 2 1
 */
public class _乘坐保密电梯_ {

    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int target = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        Integer[] nums = new Integer[n];
        split = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        // 输出结果要求先处理大值，所以排序
        Arrays.sort(nums, (a, b)->(Integer) b - (Integer) a);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, 1, 0, 0, target, path, new boolean[n]);

        if (!res.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(res.get(0));
            for (int i = 1; i < res.size(); i++) {
                sb.append(",").append(res.get(i));
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }

    private static void dfs(Integer[] nums, int diction, int level, int i, int target, ArrayList<Integer> path, boolean[] used) {
        if (i == nums.length) {
            if (target - level >= 0 && target - level < min) {
                min = target - level;
                res = new ArrayList<Integer>(path);
            }
            return;
        }


        for (int j = 0; j < nums.length; j++) {
            if (!used[j]) {
                used[j] = true;
                path.add(nums[j]);
                if (diction == 1) {
                    dfs(nums, 0, level + nums[j], i + 1, target, path, used);
                } else {
                    dfs(nums, 1, level - nums[j], i + 1, target, path, used);
                }
                path.remove(path.size() - 1);
                used[j] = false;
            }
        }

    }

}
