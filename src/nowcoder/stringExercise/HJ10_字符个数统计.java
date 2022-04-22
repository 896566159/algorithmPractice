package nowcoder.stringExercise;

import java.util.Scanner;

public class HJ10_字符个数统计 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[128];
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)] == 0) {
                arr[str.charAt(i)] = 1;
                count++;
            }
        }

        System.out.println(count);
    }

}
