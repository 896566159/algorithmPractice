package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 游乐场里增加了一批摇摇车，非常受小朋友欢迎，但是每辆摇摇车同时只能有一个小朋友使用，如果没有空余的摇摇车需要排队等候，或者直接离开，最后没有玩上的小朋友会非常不开心。
 * 请根据今天小朋友的来去情况，统计不开心的小朋友数量
 * 	1.摇摇车数量为N，范围是: 1 <= N < 10;
 * 	2.每个小朋友都对应一个编码，编码是不重复的数字，今天小朋友的来去情况，可以使用编码表示为:1 1 2 3 2 3。(若小朋友离去之前有空闲的摇摇车，则代表玩耍后离开;不考虑小朋友多次玩的情况)。小朋友数量≤ 100
 * 	3.题目保证所有输入数据无异常且范围满足上述说明
 *
 * 输入描述:
 * 	第一行: 摇摇车数量
 * 	第二行: 小朋友来去情况
 * 输出描述:
 * 	返回不开心的小朋友数量
 *
 * 示例1：
 * 	输入:
 * 		1
 * 		1 2 1 2
 * 	输出:
 * 		0
 * 说明:
 * 	第一行，1个摇摇车
 * 	第二行，1号来 2号来(排队)
 * 	第三行，1号走 2号走(1号走后摇摇车已有空闲，所以玩后离开)
 *
 * 示例2：
 * 	输入:
 * 		1
 * 		1 2 2 3 1 3
 * 	输出:
 * 		1
 * 说明:
 * 	第一行，1个摇摇车
 * 	第二行，1号来 2号来(排队) 2号走(不开心离开) 3号来(排队) 1号走 3号走(1号走后摇摇车已有空闲，所以玩后离)
 *
 * 示例3：
 * 	输入:
 * 		3
 * 		1 2 3 4 5 6 7 3 8 2 1 6 8 7 5
 * 	输出:
 * 		1
 * 说明:
 * 	第一行，3个摇摇车
 * 	最终只有8号没有坐过车
 */
public class _不开心的小朋友_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cars = Integer.parseInt(scanner.nextLine());
        int[] seats = new int[cars + 1];
        
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> history = new HashSet<>();
        Set<Integer> hold = new HashSet<>();
        List<int[]> wait = new ArrayList<>();
        int res = 0;
        int waitIndex = 0;

        for (int i = 0; i < n; i++) {
            int curChild = Integer.parseInt(split[i]);

            // 小朋友之前出现过——出现过代表小朋友离开
            if (history.contains(curChild)) {
                // 判断小朋友有没有做过车
                if (hold.contains(curChild)) {
                    // 小朋友在等待队列中
                    res++;
                    // 把小朋友从等待队列中删除
                    hold.remove(curChild);
                    int removeIndex = 0;
                    for (int j = 0; j < wait.size(); j++) {
                        if (wait.get(j)[1] == curChild) {
                            removeIndex = j;
                            break;
                        }
                    }
                    wait.remove(removeIndex);
                } else {
                    // 小朋友坐过车
                    // 如果还有小朋友，则让下一位小朋友过来坐车
                    if (hold.size() > 0) {
                        Collections.sort(wait, (a, b)->a[1] - b[1]);
                        int[] first = wait.remove(0);
                        hold.remove(first[1]);
                    } else {
                        cars++;
                    }
                    history.remove(curChild);
                }
            } else {
                history.add(curChild);
                // 看是否有空余的玩具车
                if (cars > 0) {
                    cars--;
                } else {
                    // 进入队列等待
                    hold.add(curChild);
                    wait.add(new int[] {waitIndex++, curChild});
                }
            }
        }

        System.out.println(res);
    }

}
