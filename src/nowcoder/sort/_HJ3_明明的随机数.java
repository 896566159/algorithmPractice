package nowcoder.sort;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _HJ3_明明的随机数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //获取个数
        int num = sc.nextInt();
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < num; i++) {
            set.add(sc.nextInt());
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }

}
