package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * 给定一个数组，里面有 6 个整数，求这个数组能够表示的最大 24 进制的时间是多少，输出这个时间，无法表示输出 invalid。
 *
 * 输入描述：
 * 	输入为一个整数数组，数组内有六个整数。
 * 	输入整数数组长度为 6，不需要考虑其它长度，元素值为 0 或者 正整数，6 个数字每个数字只能使用一次。
 * 输出描述：
 * 	输出为一个 24 进制格式的时间，或者字符串"invalid"
 *
 * 示例1:
 * 	输入:
 * 		[0,2,3,0,5,6]
 * 	输出:
 * 		23:56:00
 * 说明: 无
 */
public class _最大时间_ {

    static String max = new String();
    static int[] arr;
    static boolean[] used;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().replace("[", "").replace("]", "").split(",");
        arr = new int[6];
        used = new boolean[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        // HH:MM:SS
        // 第一个H：[0,1]
        // 第二个H：[0~9]/[0~3]
        // 第一个M：[0~5]
        // 第二个M：[0~9]
        // 第一个S：[0~5]
        // 第二个S：[0~9]
        dfs(0, "");
        if (max.equals("")) {
            System.out.println("invalid");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (i > 0 && i % 2 == 0) {
                sb.append(":");
            }
            sb.append(max.charAt(i));
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int i, String path) {
        if (i > 0) {
            char pre = path.charAt(i - 1);
            if (i == 2 && (pre > '3' && path.charAt(i - 2) == '2')) {
                return;
            }
            if ((i == 1 && pre > '2') || (i == 3 && pre > '5') || (i == 5 && pre > '5')) {
                return;
            }
        }

        if (i >= 6) {
            if (max.compareTo(path) < 0) {
                max = path;
            }
            return;
        }

        for (int j = 0; j < 6; j++) {
            if (!used[j]) {
                used[j] = true;
                dfs(i + 1, path + arr[j]);
                used[j] = false;
            }
        }
    }

}
