package nowcoder.outd.hard;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 有一个文件, 包含以一定规则写作的文本, 请统计文件中包含的文本数量
 * 规则如下：
 * 	1.文本以";"分隔，最后一条可以没有";"，但空文本不能算语句，比如"COMMAND A; ;"只能算一条语句.
 * 		注意, 无字符/空白字符/制表符都算作"空"文本
 * 	2. 文本可以跨行, 比如下面, 是一条文本, 而不是三条
 * 		COMMAND A
 * 			AND
 * 		COMMAND B;
 * 	3. 文本支持字符串, 字符串为成对的单引号(')或者成对的双引号("), 字符串可能出现用转义字符(\)处理的单双引号
 * 		(比如"your input is: \"")和转义字符本身, 比如：
 * 		COMMAND A "Say \"hello\"";
 * 	4. 支持注释, 可以出现在字符串之外的任意位置, 注释以"--"开头, 到换行结束, 比如：
 * 		COMMAND A; -- this is comment
 * 		COMMAND -- comment
 * 				  A AND COMMAND B;
 * 		注意, 字符串内的"--", 不是注释
 * 输入描述:
 * 	文本文件
 * 输出描述:
 * 	包含的文本数量
 *
 * 示例1：
 * 	输入：
 * 		COMMAND TABLE IF EXISTS "UNITED STATE";
 * 		COMMAND A GREAT (
 * 			ID ADSAB,
 * 			download_length INTE-GER,  -- test
 * 			file_name TEXT,
 * 			guid TEXT,
 * 			mime_type TEXT,
 * 			notifica-tionid INTEGER,
 * 			original_file_name TEXT,
 * 			pause_reason_type INTEGER,
 * 			resumable_flag INTEGER,
 * 			start_time INTEGER,
 * 			state INTEGER,
 * 			folder TEXT,
 * 			path TEXT,
 * 			total_length INTE-GER,
 * 			url TEXT
 * 		);
 * 	输出
 * 		2
 */
public class _统计文本数量_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ans = 0;
        // 记录：除了空白以外，字母、标点符号以及括转义字符
        Queue<Character> str = new ArrayDeque<>();

        while (scanner.hasNextLine()) {
            char[] chars = scanner.nextLine().toCharArray();
            int n = chars.length;

            // 输入是空白了
            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                char c = chars[i];
                if (c == ';') {
                    //
                    if (!str.isEmpty() && str.peek() != '\\') {
                        ans++;
                        // 清空字符串
                        str.clear();
                    }
                } else if (c != ' ') {
                    // 注释以"--"开头, 到换行结束，直接结束这一行字母的遍历
                    if (i > 0 && c == '-' && chars[i - 1] == '-' && chars[i + 1] != '\'' && chars[i+1] != '"') {
                        str.poll();
                        break;
                    }

                    // 除了空白以外，字母、标点符号以及括转义字符， 都要入队列
                    str.offer(c);
                }
            }
        }

        // 最后一个文本可能没有分号
        if (!str.isEmpty()) {
            ans++;
        }

        System.out.println(ans);
    }

}
