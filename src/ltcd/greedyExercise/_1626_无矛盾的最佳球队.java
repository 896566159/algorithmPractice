package ltcd.greedyExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class _1626_无矛盾的最佳球队 {

    public static void main(String[] args) {
        _1626_无矛盾的最佳球队 v = new _1626_无矛盾的最佳球队();
        System.out.println(v.bestTeamScore(new int[]{4,5,6,5,7,7}, new int[]{2,1,2,1,3,2}));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int ans = 0;
        int[][] ageScore = new int[ages.length][2];

        // 组合成 (年龄， score)
        for (int i = 0; i < ages.length; i++) {
            ageScore[i] = new int[]{ages[i], scores[i]};
        }

        Arrays.sort(ageScore, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < ageScore.length; i++) {
            int minSore = ageScore[i][1];
            int tmp = 0;

            for (int j = i + 1; j < ageScore.length; j++) {
                // 如果年龄相同，直接相加
                if (ageScore[j][0] == ageScore[j - 1][0]) {
//                    tmp += a;
                }
            }
        }

        return ans;
    }

}
