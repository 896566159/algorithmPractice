package nowcoder.stringExercise;

import java.util.Scanner;

public class HJ12_字符串反转 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = words.length - 1; i > -1; i--) {
            sb.append(words[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

}
