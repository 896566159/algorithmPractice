package nowcoder.stringExercise;

import java.util.Scanner;

public class HJ9_提取不重复的整数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[10];
        int len = 1;

        while (num != 0) {
            int last = num % 10;//取到当前最后一个数字
            if (arr[last] == 0) {//如果该数字第一次出现，则记录起来
                arr[last] = len++;
            }
            num /= 10;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[j] == i) {
                    sb.append(j);
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }

}
