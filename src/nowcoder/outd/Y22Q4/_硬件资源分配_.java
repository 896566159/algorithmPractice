package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 有M台服务器，每台服务器有以下属性：编号、CPU核数（1~100）、内存、CPU架构（0~8）、是否支持NP加速的标识（0,1）。
 * 然后有一个资源分配要求，要求分配 N台满足要求的服务器。
 * 具体如下：CPU核数 >= cpuCount、内存 >= memSize、CPU架构 = cpuArch、是否支持NP加速 = supportNP。其中，cpuCount、memSize、cpuArch、supportNP为这个要求输入的分配参数。
 * 分配时会指定优先级策略，策略如下：
 * 	策略1：CPU优先，优先选择CPU核数满足分配要求并且最接近分配要求的cpuCount。如果CPU核数相同，在按内存满足要求并选择最接近memSize的服务器分配。
 * 	策略2：内存优先，优先选择内存满足分配要求并且最接近分配要求的memSize。如果内存相同，在按cpu核数满足要求并选择最接近cpuCount的服务器分配
 * 	如果两台服务器属性都相同，则按服务器编号从小到大选择（编号不会重复）
 *
 * 输入描述：
 * 	第一行：服务器数量M
 * 	接下来M行为M台服务器属性的数组
 * 	下一行为分配要求：最大分配数量N，分配策略strategy，cupCount，memSize，cpuArch，supportNP
 * 	其中：
 * 	1<=M<=1000
 * 	1<=N<=1000
 * 	strategy：1表示策略1,2表示策略2
 * 	1 <= cpuCount <= 100
 * 	10 <= memSize <= 1000
 * 	0 <= cpuArch <= 8，另外，cpuArch使用9表示所有服务器架构都满足分配要求
 * 	0 <= supportNP <= 1，另外，为2时表示无论是否支持NP加速都满足分配要求
 * 输出描述：
 * 	先输出实际分配数量，后按照分配的服务器编号从小到大依次输出，以空格分开
 *
 * 样例1：
 * 	输入：
 * 		4
 * 		0,2,200,0,1
 * 		1,3,400,0,1
 * 		2,3,400,1,0
 * 		3,3,300,0,1
 * 		3 1 3 200 0 1
 * 	输出：
 * 		2 1 3
 * 说明：只有1和3满足要求，要求分配2台服务器，所以结果为2 1 3
 *
 * 样例2：
 * 	输入：
 * 		6
 * 		0,2,200,0,1
 * 		1,4,330,2,1
 * 		2,3,400,3,1
 * 		3,3,310,1,1
 * 		4,3,320,8,1
 * 		5,3,330,0,1
 * 		3 2 3 300 9 2
 * 	输出：
 * 		3 3 4 5
 * 说明：
 * 	编号1~5都满足分配要求，按策略2分配即内存优先，内存>=300并且最接近300的服务器编号是3 4 1 5 2。
 * 	其中1和5内存相同，然后会比较CPU，即CPU>=3且最接近的，所以5优先于1.因此最后分配的三台服务器是3 4 5。
 * 	输出时先输出数量3，再按编号排序输出3 4 5
 */
public class _硬件资源分配_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] computers = new int[n][5];

        // 每台具体的计算机
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            computers[i][0] = Integer.parseInt(split[0]);
            computers[i][1] = Integer.parseInt(split[1]);
            computers[i][2] = Integer.parseInt(split[2]);
            computers[i][3] = Integer.parseInt(split[3]);
            computers[i][4] = Integer.parseInt(split[4]);
        }

        // 最大分配数量N，分配策略strategy，cupCount，memSize，cpuArch，supportNP
        String[] split = scanner.nextLine().split(" ");
        int planCount = Integer.parseInt(split[0]);
        int strategy = Integer.parseInt(split[1]);
        int cupCount = Integer.parseInt(split[2]);
        int memSize = Integer.parseInt(split[3]);
        int cpuArch = Integer.parseInt(split[4]);
        int supportNP = Integer.parseInt(split[5]);

        List<int[]> res = choseOne(computers, cupCount, memSize, cpuArch, supportNP);
        if (res.size() < planCount) {
            // 如果满足硬件资源条件的计算机数量不足，则直接按照编号从小到大输出
            int size = res.size();
            System.out.print(size);
            for (int i = 0; i < size; i++) {
                System.out.print(" " + res.get(i)[0]);
            }
            return;
        }

        // 如果满足硬件资源条件的计算机数量很多，则需要按照策略进行排序后筛选出 planCount 台
        if (strategy == 1) {
            // CPU优先，优先选择CPU核数满足分配要求并且最接近分配要求的cpuCount。如果CPU核数相同，在按内存满足要求并选择最接近memSize的服务器分配。
            Collections.sort(res, (a, b)->{
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                } else if (a[2] != b[2]) {
                    return a[2] - b[2];
                } else {
                    return a[0] - b[0];
                }
            });
        } else {
            // 内存优先，优先选择内存满足分配要求并且最接近分配要求的memSize。如果内存相同，在按cpu核数满足要求并选择最接近cpuCount的服务器分配
            Collections.sort(res, (a, b)->{
                if (a[2] != b[2]) {
                    return a[2] - b[2];
                } else if (a[1] != b[1]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            });
        }

        // 输出
        System.out.print(planCount);
        for (int i = 0; i < planCount ; i++) {
            System.out.print(" " + res.get(i)[0]);
        }
    }

    private static List<int[]> choseOne(int[][] computers, int cupCount, int memSize, int cpuArch, int supportNP) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < computers.length; i++) {
            if (computers[i][1] >= cupCount && computers[i][2] >= memSize) {
                boolean flag = true;
                if (cpuArch != 9 && computers[i][3] < cpuArch) {
                    flag = false;
                }

                if (supportNP != 2 && computers[i][4] != supportNP) {
                    flag = false;
                }

                if (flag) {
                    res.add(computers[i]);
                }
            }
        }

        return res;
    }

}
