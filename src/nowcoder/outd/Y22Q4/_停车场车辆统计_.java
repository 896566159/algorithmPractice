package nowcoder.outd.Y22Q4;

import java.util.Scanner;

public class _停车场车辆统计_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().replace(",", "").toCharArray();
        int car = 0;
        int length = chars.length;

        for (int left = 0; left < length; left++) {
            if (chars[left] == '1') {
                int right = left + 1;

                while (right < length && chars[right] == '1') {
                    right++;
                }

                int size = right - left;
                car += (size / 3);
                size %= 3;
                car += (size / 2);
                size %= 2;
                car += size;
                left = right;
            }
        }

        System.out.println(car);
    }

}
