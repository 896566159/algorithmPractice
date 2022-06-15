package ltcd.backtrackingExecise;

import java.util.Arrays;

public class _473_火柴拼正方形 {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;
        int max = 0;
        for (int num: matchsticks) {
            sum += num;
            max = num > max ? num : max;
        }

        Arrays.sort(matchsticks);

        if (sum == 0 || (sum & 3) != 0 || (max > sum >> 2)) {
            return false;
        }

        return backtracke(matchsticks, matchsticks.length - 1, sum >> 2, new int[4]);
    }

    /**
     * 回溯
     * @param matchsticks 火柴数组
     * @param index 访问元素的下标
     * @param target 正方形的边长
     * @param size 张方形四边的长度
     * @return
     */
    private boolean backtracke(int[] matchsticks, int index, int target, int[] size) {
        if (index == -1) {
            if (size[0] == size[1] && size[0] == size[2] && size[0] == size[3]) {
                return true;
            }
            return false;
        }

        //到这一步说明火柴还没有被用完
        for (int i = 0; i < size.length; i++) {
            //如果把当前火柴放到size[i]这个边上，他的长度大于target，我们直接跳过
            if (size[i] + matchsticks[index] > target) {
                continue;
            }

            //如果把当前火柴放到size[i]这个边上，他的长度大于target，我们直接跳过。或者
            // size[i] == size[i - 1]即上一个分支的值和当前分支的一样，上一个分支没有成功，
            //说明这个分支也不会成功，直接跳过即可。
            if (size[i] + matchsticks[index] > target || (i > 0 && size[i] == size[i - 1]) || (index == matchsticks.length - 1 && i != 0)) {
                continue;
            }

            //然后在放下一个火柴，如果最终能变成正方形，直接返回true
            if ( backtracke(matchsticks, index - 1, target, size) ) {
                return true;
            }

            //如果当前火柴放到size[i]这个边上，最终不能构成正方形，我们就把他从
            //size[i]这个边上给移除，然后在试其他的边
            size[i] -= matchsticks[index];
        }

        //如果不能构成正方形
        return false;
    }


}
