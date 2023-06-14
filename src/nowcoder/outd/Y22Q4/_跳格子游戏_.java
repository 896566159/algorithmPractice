package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 地上共有 N 个格子，你需要跳完地上所有的格子，但是格子间是有强依赖关系的，跳完前一个格子后，后续的格子才会被开启，
 * 格子间的依赖关系由多组 steps数组 给出，steps[0] 表示前一个格子, steps[1] 表示 steps[0] 可以开启的格子:
 * 比如 [0,1] 表示从跳完第 0 个格子以后第 1 个格子就开启了，
 * 比如[2,1]，[2,3]表示跳完第 2 个格子后第 1 个格子和第 3 个格子就被开启了
 * 请你计算是否能由给出的 steps数组 跳完所有的格子,如果可以输出yes，否则输出no
 * 说明：
 * 	1.你可以从一个格子跳到任意一个开启的格子
 * 	2.没有前置依赖条件的格子默认就是开启的
 * 	3.如果总数是N，则所有的格子编号为 [0,1,2,3…N-1] 连续的数组
 *
 * 输入描述:
 * 	输入一个整数 N 表示总共有多少个格子，接着输入多组二维数组 steps 表示所有格子之间的依赖关系
 * 输出描述:
 * 	如果能按照steps给定的依赖顺序跳完所有的格子输出yes，否则输出no
 *
 * 示例1：
 * 	输入：
 * 		3
 * 		0 1
 * 		0 2
 * 	输出：
 * 		yes
 * 说明：
 * 	总共有三个格子[0,1,2]，
 * 	跳完0个格子后第1个格子就开启了，跳到第0个格子后第2个格子也被开启了，按照0->1->2 或者 0->2->1的顺序都可以跳完所有的格子
 *
 * 示例2：
 * 	输入：
 * 		2
 * 		1 0
 * 		0 1
 * 	输出：
 * 		no
 * 说明：
 * 	总共有2个格子，第1个格子可以开启第0格子，但是第1个格子又需要第0个格子才能开启，相互依赖，因此无法完成
 *
 * 示例3：
 * 	输入：
 * 		6
 * 		0 1
 * 		0 2
 * 		0 3
 * 		0 4
 * 		0 5
 * 	输出：
 * 		yes
 * 说明：
 * 	总共有6个格子，第0个格子可以开启第1,2,3,4,5个格子，所以跳完第0个格子之后其他格子都被开启了，之后按任何顺序可以跳完剩余的格子
 *
 * 示例4：
 * 	输入：
 * 		5
 * 		4 3
 * 		0 4
 * 		2 1
 * 		3 2
 * 	输出：
 * 		yes
 * 说明：
 * 	跳完第0个格子可以开启格子4，跳完格子4可以开启格子3，跳完格子3可以开启格子2，跳完格子2可以开启格子1，按照0->4->3->2->1这样就跳完所有的格子
 *
 * 示例5：
 * 	输入：
 * 		4
 * 		1 2
 * 		1 0
 * 	输出：
 * 		yes
 * 说明：
 * 	总共4个格子[0,1,2,3]，格子1和格子3没有前置条件所以默认开启，格子1可以开启格子0和格子2，所以跳到格子1之后就可以开启所有的格子，因此可以跳完所有格子
 */
public class _跳格子游戏_ {

    static boolean visitedAll;
    static List<List<Integer>> edges;
    static int[] isVisited;
    private static final int NOT_VISITED = -1;
    private static final int VISITED = 0;
    private static final int VISITED_FINISHED = 1;

    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        // 初始化,每个节点的临边都初始化为空链表，且每个节点都未被访问
        isVisited = new int[n];
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
            isVisited[i] = NOT_VISITED;
        }
        // 假设所有节点都可以被访问到，且不存在环
        visitedAll = true;

        while(in.hasNext()) {
            String line = in.nextLine();
            // 输入 -1 结束
            if (line == "" || line.equals("-1")) {
                break;
            }

            String[] strs = line.split(" ");
            int cur = Integer.parseInt(strs[0]);
            int neighbour= Integer.parseInt(strs[1]);
            // 当前节点的邻接节点添加到链表中
            edges.get(cur).add(neighbour);
        }

        // 遍历 [0, n-1]每一个节点，检查是否存在环
        for (int i = 0; i < n && visitedAll; i++) {
            if (isVisited[i] == NOT_VISITED) {
                dfs(i);
            }
        }


        if (visitedAll) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

    private static void dfs(int node) {
        // 设置当前节点被访问
        isVisited[node] = VISITED;

        for (Integer neighbour : edges.get(node)) {
            if (isVisited[neighbour] == NOT_VISITED) {
                // 邻接节点没有被访问过
                dfs(neighbour);

                // 如果在访问邻接节点时，发现存在环
                if (!visitedAll) {
                    return;
                }
            } else if (isVisited[neighbour] == VISITED) {
                // 邻接节点已经被访问，存在环
                visitedAll = false;
                return;
            }
        }

        // 设置当前节点的所有邻接节点已经访问完
        isVisited[node] = VISITED_FINISHED;
    }

}
