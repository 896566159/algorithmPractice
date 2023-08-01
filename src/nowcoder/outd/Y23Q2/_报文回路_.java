package nowcoder.outd.Y23Q2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _报文回路_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        HashMap<Integer, HashSet<Integer>> matrix = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int d1 = scanner.nextInt();
            int d2 = scanner.nextInt();
            matrix.putIfAbsent(d1, new HashSet<>());
            matrix.putIfAbsent(d2, new HashSet<>());
            matrix.get(d1).add(d2);
        }

        for (Integer d1 : matrix.keySet()) {
            for (Integer d2 : matrix.get(d1)) {
                if (!matrix.get(d2).contains(d1)) {
                    System.out.println("False");
                    return;
                }
            }
        }
        System.out.println("True");
        return;

    }

}
