package nowcoder.outd.Y22Q4;

import java.util.Scanner;

public class _最大化控制资源成本_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] tasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = in.nextInt();
            tasks[i][1] = in.nextInt();
            tasks[i][2] = in.nextInt();
        }

        System.out.println(minServers(tasks));
    }

    private static int minServers(int[][] tasks) {

        return 0;
    }

}
