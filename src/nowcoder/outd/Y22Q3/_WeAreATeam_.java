package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * We Are A Team
 * 总共有 n 个人在机房，每个人有一个标号(1<= 标号 <=n)，他们分成了多个团队，
 * 需要你根据收到的 m 条消息判定指定的两个人是否在一个团队中，具体的：
 * 	1.消息构成为a b c，整数a、b分别代表两个人的标号，整数c代表指令
 * 	2.c==0 代表 a和b 在一个团队内
 * 	3.c==1 代表需要判定 a和b 的关系，如果a和b是一个团队，输出一行’we are a team’,如果不是，输出一行'we are not a team'
 * 	4.c为其他值，或当前行 a或b 超出1~n的范围，输出da pian zi
 *
 * 输入描述：
 * 	1.第一行包含两个整数n，m(1<=n,m<100000),分别表示有 n个人和 m条消息
 * 	2.随后的 m 行，每行一条消息，消息格式为:a b c(1<=a,b<=n,0<=c<=1)
 * 输出描述：
 * 	1.c==1,根据 a和b 是否在一个团队中输出一行字符串，在一个团队中输出we are a team不在一个团队中输出'we are not a team'
 * 	2.c为其他值，或当前行a或b的标号 小于1或者大于n时，输出字符串da pian zi
 * 	3.如果第一行 n和m 的值超出约定的范围时，输出字符串”Null“。
 *
 * 示例1：
 * 	输入：
 * 		5 7
 * 		1 2 0
 * 		4 5 0
 * 		2 3 0
 * 		1 2 1
 * 		2 3 1
 * 		4 5 1
 * 		1 5 1
 * 	输出：
 * 		We are a team
 * 		We are a team
 * 		We are a team
 * 		We are not a team
 *
 * 示例2：
 * 	输入：
 * 		5 6
 * 		1 2 0
 * 		1 2 1
 * 		1 5 0
 * 		2 3 1
 * 		2 5 1
 * 		1 3 2
 * 	输出：
 * 		we are a team
 * 		we are not a team
 * 		we are a team
 * 		da pian zi
 */
public class _WeAreATeam_ {

    static int[] parent;
    static int[] size;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        if ((n < 1 || n >= 100000) || (m < 1 || m >= 100000)) {
            System.out.println("Null");
        }

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            String[] item = scanner.nextLine().split(" ");
            int a = Integer.parseInt(item[0]);
            int b = Integer.parseInt(item[1]);

            if (a < 1 || a > n || b < 0 || b > n || !(item[2].equals("0") || item[2].equals("1"))) {
                System.out.println("da pian zi");
                continue;
            }

            int c = Integer.parseInt(item[2]);
            if (c == 0) {
                union(a, b);
            } else if (c == 1){
                int rootA = find(a);
                int rootB = find(b);
                if (rootA == rootB) {
                    System.out.println("we are a team");
                } else {
                    System.out.println("we are not a team");
                }
            }
        }

    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (size[rootA] < size[rootB]) {
            parent[rootA] = parent[rootB];
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = parent[rootA];
            size[rootA] += size[rootB];
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return find(parent[x]);
    }

}
