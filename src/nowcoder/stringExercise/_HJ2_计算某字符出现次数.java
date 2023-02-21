package nowcoder.stringExercise;

import java.util.Scanner;

public class _HJ2_计算某字符出现次数 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        char c = sc.next().charAt(0);
//        int count = 0;
//
//        for (int i = 0; i < line.length(); i++) {
//            if (c == Character.toUpperCase(line.charAt(i)) || c == Character.toLowerCase(line.charAt(i)))  {
//                count++;
//            }
//        }
//
//        System.out.println(count);

        Scanner in = new Scanner(System.in);

        char[] chars = in.nextLine().toLowerCase().toCharArray();
        char[] ch = in.next().toLowerCase().toCharArray();
        int count = 0;

        for (char c : chars) {
            if (c == ch[0]) {
                count++;
            }
        }

        System.out.println(count);
    }

}
