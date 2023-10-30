package nowcoder.outd.Y23Q2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 告警抑制，是指高优先级告警抑制低优先级告警的规则。高优先级告警产生后，低优先级告警不再产生。
 * 请根据原始告警列表和告警抑制关系，给出实际产生的告警列表。不会出现循环抑制的情况。
 * 告警不会传递，比如A->B.B->C，这种情况下A不会直接抑制C。但被抑制的告警仍然可以抑制其他低优先级告警
 *
 * 输入描述：
 * 	第一行为数字N，表示告警抑制关系个数，0<=N <=120
 * 	接下来N行，每行是由空格分隔的两个告警ID，例如: id1 id2，表示id1抑制id2，告警ID的格式为:
 * 	大写字母+0个或者1个数字
 * 	最后一行为告警产生列表，列表长度[1,100]
 * 输出描述：真实产生的告警列表
 * 备注：告警ID之间以单个空格分隔
 *
 * 示例1：
 * 	输入：
 * 		2
 * 		A B
 * 		B C
 * 		A B C D E
 * 	输出：
 * 		A D E
 * 说明：A抑制了B，B抑制了C，最后实际的告警为A D E
 *
 *
 * 示例2：
 * 	输入：
 * 		4
 * 		F G
 * 		C B
 * 		A G
 * 		A O A
 * 		A B C D E
 * 	输出：
 * 		A C D E
 */
public class _告警抑制_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[] chars = new char[n * 2];

        // 记录下抑制的关系
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            chars[i * 2] = split[0].charAt(0);
            chars[i * 2 + 1] = split[1].charAt(0);
        }

        // 所有抑制警告列表
        String[] split = scanner.nextLine().split(" ");
        Set<Character> set = new HashSet<>();
        for (String s : split) {
            set.add(s.charAt(0));
        }

        // 第二个元素是被抑制的，故其不能够被报
        for (int i = 0; i < n; i++) {
            char b = chars[i * 2 + 1];

            if (set.contains(b)) {
                set.remove(b);
            }
        }

        // 输出能够爆出来的警告id
        for (String s : split) {
            if (set.contains(s.charAt(0))) {
                System.out.print(s.charAt(0) + " ");
            }
        }
    }

}
