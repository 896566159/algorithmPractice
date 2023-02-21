package nowcoder.stringExercise;

import java.util.Scanner;

public class _HJ4_字符串分隔 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int len = str.length();
//        int start  = 0;
//
//        for (int i = 0; i < len; i++) {
//            if (i % 8 == 0) {
//                System.out.print(str.substring(start, i + 1));
//                start = i;
//            }
//        }

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            char[] chars = in.next().toCharArray();
            StringBuffer sb = new StringBuffer();

            int index = 1;
            for (char c : chars) {
                sb.append(c);

                if (index != 0 && index % 8 == 0) {
                    sb.append(' ');
                }
                index++;
            }

            index--;
            while (index % 8 != 0) {
                sb.append(0);
                index++;
            }

            System.out.println(sb.toString());
        }
    }

}
