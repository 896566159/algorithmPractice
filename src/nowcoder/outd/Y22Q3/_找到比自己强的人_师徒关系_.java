package nowcoder.outd.Y22Q3;

import java.util.*;

/**
 * 给定数组[[2,1],[3 2]]，
 * 每组表示师徒关系，第一个元素是第二个元素的老师，数字代表排名，
 * 现在找出比自己强的徒弟。
 *
 * 示例1：
 * 	输入：
 * 		[[2,1],[3,2]]
 * 	输出：
 * 		[0,1,2]
 * 说明：
 * 	第一行数据[2,1]表示排名第 2 的员工是排名第 1 员工的导师，后面的数据以此类推。
 * 	第一个元素 0 表示成绩排名第一的导师，没有徒弟考试超过他；
 * 	第二个元素 1 表示成绩排名第二的导师，有 1 个徒弟成绩超过他
 * 	第三个元素 2 表示成绩排名第二的导师，有 2 个徒弟成绩超过他
 *
 * 示例2：
 * 	输入：
 * 		[[2,1],[3,2]]
 * 	输出：
 * 		[0,1,2]
 */
public class _找到比自己强的人_师徒关系_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().replace("],[", "#").replace("[", "").replace("]", "").split("#");
        // 统计每个老师门下有多少个学生超过他
        Map<Integer, Integer> map = new TreeMap<>();
        for (String s : split) {
            String[] item = s.split(",");
            int master = Integer.parseInt(item[0]);
            int student = Integer.parseInt(item[1]);

            // 把学生和老师都记录一下
            if (!map.containsKey(master)) {
                map.put(master, 0);
            }
            if (!map.containsKey(student)) {
                map.put(student, 0);
            }

            // 学生比老师强
            if (master > student) {
                // 学生的学生
                Integer allStudent = map.get(student);
                map.put(master, map.get(master) + 1 + allStudent);
            }
        }

        int index = 0;
        System.out.print("[");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (index++ > 0) {
                System.out.print("," + entry.getValue());
            } else {
                System.out.print(entry.getValue());
            }
        }
        System.out.print("]");
    }

}
