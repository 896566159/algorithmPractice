package nowcoder.outd.Y22Q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一个工厂有 m 条流水线，来并行完成 n 个独立的作业，
 * 该工厂设置了一个调度系统，在安排作业时，总是优先执行处理时间最短的作业。
 * 现给定流水线个数 m，需要完成的作业数 n, 每个作业的处理时间分别为t1,t2…tn。
 * 请你编程计算处理完所有作业的耗时为多少？
 * 当 n>m 时，首先处理时间短的 m 个作业进入流水线，其他的等待，当某个作业完成时，依次从剩余作业中取处理时间最短的进入处理。
 *
 *
 * 输入描述：
 * 	第一行为2个整数（采用空格分隔），分别表示流水线个数m和作业数n
 * 	第二行输入n个整数（采用空格分隔），表示每个作业的处理时长t1,t2…tn。
 * 	0< m,n<100
 * 	0<t1,t2…tn<100
 * 	注：保证输入都是合法的。
 * 输出描述：
 * 	输出处理完所有作业的总时长
 *
 * 示例：
 * 	输入：
 * 		3 5
 * 		8 4 3 2 10
 * 	输出：
 * 		13
 * 说明：
 * 	先安排时间为2、3、4的3个作业。
 * 	第一条流水线先完成作业，然后调度剩余时间最短的作业8。
 * 	第二条流水线完成作业，然后调度剩余时间最短的作业10。
 * 	总工耗时就是第二条流水线完成作业的时间13（3+10）。
 */
public class _流水线调度_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[] tasks = new int[n];
        split = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            tasks[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(tasks);
        int time = 0;
        int[] machines = new int[m];
        for (int i = 0; i < n; i++) {
            machines[i % m] += tasks[i];
            time = Math.max(machines[i % m], time);
        }

        System.out.println(time);
    }

}
