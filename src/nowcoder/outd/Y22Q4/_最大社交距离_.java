package nowcoder.outd.Y22Q4;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 疫情期间需要大家保证一定的社交距离，公司组织开交流会议。座位一排共 N 个座位，编号分别为[0, N-1],
 * 要求员工一个接着一个进入会议室，并且可以在任何时候离开会议室。
 * 满足：
 * 每当一个员工进入时，需要坐到最大社交距离（最大化自己和其他人的距离的座位）；
 * 如果有多个这样的座位，则坐到索引最小的那个座位。
 * 输入描述：
 * 会议室座位总数 seatNum。(1 <= seatNum <= 500)
 * 员工的进出顺序 seatOrLeave 数组，元素值为 1，表示进场；元素值为负数，表示出场（特殊：位置 0 的员工不会离开）。
 * 例如 -4 表示坐在位置 4 的员工离开（保证有员工坐在该座位上）
 * 输出描述：
 * 最后进来员工，他会坐在第几个位置，如果位置已满，则输出 -1。
 * <p>
 * 示例1：
 * 输入
 * 10
 * [1,1,1,1,-4,1]
 * 输出
 * 5
 * 说明：
 * seat -> 0,坐在任何位置都行，但是要给他安排索引最小的位置，也就是座位 0
 * seat -> 9,要和旁边的人距离最远，也就是座位 9
 * seat -> 4,要和旁边的人距离最远，应该坐到中间，也就是座位 4
 * seat -> 2,员工最后坐在 2 号座位上
 * leave[4], 4 号座位的员工离开
 * seat -> 5,员工最后坐在 5 号座位上
 * <p>
 * 1 0 0 0 1 0 0 0 0 1
 */
public class _最大社交距离_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int seatNum = in.nextInt();
        in.nextLine();
        String seat = in.nextLine();
        String[] c = seat.substring(1, seat.length() - 1).split(",");
        int[] seatOrLeave = new int[c.length];

        for (int i = 0; i < c.length; i++) {
            seatOrLeave[i] = Integer.parseInt(c[i]);
        }

        int ans = seatDistance(seatNum, seatOrLeave);
        System.out.print(ans);
    }

    public static int seatDistance(int seatNum, int[] seatOrLeave) {
        // 使用TreeSet有序集合记录被坐过的座位
        TreeSet<Integer> seatedNums = new TreeSet<>();

        for (int i = 0; i < seatOrLeave.length; i++) {
            int op = seatOrLeave[i];
            if (op > 0) {
                if (seatedNums.size() == 0) {
                    // 如果是第一个坐
                    if (i == seatOrLeave.length - 1) {
                        // 如果只有一个位置
                        return 0;
                    }
                    seatedNums.add(0);
                } else if (seatedNums.size() == 1) {
                    // 第二个人进来，坐在最右边
                    seatedNums.add(seatNum - 1);
                    if (i == seatOrLeave.length - 1) {
                        // 如果只有两个位置
                        return seatNum - 1;
                    }
                } else if (seatedNums.size() > 1 && seatedNums.size() < seatNum) {
                    // 坐到中间的位置
                    int[] ints = new int[seatedNums.size()];
                    int count = 0;

                    // 将已经坐过的位置存入到数组中
                    for (Integer seatedNum : seatedNums) {
                        ints[count++] = seatedNum;
                    }

                    // 计算最远距离——所有已经入座的人 两两比较
                    int maxLen = 0;
                    int start = 0;
                    for (int j = 0; j < ints.length - 1; j++) {
                        int len = ints[j + 1] - ints[j];
                        if (len / 2 > maxLen) {
                            maxLen = len / 2;
                            start = ints[j];
                        }
                    }

                    // 默认最后一个位置已经被占用，则入座号为 ：start + maxLen
                    int wiilSeat = start + maxLen;
                    if (!seatedNums.contains(seatNum - 1) && seatNum - 1 - ints[ints.length - 1] > maxLen) {
                        // 如果最后一个位置没有被占， 并且座位左右边的人离最后一个空位距离最远
                        wiilSeat = seatNum - 1;
                    }

                    // 将对应的起始位置加上最远距离加入 seatedNums
                    seatedNums.add(wiilSeat);
                    if (i == seatOrLeave.length - 1) {
                        return wiilSeat;
                    }
                } else {
                    // 位置坐满
                    return -1;
                }
            } else {
                // 如果是负数，则将该座位移出
                seatedNums.remove(-op);
            }
        }

        return -1;
    }

}
