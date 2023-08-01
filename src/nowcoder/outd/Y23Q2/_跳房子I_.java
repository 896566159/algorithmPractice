package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 跳房子，也叫跳飞机，是一种世界性的儿童游戏
 * 游戏参与者需要分多个回合按顺序跳到第1格直到房子的最后一格。
 * 跳房子的过程中，可以向前跳，也可以向后跳。
 * 假设房子的总格数是count，小红每回合可能连续跳的步教都放在数组steps中，请问数组中是否有一种步数的组合，可以让小红两个回合跳到量后一格?如果有，请输出索引和最小的步数组合.
 * 注意: 数组中的步数可以重复，但数组中的元素不能重复使用。提供的数据保证存在满足题目要求的组合，且索引和最小的步数组合是唯一的
 *
 * 输入描述:
 * 	第一行输入为房子总格数count，它是int整数类型。
 * 	第二行输入为每回合可能连续跳的步数，它是int整数数组类型
 * 输出描述:
 * 	返回索引和最小的满足要求的步数组合(顺序保持steps中原有顺序)
 * 备注:
 * 	count ≤ 1000
 * 	0 ≤ steps.length ≤ 5000
 * 	-100000000 ≤steps ≤ 100000000
 *
 * 示例1：
 * 	输入:
 * 		[1,4,5,2,2]
 * 		7
 * 	输出:
 * 		[5, 2]
 * 示例2：
 * 	输入:
 * 		[-1,2,4,9,6]
 * 		8
 * 	输出:
 * 		[-1, 9]
 * 说明:
 * 此样例有多种组合满足两回合跳到最后，譬如: [-1,9]，[2,6]，其中[-1,9]的索引和为0+3=3，[2,6]的索和为1+4=5，所以索引和最小的步数组合[-1,9]
 */
public class _跳房子I_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().replace("[", "").replace("]", "").split(",");
        int count = Integer.parseInt(scanner.nextLine());
        int n = split.length;
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(split[i]);
            if (!map.containsKey(key)) {
                map.put(key, i);
            }
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        for (Integer integer : list) {
            if (map.containsKey(count - integer)) {
                int sum = map.get(integer) + map.get(count - integer);
                if (sum < min) {
                    min = sum;
                    left = integer;
                    right = count - integer;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(split[i]);
            if (key == left) {
                System.out.println("[" + left + "," + right + "]");
                break;
            } else if (key == right) {
                System.out.println("[" + right + "," + left + "]");
                break;
            }
        }
    }

}
