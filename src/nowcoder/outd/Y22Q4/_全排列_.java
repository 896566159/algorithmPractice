package nowcoder.outd.Y22Q4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。
 * 如：S为ABA，则不同的排列有ABA、AAB、BAA三种。
 *
 * 解答要求：
 * 时间限制：5000ms, 内存限制：100MB
 *
 * 输入描述：
 * 	输入一个长度不超过 10 的字符串 S，确保都是大写的。
 *
 * 输出描述：
 * 	输出S重新排列的所有不相同的排列数（包含自己本身）。
 *
 * 示例1：
 * 	输入：
 * 		ABA
 * 	输出：
 * 		3
 * 示例 2：
 * 	输入：
 * 		ABCDEFGHHA
 * 	输出：
 * 		907200
 */
public class _全排列_ {

    static char[] chars;
    static Set<String> set;

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        chars = scanner.nextLine().toCharArray();
        set = new HashSet<>();

        int n = chars.length;
        dfs(0, new boolean[n], "");
        System.out.println(set.size());
    }

    private static void dfs(int i, boolean[] used, String path) {
        // 所有字母已经使用完
        if (i >= chars.length) {
            set.add(path);
            return;
        }

        for (int j = 0; j < chars.length; j++) {
            if (!used[j]) {
                // 该字母还未被使用
                used[j] = true;
                dfs(i + 1, used, path + chars[j]);
                used[j] = false;
            }
        }
    }

}
