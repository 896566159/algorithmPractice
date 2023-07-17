package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 现有两门选修课，每门选修课都有一部分学生选修，每个学生都有选修课的成绩；
 * 需要你找出同时选修了两门选修课的学生，先按照班级进行划分，班级编号小的先输出，每个班级按照两门选修课成绩和的降序排序，成绩相同时按照学生的学号升序排序。
 *
 * 输入描述：
 * 	第一行为第一门选修课学生的成绩
 * 	第二行为第二门选修课学生的成绩
 * 	每行数据中学生之间以英文分号分隔，每个学生的学号和成绩以英文逗号分隔，学生学号的格式为8位数字(2位院系编号+入学年份后2位+院系内部1位专业编号+所在班级3位学号)，学生成绩的取值范围为[0,100]之间的整数，两门选修课选修学生数的取值范围为[1-2000]之间的整数。
 * 输出描述：
 * 	同时选修了两门选修课的学生的学号，如果没有同时选修两门选修课的学生输出NULL，否则，先按照班级划分，班级编号小的先输出，每个班级先输出班级编号(学号前五位)，然后另起一行输出这个班级同时选修两门选修课的学生学号，学号按照要求排序(按照两门选修课成绩和的降序，成绩和相同时按照学号升序)，学生之间以英文分号分隔。
 *
 * 示例1:
 * 	输入:
 * 		01202021,75;01201033,95;01202008,80;01203006,90;01203088,100
 * 		01202008,70;01203088,85;01202111,80;01202021,75;01201100,88
 * 	输出:
 * 	01202
 * 	01202008;01202021
 * 	01203
 * 	01203088
 * 说明:
 * 	同时选修了两门选修课的学生01202021、01202008、01203088，这三个学生两门选修课的成绩和分别为150、150、185, 01202021、01202008属于01202班的学生，按照成绩和降序，成绩相同时按学号升序输出的结果为01202008:01202021,01203088属于01203班的学生，按照成绩和降序，成绩相同时按学号升序输出的结果为01203088，01202的班级编号小于01203的班级编号，需要先输出。
 *
 * 示例2:
 * 	输入:
 * 		01201022,75;01202033,95;01202018,80;01203006,90;01202066,100
 * 		01202008,70;01203102,85;01202111,80;01201021,75;01201100,88
 * 	输出:
 * 		NULL
 * 说明: 没有同时选修了两门选修课的学生，输出NULL。
 */
public class _选修课_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(";");
        int n = split.length;
        Object[][] students = new Object[n][3];
        // 选修选修课一的学生
        Map<Integer, Object[]> courseOne = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] strings = split[i].split(",");
            // 班级、成绩、学号
            students[i][0] = strings[0].substring(0, 5);
            students[i][1] = Integer.parseInt(strings[1]);
            students[i][2] = Integer.parseInt(strings[0]);
            courseOne.put((Integer) students[i][2], students[i]);
        }

        split = scanner.nextLine().split(";");
        // 选修选修课一的班级班级
        Set<Integer> courseOneclasses = new HashSet<>();
        int m = split.length;
        // 两门课都选修的同学
        List<Object[]> bothCourse = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] strings = split[i].split(",");
            int id = Integer.parseInt(strings[0]);

            // 同时选修两门课的同学
            if (courseOne.containsKey(id)) {
                Object[] student = courseOne.get(id);
                student[1] = (Integer) student[1] + Integer.parseInt(strings[1]);
                bothCourse.add(student);
            }
        }

        if (bothCourse.isEmpty()) {
            System.out.println("NULL");
            return;
        }

        // 排序
        Collections.sort(bothCourse, (a, b)->{
            if (a[0] != b[0]) {
                return ((String) a[0]).compareTo((String) b[0]);
            } else if (a[1] != b[2]) {
                return (Integer) b[1] - (Integer) a[1];
            }
            return (Integer) a[2] - (Integer) b[2];
        });

        // 输出
        String preCla = (String) bothCourse.get(0)[0];
        System.out.println(preCla);
        for (int i = 0; i < bothCourse.size(); i++) {
            if (!preCla.equals((String) bothCourse.get(i)[0])) {
                preCla = (String) bothCourse.get(i)[0];
                System.out.println("\n" + preCla);
            }
            System.out.print(bothCourse.get(i)[2] + " ");
        }
    }

}
