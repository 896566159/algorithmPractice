package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _分苹果_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> weights = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                weights.add(scanner.nextInt());
            }

            int aWeight = 0;
            int bWeight = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                // 不进位的二进制加法，等同于做异或操作
                aWeight ^= weights.get(i);
                bWeight += weights.get(i);
                min = Math.min(weights.get(i), min);
            }

            if (aWeight == 0) {
                System.out.println(bWeight - min);
            } else {
                System.out.println(-1);
            }
        }
    }

}
