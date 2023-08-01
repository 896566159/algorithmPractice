package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 现有两个整数数组，需要你找出两个数组中同时出现的整数，并按照如下要求输出:
 * 	1.有同时出现的整教时，先按照同时出现次数(整数在两个数组中都出现并目出现次数较少的那个)进行归类，然后按照出现次数从小到大依次按行输出。
 * 	2.没有同时出现的整数时，输出NULL
 * 输入描述：
 * 	第一行为第一个整数数组，第二行为第二个整数数组，每行数中整数与整数之间以英文号分，整数的取值范用为200,2001，数组长度的范用为[1，10000]之间的整数。
 * 输出描述：
 * 	按照出现次数从小到大依次按行输出，每行输出的格式为:
 * 	出现次数:该出现次数下的整数升序排序的结果
 * 	格式中的"."为英文冒号，整数间以英文逗号分隔.
 *
 * 示例1：
 * 	输入：
 * 		5,3,6,-8,0,11
 * 		2,8,8,8,-1,15
 * 	输出：
 * 		NULL
 * 说明：两个整数数组没有同时出现的整数，输出NULL。
 *
 * 示例2：
 * 	输入：
 * 		5,8,11,3,6,8,8,-1,11,2,11,11
 * 		11,2,11,8,6,8,8,-1,8,15,3,-9,11
 * 	输出：
 * 		1:-1,2,3,6
 * 		3:8,11
 * 说明：
 * 	两整数数组中同时出现的整数为-1、3、6、8、11,
 * 	其中同时出现次数为1的整数为-1,2,3,6(升序排序),
 * 	同时出现次数为3的整数为8,11(升序排序),
 * 	先升序输出出现次数为1的整数，再升序输出出现次数为3的整数。
 */
public class _找出两个整数数组中同时出现的整数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(",");
        String[] line2 = scanner.nextLine().split(",");
        int n1 = line1.length;
        int n2 = line2.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, List<Integer>> res = new TreeMap<>();

        for (int i = 0; i < n1; i++) {
            int ele = Integer.parseInt(line1[i]);
            map1.put(ele, map1.getOrDefault(ele, 0) + 1);
        }
        for (int i = 0; i < n2; i++) {
            int ele = Integer.parseInt(line2[i]);
            map2.put(ele, map2.getOrDefault(ele, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int count = Math.min(entry.getValue(), map2.get(entry.getKey()));
                if (!res.containsKey(count)) {
                    res.put(count, new ArrayList<>());
                }
                res.get(count).add(entry.getKey());
            }
        }

        if (!res.isEmpty()) {
            for (Integer key : res.keySet()) {
                List<Integer> list = res.get(key);
                Collections.sort(list);
                System.out.print(key + ":");
                System.out.print(list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    System.out.print("," + list.get(i));
                }
                System.out.println();
            }
        } else {
            System.out.println("NULL");
        }

    }

}
