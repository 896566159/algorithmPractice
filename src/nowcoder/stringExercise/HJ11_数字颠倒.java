package nowcoder.stringExercise;

import java.util.Scanner;

public class HJ11_数字颠倒 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number == 0) {
            System.out.print(0);
        }
        StringBuffer sb = new StringBuffer();

        while (number != 0)  {
            sb.append(number % 10);
            number /= 10;
        }

        System.out.print(sb.toString());
    }

}
