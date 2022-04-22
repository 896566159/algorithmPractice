package nowcoder.stringExercise;

import java.util.*;

public class HJ14_字符串排序 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();

        while (n-- > -1) {
            String s = sc.nextLine();
            if (s != "" && s.length() > 0) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            for (int i = 0; i < next.getValue(); i++) {
                System.out.println(next.getValue());
            }
        }
    }

}
