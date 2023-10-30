package nowcoder.outd.Y22Q4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 考古问题，假设以前的石碑被打碎成了很多块，每块上面都有一个或若干个字符，请你写个程序来把之前石碑上文字可能的组合全部写出来，按升序进行排列。
 * 输入描述:
 * 	第一行输入n，n表示石碑碎片的个数。
 * 	第二行依次输入石碑碎片上的文字内容s，共有n组。
 * 输出描述:
 * 	输出石碑文字的组合(按照升序排列)，行末无多余空格。
 *
 * 示例1
 * 	输入：
 * 		3
 * 		a b c
 * 	输出：
 * 		abc
 * 		acb
 * 		bac
 * 		bca
 * 		cab
 * 		cba
 * 示例2
 * 	输入：
 * 		3
 * 		a b a
 * 	输出：
 * 		aab
 * 		aba
 * 		baa
 */
public class _考古学家_ {

    static Set<String> res;
    static String[] words;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        words = scanner.nextLine().split(" ");
        res = new TreeSet<>();

        boolean[] used = new boolean[words.length];
        dfs(used, 0, "");

        for (String sb : res) {
            System.out.println(sb.toString());
        }
    }

    /**
     *
     * @param used
     * @param index
     * @param path
     */
    private static void dfs(boolean[] used, int index, String path) {
        // 递归边界
        if (index == words.length) {
            res.add(path);
            return;
        }

        // 从 [index, words.length] 挑选一个字符串
        for (int i = 0; i < words.length; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(used, index + 1, path + words[i]);
                // 撤销本次的选择
                used[i] = false;
            }
        }
    }

}
