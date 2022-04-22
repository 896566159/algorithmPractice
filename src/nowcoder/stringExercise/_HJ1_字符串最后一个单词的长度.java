package nowcoder.stringExercise;

import java.util.Scanner;

public class _HJ1_字符串最后一个单词的长度 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] words = str.split(" ");
//        System.out.println(words[words.length - 1].length());
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = str.length() - 1;
        int len = str.length();

        while (str.charAt(index) != ' ' && index > 0) {
            index--;
        }

        int ans = str.charAt(index) == ' ' ? len - index + 1 : len;
        System.out.println(ans);
    }

}
