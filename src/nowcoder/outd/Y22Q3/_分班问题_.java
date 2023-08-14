package nowcoder.outd.Y22Q3;

import java.util.*;

/**
 * 幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友同班，请你帮忙把同班的小朋友找出来。
 * 小朋友的编号是整数，与前一位小朋友同班用Y表示，不同班用N表示。
 * 学生序号范围(0,999]，如果输入不合法则打印ERROR。
 * 输入描述：
 * 	输入为空格分开的小朋友编号和是否同班标志。
 * 输出描述：
 * 	输出为两行，每一行记录一个班小朋友的编号，编号用空格分开，且：
 * 	1.编号需按照升序排列。
 * 	2.若只有一个班的小朋友，第二行为空行。
 *
 * 示例1：
 * 	输入：
 * 		1/N 2/Y 3/N 4/Y
 * 	输出：
 * 		1 2
 * 		3 4
 * 示例2：
 * 	输入：
 * 		1/N 2/Y 3/N 4/Y 5/Y
 * 	输出：
 * 		1 2
 * 		3 4 5
 */
public class _分班问题_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] students = scanner.nextLine().split(" ");
        Set<Integer> cls1 = new TreeSet<>();
        Set<Integer> cls2 = new TreeSet<>();
        int pre = -1;

        for (String student : students) {
            String[] split = student.split("/");
            int id = Integer.parseInt(split[0]);
            if (id < 1 || id > 999) {
                System.out.println("ERROR");
                return;
            }

            if (pre == -1) {
                cls1.add(id);
                pre = 0;
            } else {
                if (split[1].equals("Y")) {
                    if (pre == 0) {
                        cls1.add(id);
                    } else {
                        cls2.add(id);
                    }
                } else {
                    if (pre == 0) {
                        cls2.add(id);
                    } else {
                        cls1.add(id);
                    }
                    pre = pre == 0 ? 1 : 0;
                }
            }
        }

        if (cls2.isEmpty()) {
            for (Integer integer : cls1) {
                System.out.print(integer + " ");
            }
            System.out.println();
        } else {
            List<Integer> c1 = new ArrayList<>(cls1);
            List<Integer> c2 = new ArrayList<>(cls2);
            if (c1.get(0) < c2.get(0)) {
                for (Integer integer : cls1) {
                    System.out.print(integer + " ");
                }
                System.out.println();
                for (Integer integer : cls2) {
                    System.out.print(integer + " ");
                }
            } else {
                for (Integer integer : cls2) {
                    System.out.print(integer + " ");
                }
                System.out.println();
                for (Integer integer : cls1) {
                    System.out.print(integer + " ");
                }
            }
        }

    }

}
