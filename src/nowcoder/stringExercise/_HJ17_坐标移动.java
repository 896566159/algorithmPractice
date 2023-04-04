package nowcoder.stringExercise;

import java.util.Scanner;

public class _HJ17_坐标移动 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();

        String[] split = in.split(";");
        int x = 0;
        int y = 0;

        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if (str.startsWith("A") || str.startsWith("W") || str.startsWith("D")  || str.startsWith("S")) {
                char[] chars = str.toCharArray();
                boolean isDigtal = true;

                for (int j = 1; j < chars.length; j++) {
                    if (chars[j] - '0' < 0 || chars[j] - '9' > 0) {
                        isDigtal = false;
                        break;
                    }
                }

                if (isDigtal) {
                    char c = chars[0];
                    String substring = str.substring(1, str.length());

                    if (c == 'A') {
                        x -= Integer.parseInt(substring);
                    } else if (c == 'D') {
                        x += Integer.parseInt(substring);
                    } else if (c == 'S') {
                        y -= Integer.parseInt(substring);
                    } else if (c == 'W') {
                        y += Integer.parseInt(substring);
                    }
                }
            }
        }

        System.out.println(x + "," + y);
    }

}
