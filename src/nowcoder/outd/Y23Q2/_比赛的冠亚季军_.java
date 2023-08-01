package nowcoder.outd.Y23Q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 有N (3<=N<10000)个运动员，他们的id为0到N-1,他们的实力由一组整数表示。他们之间进行比赛，需要决出冠亚军。
 * 比赛的规则是0号和1号比赛，2号和3号比赛，以此类推，每一轮，相邻的运动员进行比赛，获胜的进入下轮;
 * 实力值大的获胜，实力值相等的情况，id小的情况下获胜:轮空的直接进入下一轮.
 * 输入描述:
 * 	输入一行N个数字代表N的运动员的实力值(0<=实力值<=10000000000).
 * 输出描述:
 * 	输出冠亚季军的id，用空格隔开.
 *
 * 示例1:
 * 	输入:
 * 		2 3 4 5
 * 	输出:
 * 		3 1 2
 * 说明:
 * 	第一轮比赛，id为0实力值为2的运动员和id为1实力值为3的运动员比赛，1号胜出进入下一轮争夺冠亚军，
 * 	id为2的运动员和id为3的云动员比赛，3号胜出进入下一轮争夺冠亚军；
 * 	冠亚军比赛，3号胜1号: 故冠至为3号，亚军为1号。2号0号，比赛进行季军的争夺，2号实力值为4，0号实力值2，故2号胜出，得季军。冠亚季军为3 1 2。
 */
public class _比赛的冠亚季军_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        List<int[]> candidates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            candidates.add(new int[] {i, Integer.parseInt(split[i])});
        }

        while (candidates.size() >= 5) {
            List<int[]> tmp = new ArrayList<>();
            int size = candidates.size();

            for (int i = 0; i < size; i++) {

                int[] cur = candidates.get(i);
                if (i + 1 < size) {
                    int[] next = candidates.get(i + 1);
                    if (next[1] > cur[1]) {
                        tmp.add(next);
                    } else {
                        tmp.add(cur);
                    }
                    i++;
                } else {
                    tmp.add(cur);
                }
            }

            candidates = tmp;
        }

        int[] one = candidates.get(0);
        int[] two = candidates.get(1);
        int[] three = candidates.get(2);
        // 还剩 3 或者 4
        if (candidates.size() == 3) {
            // 比较前门两个得季军，在和后面的比得冠亚军
            if (one[1] < two[1]) {
                if (two[1] < three[1]) {
                    System.out.println(three[0] + " " + two[0] + " " + one[0]);
                } else {
                    System.out.println(two[0] + " " + three[0] + " " + one[0]);
                }
            } else {
                if (one[1] < three[1]) {
                    System.out.println(three[0] + " " + one[0] + " " + two[0]);
                } else {
                    System.out.println(one[0] + " " + three[0] + " " + two[0]);
                }
            }
        } else {
            // 四个人，俩俩比较胜出者参加下一轮争抢冠亚军
            int[] four = candidates.get(3);

            if (one[1] < two[1]) {
                if (three[1] < four[1]) {
                    if (two[1] < four[1]) {
                        if (one[1] < three[1]) {
                            System.out.println(four[0] + " " + two[0] + " " + three[0]);
                        } else {
                            System.out.println(four[0] + " " + two[0] + " " + one[1]);
                        }
                    } else {
                        if (one[1] < three[1]) {
                            System.out.println(two[0] + " " + four[0] + " " + three[0]);
                        } else {
                            System.out.println(two[0] + " " + four[0] + " " + one[0]);
                        }
                    }
                } else {
                    if (two[1] < three[1]) {
                        if (one[1] < four[1]) {
                            System.out.println(three[0] + " " + two[0] + " " + four[0]);
                        } else {
                            System.out.println(three[0] + " " + two[0] + " " + one[0]);
                        }
                    } else {
                        if (one[1] < four[1]) {
                            System.out.println(two[0] + " " + three[0] + " " + four[0]);
                        } else {
                            System.out.println(two[0] + " " + three[0] + " " + one[0]);
                        }
                    }
                }
            } else {
                if (three[1] < four[1]) {
                    if (one[1] < four[1]) {
                        if (two[1] < three[1]) {
                            System.out.println(four[0] + " " + one[1] + " " + three[0]);
                        } else {
                            System.out.println(four[0] + " " + one[1] + " " + two[0]);
                        }
                    } else {
                        if (two[1] < three[1]) {
                            System.out.println(one[0] + " " + four[0] + " " + three[0]);
                        } else {
                            System.out.println(one[0] + " " + four[0] + " " + two[0]);
                        }
                    }
                } else {
                    // 3和1
                    if (one[1] < three[1]) {
                        if (two[1] < four[1]) {
                            System.out.println(three[0] + " " + one[0] + " " + four[0]);
                        } else {
                            System.out.println(three[0] + " " + one[0] + " " + two[0]);
                        }
                    } else {
                        if (two[1] < four[1]) {
                            System.out.println(one[0] + " " + three[0] + " " + four[0]);
                        } else {
                            System.out.println(one[0] + " " + three[0] + " " + two[0]);
                        }
                    }
                }
            }
        }
    }

}
