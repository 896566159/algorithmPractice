package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0~N的箱子，每个箱子上面贴有箱子中藏有金币的数量。
 * 从金币数量中选出一个数字集合，并销毁贴有这些数字的每个箱子，如果能销毁一半及以上的箱子，则返回这个数字集合的最小大小。
 * 输入描述:
 * 	一个数字字串，数字之间使用逗号分隔，例如: 6,6,6,6,3,3,3,1,1,5字串中数字的个数为偶数，并且个数>=1，<=100000; 每个数字>=1，<=100000;
 * 输出描述:
 * 	这个数字集合的最小大小，例如: 2
 *
 * 示例1:
 * 	输入:
 * 		1,1,1,1,3,3,3,6,6,8
 * 	输出:
 * 		2
 * 说明:
 * 	选择集合{1,8}，销毁后的结果数组为 [3,3,3,6,6]，长度为 5，长度为原数组的一半。
 * 	大小为 2 的可行集合还有{1,3},{1,6},{3,6}。
 * 	选择6,8 集合是不可行的，它销毁后的结果数组为[1,1,1,1,3,3,3]，新数组长度大于原数组的二分之一。
 *
 * 示例2:
 * 	输入:
 * 		2,2,2,2
 * 	输出:
 * 		1
 * 说明: 我们只能选择集合2，销毁后的结果数组为空
 */
public class _阿里巴巴找黄金宝箱II_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        Map<Integer, Integer> map = new HashMap<>();
        int n = split.length;

        for (String s : split) {
            int key = Integer.parseInt(s);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Integer> count = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count.add(entry.getValue());
        }

        // 排序
        Collections.sort(count, (a, b)->b-a);

        int sum = 0;
        int res = 0;
        for (int i = 0; i < count.size(); i++) {
            sum += count.get(i);
            res++;

            if (sum * 2 >= n) {
                break;
            }
        }

        System.out.println(res);
    }

}
