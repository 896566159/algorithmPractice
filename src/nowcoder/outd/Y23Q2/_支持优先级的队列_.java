package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 实现一个支持优先级的队列，高优先级先出队列，同优先级时先进先出。
 * 如果两个输入数据和优先级都相同，则后一个数据不入队列被丢弃。
 * 队列存储的数据内容是一个整数。
 *
 * 输入描述：
 * 	一组待存入队列的数据（包含内容和优先级）。
 * 输出描述：
 * 	队列的数据内容（优先级信息输出时不再体现）。
 * 补充说明：不用考虑数据不合法的情况，测试数据不超过100个。
 *
 * 示例1：
 * 	输入:
 * 		(10,1),(20,1),(30,2),(40,3)
 * 	输出:
 * 		40,30,10,20
 * 说明:
 * 	输入样例中，向队列写入了4个数据，每个数据由数据内容和优先级组成。
 * 	输入和输出内容都不含空格。
 * 	数据40的优先级最高，所以最先输出，其次是30；10和20优先级相同，所以按输入顺序输出
 *
 * 示例2：
 * 	输入:
 * 		(10,1),(10,1),(30,2),(40,3)
 * 	输出:
 * 		40,30,10
 * 说明:
 * 	输入样例中，向队列写入了4个数据，每个数据由数据内容和优先级组成输入和输出内容都不含空格。
 * 	数据40的优先级最高，所以最先输出，其次是30;
 * 	两个10和10构成重复数据，被丢弃一个。
 */
public class _支持优先级的队列_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().replace("),(", "#").replace(")", "").replace("(", "").split("#");

        List<int[]> original = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            String[] digit = split[i].split(",");
            original.add(new int[] {Integer.parseInt(digit[0]), Integer.parseInt(digit[1])});
        }

        Collections.sort(original, (a, b)->{
            if (a[1] != b[1]) {
                return b[1] - a[1];
            }
            return 0;
        });

        // 输出
        if (original.isEmpty()) {
            System.out.println(-1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(original.get(0)[0]);

        int preData = original.get(0)[0];
        int preProority = original.get(0)[0];
        for (int i = 1; i < original.size(); i++) {
            if (preProority != original.get(i)[1] && preData != original.get(i)[0]) {
                sb.append(",").append(original.get(i)[0]);
            }
            preProority = original.get(i)[1];
            preData = original.get(i)[0];
        }

        System.out.println(sb.toString());
    }

    static class  Truple {
        int data;
        int priority;

        public Truple(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

}
