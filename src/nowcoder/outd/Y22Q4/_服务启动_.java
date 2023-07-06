package nowcoder.outd.Y22Q4;


import java.util.*;

/**
 * 有若干个连续编号的服务（编号从0开始），服务间有依赖关系，启动一个指定服务，请判断该服务是否可以成功启动，并输出依赖的前置服务编号（依赖关系是可以传递的，比如服务2 依赖服务1，服务1依赖于服务0，那么服务2 依赖于服务1 和服务0）。
 *
 * 输入描述：
 * 	第一行输入为N，N为服务的总个数（1 <= N <= 5000）
 * 	第二行输入为M，M为指定启动服务的编号（0 <= M < 5000）
 * 	接下来的N行，是从编号0服务~编号N-1服务的服务依赖表，每一行第一个数字是该服务依赖的服务个数T（0 <= T < 5000）,后面T个数字分别是对应的依赖服务编号
 * 输出描述：
 * 	为了避免不同算法的服务加载顺序不同，请从服务编号从小到大以此输出所有前置服务的编号，不包括指定启动的服务编号自身。
 * 	如果没有依赖的前置服务则输出null。
 * 	如果服务无法启动（出现循环依赖，则服务无法启动，样例2为最简单的循环依赖）或其它异常，输出-1.
 *
 * 样例1：
 * 	输入：
 * 		4
 * 		2
 * 		0
 * 		1,0
 * 		1,1
 * 		2,0,1
 * 	输出：
 * 		0,1
 * 解释：
 * 	第一行，4，一共四个服务，编号0~3
 * 	第二行，2，指定启动编号为2的服务
 * 	第三行开始为服务依赖关系表
 * 	第三行，0，表示服务0，没有依赖的前置任务，依赖个数为0
 * 	第四行，1,0，表示服务1，依赖1个前置任务，编号为0
 * 	第三行，1,1，表示服务2，依赖1个前置任务，编号为1
 * 	第三行，2,1,0 表示服务3，依赖2个前置任务，编号为0和1
 * 	分析，服务启动顺序为0，1，2，可成功启动服务2，输出0，1
 *
 * 样例2：
 * 	输入：
 * 		2
 * 		1
 * 		1,1
 * 		1,0
 * 	输出：
 * 		-1
 */
public class _服务启动_ {

    static int m;
    static Set<Integer> dependencies = new TreeSet<>();
    static boolean hasLoop = false;

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        m = Integer.parseInt(scanner.nextLine());
        // 依赖关系
        List<Integer>[] grid = new List[n];

        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            int dependencys = Integer.parseInt(split[0]);
            grid[i] = new ArrayList<>();
            // 直接依赖的前置任务
            for (int j = 1; j <= dependencys; j++) {
                grid[i].add(Integer.parseInt(split[j]));
            }
        }

        // 查找 m 的所有前置依赖，同时检查无循环依赖
        dfs(grid, m, new boolean[n]);

        if (hasLoop) {
            System.out.println(-1);
        } else {
            if (dependencies.isEmpty()) {
                System.out.println("null");
            } else {
                Integer[] array = dependencies.toArray(new Integer[0]);
                System.out.print(array[0]);
                for (int i = 1; i < array.length; i++) {
                    System.out.print("," + array[i]);
                }
            }
        }
    }

    private static void dfs(List<Integer>[] grid, int cur, boolean[] booleans) {
        // 已经被访问过了
        if (booleans[cur]) {
            hasLoop = true;
            return;
        }

        if (!hasLoop) {
            if(m != cur) {
                dependencies.add(cur);
            }
            booleans[cur] = true;
            for (Integer next : grid[cur]) {
                dfs(grid, next, booleans);
            }
            booleans[cur] = false;
        }
    }

}
