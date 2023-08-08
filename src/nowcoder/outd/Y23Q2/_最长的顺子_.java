package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 斗地主起源于湖北十堰房县，据说是一位叫吴修全的年轻人根据当地流行的扑克玩法“跑得快”改编的，如今已风靡整个中国，并流行于互联网上。
 * 牌型：
 * 单顺，又称顺子，最少5张牌，最多12张牌(3…A)不能有2，也不能有大小王，不计花色。
 * 例如：
 * 3-4-5-6-7-8，7-8-9-10-J-Q，3-4-5-6-7-8-9-10-J-Q-K-A
 * 可用的牌 3<4<5<6<7<8<9<10<J<Q<K<A<2<B(小王)<C(大王)，每种牌除大小王外有四种花色
 * (共有13×4+2张牌)
 *
 * 输入描述：
 * 	输入的第一行为当前手中的牌
 * 	输入的第二行为已经出过的牌(包括对手出的和自己出的牌)
 * 输出描述：
 * 	最长的顺子
 * 	对手可能构成的最长的顺子(如果有相同长度的顺子，输出牌面最大的那一个)，
 * 	如果无法构成顺子，则输出 NO-CHAIN。
 *
 * 示例：
 * 示例1：
 * 	输入：
 * 		3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A-A-A-A
 * 		4-5-6-7-8-8-8
 * 	输出：
 * 		9-10-J-Q-K
 *
 * 示例2：
 * 	输入：
 * 		3-3-3-3-8-8-8-8
 * 		K-K-K-K
 * 	输出：
 * 		NO-CHAIN
 * 说明：剩余的牌无法构成顺子
 */
public class _最长的顺子_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split("-");
        String[] line2 = scanner.nextLine().split("-");
        int[] count = new int[15];
        Arrays.fill(count, 4);

        count = sub(line1, count);
        count = sub(line2, count);

        int max = 0;
        int index = 0;
        for (int i = 3; i < 11; i++) {
            int j = i;
            while (j <15 && count[j] >= 1) {
                j++;
            }

            if (j - i >= 5 && max <= j - i) {
                max = j - i;
                index = i;
            }
        }

        if (max == 0) {
            System.out.println("NO-CHAIN");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(index);
            for (int i = index + 1; i < index + max; i++) {
                if (i < 11) {
                    sb.append("-").append(i);
                } else {
                    sb.append("-");
                    if (i == 11) {
                        sb.append("J");
                    } else if (i == 12) {
                        sb.append("Q");
                    } else if (i == 13) {
                        sb.append("K");
                    } else if (i == 14) {
                        sb.append("A");
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static int[] sub(String[] line1, int[] count) {
        for (String s : line1) {
            int value = 0;
            switch (s) {
                case "J":
                    value = 11;
                    break;
                case "Q":
                    value = 12;
                    break;
                case "K":
                    value = 13;
                    break;
                case "A":
                    value = 14;
                    break;
                case "B":
                    break;
                default:
                    value = Integer.parseInt(s);
            }

            count[value]--;
        }
        return count;
    }

}
