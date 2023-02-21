package nowcoder.stringExercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9_提取不重复的整数 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int[] arr = new int[10];
//        int len = 1;
//
//        while (num != 0) {
//            int last = num % 10;//取到当前最后一个数字
//            if (arr[last] == 0) {//如果该数字第一次出现，则记录起来
//                arr[last] = len++;
//            }
//            num /= 10;
//        }
//
//        StringBuffer sb = new StringBuffer();
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < 10; j++) {
//                if (arr[j] == i) {
//                    sb.append(j);
//                    break;
//                }
//            }
//        }
//
//        System.out.println(sb.toString());
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

            char[] chars = in.next().toCharArray();
            Set<Character> set = new HashSet<>();

            for (int i = chars.length - 1; i > -1; i--) {
                set.add(chars[i]);
            }

            for (int i = chars.length - 1; i > -1; i--) {
                if (set.contains(chars[i])) {
                    System.out.print(chars[i]);
                    set.remove(chars[i]);
                }
            }
        }


    }

}
