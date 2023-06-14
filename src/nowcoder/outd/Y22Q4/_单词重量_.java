package nowcoder.outd.Y22Q4;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 每个句子由多个单词组成，句子中的每个单词的长度都可能不一样，我们假设每个单词的长度 N 为该单词的重量，你需要做的就是给出整个句子的平均重量 V。保留两位小数
 * 样例1：
 * 	输入：
 * 		Who Love Solo
 * 	输出：
 * 		3.67
 */
public class _单词重量_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        float sum = 0;
        float count = 0;
        for (String word : split) {
            sum += word.length();
            count++;
        }

        if (count == 0) {
            System.out.println(0);
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            System.out.println(decimalFormat.format(sum / count));
        }
    }

}
