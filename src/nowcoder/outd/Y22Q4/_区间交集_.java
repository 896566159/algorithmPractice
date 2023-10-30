package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一组闭区间，其中部分区间存在交集。
 * 任意两个给定区间的交集，称为公共区间(如:[1,2],[2,3]的公共区间为[2,2]; [3,5], [3,6]的公共区间为[3,5])。
 * 公共区间之间若存在交集，则需要合并(如:[1,3],[3,5]区间存在交集[3,3]，需合并为[1,5])。
 * 按升序排列输出合并后的区间列表。
 * 输入描述:
 * 	一组区间列表，区间数为 N: 0<=N<=1000;区间元素为 X: -10000<=X<=10000。
 * 输出描述:
 * 	升序排列的合并区间列表
 *
 * 备注:
 * 	1、区间元素均为数字，不考虑字母、符号等异常输入。
 * 	2、单个区间认定为无公共区间。
 *
 * 示例1:
 * 	输入:
 * 		[[0, 3], [1, 3], [3, 5], [3, 6]]
 * 	输出:
 * 		[[1, 5]]
 * 说明:
 * [0,3] 和 [1,3]的公共区间为[1,3]，
 * [0,3]和[3,5]的公共区间为[3,3]，
 * [0,3]和[3,6]的公共区间为[3,3]，
 * [1,3]和[3,5]的公共区间为[3,3]，
 * [1,3]和[3,6]的公共区间为[3,3]，
 * [3,5]和[3,6]的公共区间为[3,5]，
 * 公共区间列表为[[1,3],[3,3],[3,5]]；[1,3],[3,3],[3,5]存在交集，须合并为[1,5]。
 *
 * 示例2
 * 	输入:
 * 		[[1, 6], [2, 5], [5, 7]]
 * 	输出:
 * 		[[2, 6]]
 * 说明:
 * [1,6]、[2,5]的交集为[2,5]
 * [1,6]、[5,7]的交集为[5,6]
 * [2,5]、[5,7]的交集为[5,5]
 * 最后的输出为：2 6
 *
 * 示例3:
 * 	输入：
 * 		[[1, 2], [3, 4]]
 * 	输出：
 *      没有公共区间（题目没有对无公共区间时的输出做要求）
 *
 * 示例4：
 *  输入:
 *      [[1, 3], [2, 4], [4, 8], [5, 9]]
 *  输出：
 *      [[1,5]]
 */
public class _区间交集_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.replace("[", "");
        s = s.replace("]", "");
        s = s.replace(" ", "");
        String[] split = s.split(",");
        int n = split.length;
        int[] points = new int[n];

        // 字符串先转成数字
        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(split[i]);
        }

        // 计算所有区间有交集——公共区间
        List<int[]> publicSection = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            // 计算每个区间 (point[i], point[i]) 和其他所有区间形成的区间
            for (int j = i + 2; j < n; j += 2) {
                // 因为所有表示区间的点是乱序的，没有排序，所以这里判断时，如果两个区间的起始点都在重点的左边，则没有形成公共区间
                int left = Math.max(points[i], points[j]);
                int right = Math.min(points[i + 1], points[j + 1]);

                if (left <= right) {
                    // 形成了交集，即有公共区间
                    publicSection.add(new int[] {left, right});
                }
            }
        }

        // 所有区间都是独立的，没有交集——没有形成公共区间
        if (publicSection.isEmpty()) {
            System.out.println("无公共区间");
            return;
        }

        // 公共区间链表转成数组形式，方便合并公共区间
        int[][] sections = publicSection.toArray(new int[publicSection.size()][2]);
        // 排序
        Arrays.sort(sections, (a, b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        // 合并公共区间
        List<int[]> meger = new ArrayList<>();
        int index = 0;
        while (index < sections.length) {
            int right = sections[index][1];
            int next = index + 1;

            while (next < sections.length && sections[next][0] <= right) {
                right = Math.max(sections[next][0], sections[index][1]);
                next++;
            }

            // 合并后的区间添加到结果中
            if (next == index + 1) {
                // 两个公共区间没有交集，不进行合并
                meger.add(new int[]{sections[index][0], sections[index][1]});
            } else {
                // 两个公共区间有交集，进行合并
                meger.add(new int[]{sections[index][0], sections[next == sections.length ? sections.length - 1: next][1]});
            }

            index = next;
        }

        System.out.print("[");
        for (int i = 0; i < meger.size(); i++) {
            System.out.print("[");
            System.out.print(meger.get(i)[0]);
            System.out.print(",");
            System.out.print(meger.get(i)[1]);
            System.out.print("]");
            if (meger.size() - 1 != i) {
                System.out.print(", ");
            }
        }
        System.out.println("]");



        // ----------------------------网上的版本----------------------------------------
//        Scanner in = new Scanner(System.in);
//        String[] str = in.nextLine().split(" ");
//        int[] arr = new int[str.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(str[i]);
//        }
//        // 先计算交集
//        List<int[]> res = new ArrayList<>();
//        for (int i = 0; i < arr.length; i += 2) {
//            for (int j = i + 2; j < arr.length; j += 2) {
//                int left = Math.max(arr[i], arr[j]);
//                int right = Math.min(arr[i + 1], arr[j + 1]);
//                if (left <= right) {
//                    res.add(new int[]{left, right});
//                }
//            }
//        }
//        // 计算完交集，按从小到大排序，左边界升序，相同，有边界升序
//        int[][] ans = res.toArray(new int[res.size()][]);
//        Arrays.sort(ans, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
//        // 求交集的并集
//        int[][] result = new int[ans.length][2];
//        int index = -1;
//        for (int[] an : ans) {
//            if (index == -1 || an[0] > result[index][1]) {
//                result[++index] = an;
//            } else {
//                result[index][1] = Math.max(result[index][1], an[1]);
//            }
//        }
//        int[][] last = Arrays.copyOf(result, index + 1);
//        for (int i = 0; i < last.length; i++) {
//            System.out.print("[");
//            System.out.print(last[i][0]);
//            System.out.print(",");
//            System.out.print(last[i][1]);
//            System.out.print("]");
//            if (i != last.length - 1) {
//                System.out.print(" ");
//            }
//        }
    }
}
