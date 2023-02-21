package nowcoder.stringExercise;

import java.util.Scanner;

public class _HJ5_16进制转10进制 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            char[] chars = in.next().toCharArray();
            int pre = 1;
            long sum = 0;

            for (int i = chars.length - 1; i > 1; i--) {

                switch (chars[i]) {
                    case '0' :
                        break;
                    case '1' :
                        sum += pre;
                        break;
                    case '2' :
                        sum += 2 * pre;
                        break;
                    case '3' :
                        sum += 3 * pre;
                        break;
                    case '4' :
                        sum += 4 * pre;
                        break;
                    case '5' :
                        sum += 5 * pre;
                        break;
                    case '6' :
                        sum += 6 * pre;
                        break;
                    case '7' :
                        sum += 7 * pre;
                        break;
                    case '8' :
                        sum += 8 * pre;
                        break;
                    case '9' :
                        sum += 9 * pre;
                        break;
                    case 'A' :
                        sum += 10 * pre;
                        break;
                    case 'B' :
                        sum += 11 * pre;
                        break;
                    case 'C' :
                        sum += 12 * pre;
                        break;
                    case 'D' :
                        sum += 13 * pre;
                        break;
                    case 'E' :
                        sum += 14 * pre;
                        break;
                    case 'F' :
                        sum += 15 * pre;
                        break;
                    default:
                        break;
                }

                pre *= 16;
            }

            System.out.println(sum);
        }
    }

}
