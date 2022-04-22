package nowcoder.stringExercise;

import java.util.Scanner;

public class HJ15_求int型正整数在内存中存储时1的个数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        while (n != 0) {
            count += (n % 2);
            n /= 2;
        }

        System.out.println(count);
    }

}
