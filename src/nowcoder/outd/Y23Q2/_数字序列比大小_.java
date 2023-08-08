package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A，B两个人玩一个数字比大小Q的游戏，在游戏前，两个人会拿到相同长度的两个数字序列，两个数字序列不相同的且其中的数字是随机的。
 * A，B各自从数字序列中挑选出一个数字进行大小比较，赢的人得1分，输的人扣1分，相等则各自的分数不变。用过的数字需要丢弃。
 * 求A可能赢B的最大分数
 *
 * 输入描述：
 * 	输入数据的第1个数字表示数字序列的长度N，后面紧跟着两个长度为N的数字序列，
 * 输出描述：
 * 	A可能赢B的最大分数
 * 备注：
 * 	1.这里要求计算A可能赢B的最大分数，不妨假设，A知道B的数字序列，且总是B先挑选数字并明示
 * 	2.可以采用贪心策略，能赢的一定要赢，要输的尽量减少损失。
 *
 * 示例1：
 * 	输入：
 * 		3
 * 		4 8 10
 * 		3 6 4
 * 	输出：
 * 		3
 * 说明：
 * 	输入数据第1个数字表示数字序列长度为3，后面紧跟着两个长度为3的数字序列。
 * 	序列A: 4 8 10
 * 	序列B: 3 6 4
 * 	A可以赢的最大分数是3。获得该分数的比大小过程可以是:
 * 	1) A: 4 B: 3
 * 	2) A: 8 B: 6
 * 	3) A: 10 B: 4
 */
public class _数字序列比大小_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(a);
        Arrays.sort(b);

        int count = 0;
        int indexA = n - 1;
        int indexB = n - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] > b[indexB]) {
                count++;
                indexA--;
            }
            indexB--;
        }

        System.out.println(count);
    }

}
