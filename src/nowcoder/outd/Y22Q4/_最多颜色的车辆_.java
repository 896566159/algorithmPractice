package nowcoder.outd.Y22Q4;

import java.util.Scanner;

public class _最多颜色的车辆_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().replace(" ", "").toCharArray();
        int k = scanner.nextInt();
        int left = 0;
        int right = 0;
        int[] count = new int[3];
        int max = 0;
        int res = 0;

        // 初始化窗口，窗口中存放 k - 1 个元素
        while (right < k - 1) {
            if (chars[right] == '0') {
                count[0]++;
            } else if (chars[right] == '1') {
                count[1]++;
            } else {
                count[2]++;
            }
            right++;
        }

        int length = chars.length;
        // 开始往右滑动窗口
        while (right < length) {
            if (chars[right] == '0') {
                count[0]++;
                max = Math.max(max, count[0]);
            } else if (chars[right] == '1') {
                count[1]++;
                max = Math.max(max, count[1]);
            } else {
                count[2]++;
                max = Math.max(max, count[2]);
            }

            right++;
            if (chars[left] == '0') {
                count[0]--;
            } else if (chars[left] == '1') {
                count[1]--;
            } else {
                count[2]--;
            }
            left++;

        }

        System.out.println(max);
    }

}
