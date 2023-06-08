package nowcoder.outd.Y22Q4;

import java.util.Scanner;

public class _工号不够用了怎么办_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int dig = 1;
        while (26 * Math.pow(10, dig) < count) {
            dig++;
        }

        System.out.println(dig);
    }

}
