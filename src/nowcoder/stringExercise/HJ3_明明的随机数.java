package nowcoder.stringExercise;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class HJ3_明明的随机数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeSet<Integer> treeSet = new TreeSet<>();
        while (in.hasNextInt()) {
            int N = in.nextInt();
            treeSet.clear();

            while (N-- > 0) {
                treeSet.add(in.nextInt());
            }

            Iterator<Integer> iterator = treeSet.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

}
