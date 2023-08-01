package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有若干个文件，使用刻录光盘的方式进行备份，假设每张光盘的容量是500MB.求使用光盘最少的文件分布方式，所有文件的大小都是整数的MB，且不超过500MB；文件不能分割、分卷打包
 * 输入描述:
 * 	一组文件大小的数据
 * 输出描述:
 * 	使用光盘的数量
 * 补充说明:
 * 	不用考虑输入数据不合法的情况:假设最多100个输入文件。
 *
 * 示例1:
 * 	输入:
 * 		100,500,300,200,400
 * 	输出:
 * 		3
 * 说明:
 * 	    (100,400),(200,300),(500) 3张光盘即可，输入和输出内容都不含空格。
 * 示例2:
 * 	输入:
 * 		100,100,200,300
 * 	输出:
 * 		2
 */
public class _数据最节约的备份方法_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = split.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(nums);
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (f(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static boolean f(int[] files, int mid) {
        int count = 1;
        int pre = files[0];

        for (int i = 1; i < files.length; i++) {
            if (pre + files[i] >= 500) {
                pre = files[i];
                count++;
            } else {
                pre += files[i];
            }
        }

        return count <= mid;
    }

}
