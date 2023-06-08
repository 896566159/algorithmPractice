package nowcoder.outd.Y22Q4;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _最大N个数与最小N个数的和_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        Set<Integer> set = new TreeSet<>();

        if (arr.length < 2 * n) {
            System.out.println(-1);
            return;
        }

        // 排序去重
        for (int s : arr) {
            set.add(s);
        }

        if (set.size() < 2 * n) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        int size = set.size();
        int idx = size - n;
        int i = 0;

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (i < n || i >= idx) {
                sum += next;
            }
            i++;
        }

        System.out.println(sum);
    }

}
