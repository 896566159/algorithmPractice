package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给一个无向图染色，可以填红黑两种颜色，必须保证相邻两个节点不能同时为红色，输出有多少种不同的染色方案？
 * 输入描述：
 * 	第一行输入M(图中节点数) N(边数)
 * 	后续N行格式为：V1 V2表示一个V1到V2的边。
 * 	数据范围：1 <= M <= 15,0 <= N <= M * 3，不能保证所有节点都是连通的。
 * 输出描述：
 * 	输出一个数字表示染色方案的个数。
 *
 * 示例1：
 * 	输入：
 * 		4 4
 * 		1 2
 * 		2 4
 * 		3 4
 * 		1 3
 * 	输出：
 * 		7
 * 说明：4个节点，4条边，
 * 	1号节点和2号节点相连，
 * 	2号节点和4号节点相连，
 * 	3号节点和4号节点相连，
 * 	1号节点和3号节点相连，
 * 	若想必须保证相邻两个节点不能同时为红色，总共7种方案。
 */
public class _无向图染色_ {

    public static class Side {
        int from;
        int to;

        public Side(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }


    static int[] pointsCorclor;
    static ArrayList<Side> sideArrayList = new ArrayList<>();
    static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] heads = scanner.nextLine().split(" ");
        int pointsNum = Integer.parseInt(heads[0]);
        int sidesNum = Integer.parseInt(heads[0]);

        for (int i = 0; i < sidesNum; i++) {
            String[] line = scanner.nextLine().split(" ");
            Side side = new Side(Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]) - 1);
            sideArrayList.add(side);
        }

        pointsCorclor = new int[pointsNum];
        colored(0);
        System.out.println(result);
    }

    // 0无色 1黑色 2红色
    private static void colored(int current) {
        // 所有点都成功的染色，说明上色方案可行
        if (current == pointsCorclor.length) {
            result += 1;
        }

        if (current < pointsCorclor.length) {
            // 未染色
            if (pointsCorclor[current] == 0) {
                // 染黑
                pointsCorclor[current] = 1;
                colored(current + 1);

                // 染红色——临边不能染成红色
                pointsCorclor[current] = 2;
                for (Side side : sideArrayList) {
                    //临边黑
                    if (side.from == current) {
                        pointsCorclor[side.to] = 1;
                    }
                    if (side.to == current) {
                        pointsCorclor[side.from] = 1;
                    }
                }
                colored(current + 1);
            } else {
                // 如果已经染色，则对一下个点进行染色
                colored(current + 1);
            }

            // 搜索完之后回退
            pointsCorclor[current] = 0;
        }
    }

}
