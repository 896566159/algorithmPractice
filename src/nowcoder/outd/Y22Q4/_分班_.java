package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友是否同班，请你帮忙把同班的小朋友找出来。
 * 小朋友的编号为整数，与前一位小朋友同班用 Y 表示，不同班用 N 表示。
 *
 * 输入为：空格分开的小朋友编号和是否同班标志。
 * 比如：6/N 2/Y 3/N 4/Y，表示共 4 位小朋友，2和6 同班，3和2 不同班，4和3 同班。
 * 其中，小朋友总数不超过999，每个小朋友编号大于 0，小于等于 999。不考虑输入格式错误问题。
 * 输出为：
 * 两行，每一行记录一个班小朋友的编号，编号用空格分开。且：
 * 编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行。
 * 若只有一个班的小朋友，第二行为空行。
 * 若输入不符合要求，则直接输出字符串 ERROR。
 *
 * 示例1：
 * 	输入：
 * 		1/N 2/Y 3/N 4/Y
 * 	输出：
 * 		1 2
 * 		3 4
 * 说明：
 * 	2的同班标记为Y，因此和1同班。 3的同班标记为N，因此和1、2不同班。 4的同班标记为Y，因此和3同班。
 * 	所以1、2同班，3、4同班，
 * 输出为：
 * 1 2
 * 3 4
 */
public class _分班_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        // 两个班级的学生
        Set<Integer> c1 = new TreeSet<>();
        Set<Integer> c2 = new TreeSet<>();
        // 所有学生
        Set<Integer> c = new TreeSet<>();

        String[] split = s.split(" ");
        int n = split.length;
        if (n < 1 || n > 999) {
            // 输入为空或者超出要求
            System.out.println("ERROR");
            return;
        }

        // 先处理第一个学生
        String[] first = split[0].split("/");
        if (first[1].equals("Y")) {
            // 第一个学生前面没有人
            System.out.println("ERROR");
            return;
        }
        // 标记上一个学生的班级号，1：c1,2:c2，默认第一个是 c1 班级的，将其将入到 c1 班级中
        int flag = 1;
        int minNum = Integer.parseInt(first[0]);
        c1.add(minNum);
        // 序号最小的学生其所在的班级编号
        int minClass = 1;

        // 从第二个学生开始，看他与前一个学生是否在同一班级
        for (int i = 1; i < n; i++) {
            String[] cur = split[i].split("/");
            int num = Integer.parseInt(cur[0]);
            if (c.contains(num)) {
                // 一个学号出现两次
                System.out.println("ERROR");
                return;
            }

            if (cur[1].equals("N")) {
                // 与前一个不是同班级的
                flag = flag == 1 ? 2 : 1;
            }

            // 将该同学放入班级
            if (flag == 1) {
                c1.add(num);
            } else {
                c2.add(num);
            }

            // 该学号是最小的
            if (num < minNum) {
                minNum = num;
                minClass = flag;
            }
        }

        Iterator<Integer> iterator1 = c1.iterator();
        Iterator<Integer> iterator2 = c2.iterator();
        if (minClass == 1) {
            // 先输出 c1 班级
            while (iterator1.hasNext()) {
                System.out.print(iterator1.next() + " ");
            }
            System.out.println();
            // 再输出 c2 班级
            while (iterator2.hasNext()) {
                System.out.print(iterator2.next() + " ");
            }
        } else {
            // 先输出 c2 班级
            while (iterator2.hasNext()) {
                System.out.print(iterator2.next() + " ");
            }
            System.out.println();
            // 再输出 c1 班级
            while (iterator1.hasNext()) {
                System.out.print(iterator1.next() + " ");
            }
        }
    }

}
