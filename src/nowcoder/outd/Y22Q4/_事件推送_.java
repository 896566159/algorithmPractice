package nowcoder.outd.Y22Q4;

import java.util.Scanner;

public class _事件推送_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];

        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j <= r; j++) {
                // 在数组b中找出第一个 >= a[i] + r 的元素
                int index = binarySearch(b, a[i] + j);
                if (b[index] >= a[i] + j && b[index] - a[i] <= r) {
                    System.out.println(a[i] + " " + b[index]);
                    break;
                }
            }
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        // 在区间 [left, right]
        while (left < right) {
            int mid = (left + right) >>> 1;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

}
