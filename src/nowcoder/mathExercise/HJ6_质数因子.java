package nowcoder.mathExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HJ6_质数因子 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        while((str = br.readLine()) != null) {
//            int num = Integer.parseInt(str);
//            StringBuilder sb = new StringBuilder();
//            for (int i = 2; i < Math.sqrt(num); i++) {
//                if (num % i == 0) {
//                    sb.append(i).append(" ");
//                    num /= i;
//                    i--;//多次判断：如 8 = 2 * 2 * 2
//                }
//            }
//            sb.append(num).append(" ");
//            System.out.println(sb.toString());
//        }

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str = in.next();
            Integer num = Integer.parseInt(str);
            StringBuffer sb = new StringBuffer();

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    sb.append(i + " ");
                    num /= i;
                    i--;
                }
            }
            sb.append(num);
            System.out.println(sb.toString());
        }
    }
}
