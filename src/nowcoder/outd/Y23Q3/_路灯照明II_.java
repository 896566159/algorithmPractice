package nowcoder.outd.Y23Q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在一条笔直的公路上安装了N个路灯，从位置0开始安装，路灯之间间距固定为100米。
 * 每个路灯都有自己的照明半径，请计算第一个路灯和最后一个路灯之间，无法照明的区间的长度和。
 * 输入描述：
 * 	第一行为一个数N，表示路灯个数，1<=N<=100000
 * 	第二行为N个空格分隔的数，表示路灯的照明半径，1<=照明半径<=100000*100
 * 输出描述：
 * 	第一个路灯和最后一个路灯之间，无法照明的区间的长度和.
 *
 * 示例1：
 * 	输入：
 * 		2
 * 		50 50
 * 	输出：
 * 		0
 * 说明：
 * 	路灯1覆盖0-50，路灯2覆盖50-100，路灯1和路灯2之间(0米-100米)无未覆盖的区间。
 *
 *
 * 示例2：
 * 	输入：
 * 		4
 * 		50 70 20 70
 * 	输出：
 * 		20
 * 说明：
 * 	路灯1 覆盖0-50
 * 	路灯2 覆盖30-170
 * 	路灯3 覆盖180-220
 * 	路灯4 覆盖230-370
 * 	[170.180],[220,230]，两个未覆盖的区间，总里程为20
 */
public class _路灯照明II_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (array[i] + array[i - 1] < 100) {
                count += 100 - array[i] - array[i - 1];
            }
        }

        System.out.println(count);
    }

}
