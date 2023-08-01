package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个数组X和正整数K，请找出使表达式X[i] - x[i +1] ... - X[i + K + 1]，结果最接近于数组中位数的下标i，如果有多个i满足条件，请返回最大的i。
 * 其中，数组中位数:长度为N的数组，按照元素的值大小升序排列后，下标为N/2元素的值
 * 补充说明:
 * 	1.数组X的元素均为正整数;
 * 	2.X的长度n取值范围: 2<= n <= 1000;
 * 	3.K大于0且小于数组的大小;
 * 	4.i的取值范围: 0 <=i < 1000;
 * 	5.题目的排序数组X[N]的中位数是X[N/2].
 *
 * 示例1:
 * 	输入:
 * 		[50,50,2,3],2
 * 	输出:
 * 		1
 * 说明:
 * 1、中位数为50: [50,50,2,3]升序排序后变成[2,3,50,50]，中位数为下标4/2=2的元素50;
 * 2、计算结果为1: X[50,50,2,3]根据题目计算X[i] - ...- X[i + K - 1]得出三个数
 * 	0 (X[0]-X[1]= 50 -50) 、
 * 	48 (X[1]-X[2] = 50 -2)
 * 	-1 (X[2]-X[3]= 2-3) ，
 * 	其中48最接近50，因此返回下标1
 */
public class _计算最接近的数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int rightBlaket = line.indexOf(']');
        String[] split = line.substring(1, rightBlaket).split(",");
        int k = Integer.parseInt(line.substring(rightBlaket + 2, line.length()));
        int n = split.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(nums);
        int middle = nums[n / 2];
        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i <= n - k; i++) {

            int count = nums[i];
            for(int j = i+1; j < i + k; j++){
                count -= nums[j];
            }

            //求计算结果与中位数的距离
            int abs = Math.abs(count - middle);
            min = Math.min( min, abs);
            if(min == abs){
                res = i;
            }

        }

        System.out.println(res);
    }

}
