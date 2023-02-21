package nowcoder.ioExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class HJ8_合并表记录 {

    public static void main(String[] args) throws IOException {
//        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        st.nextToken();//分隔符
//        int num = (int)st.nval; //墙砖类型
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//
//        for (int i = 0; i < num; i++) {
//            st.nextToken();
//            int key = (int)st.nval;
//            st.nextToken();
//            int value = (int)st.nval;
//            map.put(key, map.getOrDefault(key, 0) + value);
//        }
//
//        StringBuffer sb = new StringBuffer();
//        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, Integer> next = iterator.next();
//            sb.append(next.getKey()).append(" ").append(next.getValue()).append("\n");
//        }
//        System.out.println(sb.toString());

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        Map<Integer, Integer> map = new TreeMap<>();
        while (n-- > 0) {
            String[] split = in.nextLine().split(" ");
            int key = Integer.parseInt(split[0]);
            int value = Integer.parseInt(split[1]);

            map.put(key, map.getOrDefault(key, 0) + value);
        }

        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

}
