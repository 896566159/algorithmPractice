package nowcoder.outd.Y22Q3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * RSA加密算法在网络安全世界中无处不在，它利用了极大整数因数分解的困难度，数据越大，安全系数越高。
 * 给定一个32位正整数，请对其进行因数分解，找出是哪两个素数的乘积。
 *
 * 输入描述：
 * 	一个正整数num
 * 	0 < num <= 2147483647
 * 输出描述：
 * 	如果成功找到，以单个空格分割，从小到大输出两个素数，分解失败，请输出-1 -1。
 *
 * 示例1：
 * 	输入：
 * 		15
 * 	输出：
 * 		3 5
 * 说明：
 * 	因数分解后，找到两个素数3和5，使得3*5=15，按从小到大排列后，输出3 5。
 *
 * 示例2：
 * 	输入：
 * 		27
 * 	输出：
 * 		-1 -1
 * 说明：
 * 	通过因数分解，找不到任何素数，使得他们的乘积为27，输出-1 -1。
 *
 * 示例3：
 * 	输入：
 * 		1682173
 * 	输出：
 * 		1291 1303
 * 说明：
 * 	    1682173 = 1291 * 1303
 */
public class _素数之积_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 方法二
        System.out.println("方法二：");
        mothed2(n);
        System.out.println("\n方法1：");


        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                if (isPrime(i) && isPrime(n / i)) {
                    System.out.println(i + " " + (n / i));
                    return;
                }
            }
        }

        System.out.println("-1 -1");

    }

    private static void mothed2(int n) {
        // 集合存储因子
        Set<Integer> factors = new TreeSet<>();
        int tmp = n;
        // 从最小的素数开始
        int f = 2;

        while (tmp != 1) {
            // 如果tmp不能被f整除，尝试下一个更大的f
            if (tmp % f != 0) {
                f++;
            } else {
                // 是 n 的一个因子
                factors.add(f);
                // 除以因数f，更新tmp的值，去除重复的因数
                tmp /= f;
            }
        }

        // 可以是质数的话，那么就只会有两个因子
        if (factors.size() > 2) {
            System.out.println("-1 -1");
            return;
        }

        // 只有两个因子，一定是质数
        for (Integer i : factors) {
            for (Integer j : factors) {
                if (i * j == n) {
                    int min = Math.min(i, j);
                    int max = Math.max(i, j);
                    System.out.println(min + " " +max);
                    return;
                }
            }
        }
    }

    // 判断是否是素数
    private static boolean isPrime(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
