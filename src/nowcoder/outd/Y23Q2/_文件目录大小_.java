package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 一个文件目录的数据格式为:
 * 	目录id，本目录中文件大小，(子目录id列表)。
 * 	其中目录id全局唯一，取值范围[1,200]，本目录中文件大小范围[1,1000]，子目录id列表个数[0,10]
 * 例如 : 1 20 (2,3)表示目录1中文件总大小是20，有两人子目录，id分别是2和3
 * 现在输入一个文件系统中所有日录信息，以及待查询的目录id，返回这个目录和及该目录所有子目录的大小之和
 *
 * 输入描述：
 * 	第一行为两个数字M，N，分别表示目录的个数和待查询的目录id.
 * 	1≤M≤100
 * 	1≤N≤200
 * 	接下来M行，每行为1个目录的数据
 * 	目录id 本目录中文件大小(子目录id列表)
 * 	子目录列表中的子目录id以逗号分隔
 * 输出描述：
 * 	待查询目录及其子目录的大小之和
 * 示例1：
 * 	输入：
 * 		3 1
 * 		3 15 (0)
 * 		1 20 (2)
 * 		2 10 (3)
 * 	输出：
 * 		45
 * 说明：
 * 	目录1大小为20，包含一个子目录2(大小为10)，子目录2包含人子目录3(大小为15)，总的大小为20+10+15=45
 *
 * 示例2：
 * 	输入：
 * 		4 2
 * 		4 20 ()
 * 		5 30 ()
 * 		2 10 (4,5)
 * 		1 40 ()
 * 	输出：
 * 		60
 * 说明：
 * 	目录2包含2个子目录4和5，总的大小为10+20+30 = 60
 */
public class _文件目录大小_ {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int files = Integer.parseInt(split[0]);
        int target = Integer.parseInt(split[1]);
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < files; i++) {
            String[] line = scanner.nextLine().split(" ");
            int id = Integer.parseInt(line[0]);
            int size = Integer.parseInt(line[1]);
            // 子文件夹
            String[] child = line[2].replace("(", "").replace(")", "").split(",");
            Set<Integer> set = new HashSet<>();
            if (!child[0].equals("")) {
                for (String s : child) {
                    set.add(Integer.parseInt(s));
                }
            }

            List<Integer> cur = new ArrayList<>(set);
            cur.add(0, size);
            map.put(id, cur);
        }

        if (!map.containsKey(target)) {
            System.out.println(-1);
            return;
        }

        List<Integer> list = map.get(target);
        int size = list.size();
        int sum = list.get(0);

        // 子文件夹
        for (int i = 1; i < size; i++) {
            sum += dfs(map, list.get(i));
        }

        System.out.println(sum);
    }

    private static int dfs(Map<Integer, List<Integer>> map, Integer target) {
        if (!map.containsKey(target)) {
            return 0;
        }

        List<Integer> list = map.get(target);
        int sum = list.get(0);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            sum += dfs(map, list.get(i));
        }

        return sum;
    }
}
