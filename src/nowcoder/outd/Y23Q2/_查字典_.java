package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入一个单词前缀和一个字典，输出包含该前缀的单词
 *
 * 输入描述:
 * 	单词前缀+字典长度+字典字典是一个有序单词数组
 * 	输入输出都是小写
 * 输出描述:
 * 	所有包含该前缀的单词，多个单词换行输出若没有则返回-1
 *
 * 示例1:
 * 	输入:
 * 		b 3 a b c
 * 	输出:
 * 		b
 *
 * 示例2:
 * 	输入:
 * 		abc 4 a ab abc abcd
 * 	输出:
 * 		abc
 * 		abcd
 *
 * 示例3:
 * 	输入:
 * 		a 3 b c d
 * 	输出:
 * 		-1
 */
public class _查字典_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        String prefix = line[0];
        int n = Integer.parseInt(line[1]);
        boolean flag = true;

        for (int i = 2; i < 2 + n; i++) {
            if (line[i].startsWith(prefix)) {
                System.out.println(line[i]);
                flag = false;
            }
        }

        if (flag) {
            System.out.println(-1);
        }
    }

    
}
