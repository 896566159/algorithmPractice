package nowcoder.outd.Y23Q3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 周末小明准备去爬山锻炼，
 * 0代表平地，山的高度使用1到9来表示，小明每次爬山或下山高度只能相差k及k以内，
 * 每次只能上下左右一个方向上移动一格，
 * 小明从左上角(0,0)位置出发
 * 输入描述：
 * 	第一行输入m n k(空格分隔)
 * 	代表 m*n 的二维山地图，k为小明每次爬山或下山高度差的最大值，
 * 	然后接下来输入山地图，一共 m行n列，均以空格分隔。取值范围：
 * 	0 < m ≤ 500
 * 	0< n ≤ 500
 * 	0 < k < 5
 * 输出描述：
 * 	请问小明能爬到的最高峰多高，到该最高峰的最短步数，输出以空格分隔。
 * 	同高度的山峰输出较短步数。
 * 	如果没有可以爬的山峰，则高度和步数都返回0。
 * 备注：
 * 	所有用例输入均为正确格式，且在取值范围内，考生不需要考虑不合法的输入格式。
 *
 * 示例1：
 * 	输入：
 * 		5 4 1
 * 		0 1 2 0
 * 		1 0 0 0
 * 		1 0 1 2
 * 		1 3 1 0
 * 		0 0 0 9
 * 	输出：
 * 		2 2
 * 说明：
 * 	根据山地图可知，能爬到的最高峰在(0,2)位置，高度为2,最短路径为(0,0)-(0,1)-(0.2),最短步数为2。
 *
 * 示例1：
 * 	输入：
 * 	5 4 3
 * 	0 0 0 0
 * 	0 0 0 0
 * 	0 9 0 0
 * 	0 0 0 0
 * 	0 0 0 9
 * 	输出：
 * 		0 0
 * 说明：
 * 	根据山地图可知，每次爬山距离3,无法爬到山峰上，步数为0。
 */
public class _周末爬山_ {

    static int k;
    static int[][] mountains;
    static boolean[][] visited;
    // key 表示到达山峰的高度，value 用来记录到达这个高度的最短路径。
    static HashMap<Integer, Integer> minSteps = new HashMap<>();
    // 位移方向
    static int[][] direction = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);
        mountains = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            split = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                mountains[i][j] = Integer.parseInt(split[j]);
            }
        }

        int max = mountains[0][0];
        int steps = 0;
        // 初始化，达到开始位置高度只需要 0 步
        minSteps.put(mountains[0][0], 0);
        dfs(0, 0, 0);
        for (Map.Entry<Integer, Integer> entry : minSteps.entrySet()) {
            if (entry.getKey() > max) {
                max = entry.getKey();
                steps = entry.getValue();
            }
        }
        System.out.println(max + " " + steps);
    }

    private static void dfs(int i, int j, int steps) {
        // 当前山峰的高度
        int curHeight = mountains[i][j];
        // 尝试往往 上下左右 走
        for (int[] direction : direction) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            // 边界判断，是否被访问过了(如果当前位置是(3,4)，且下一步只能到(4,4)，进入下一步(4,4)后，visited[3][4]就不能被进入了。
            // 但是如果有一条路径先访问的(4,4)，则还是可以再次进入(3,4)——从而保证到达(3,4)的最少步数是正确的)
            if (newI < 0 || newI >= mountains.length || newJ < 0 || newJ >= mountains[0].length || visited[i][j]) {
                continue;
            }

            // 下一步达到的山峰高度
            int nextHeight = mountains[newI][newJ];
            if (Math.abs(curHeight - nextHeight) <= k) {
                steps++;
                if (!minSteps.containsKey(nextHeight) || minSteps.get(nextHeight) > steps) {
                    minSteps.put(nextHeight, steps);
                }

                // 标记当前已经被访问
                visited[i][j] = true;
                // 访问下一山峰
                dfs(newI, newJ, steps);
                // 回退——保证到达某个点的路径全部被覆盖
                visited[i][j] = false;
                steps--;
            }
        }
    }

}
