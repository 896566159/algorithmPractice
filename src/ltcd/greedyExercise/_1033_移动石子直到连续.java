package ltcd.greedyExercise;

public class _1033_移动石子直到连续 {

    public static void main(String[] args) {
        _1033_移动石子直到连续 v = new _1033_移动石子直到连续();
        System.out.println(v.numMovesStones(3, 5, 1));
    }

    public int[] numMovesStones(int a, int b, int c) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        max = Math.max(max, c);
        min = Math.min(min, c);

        if (max == min + 2) {
            return new int[] {0, 0};
        }

        int mid = a + b + c - max - min;
        int step = 0;
        int[] ans = new int[2];

        // 移动到 mid 需要的最多步骤
        step += mid - min - 1;
        step += max - mid - 1;
        ans[1] = step;
        step = 0;

        // 移动到 mid 需要的最少步骤
        if (mid - min == 2 || max - mid == 2) {
            ans[0] = 1;
        } else {
            step += mid == min + 1 ? 0 : 1;
            step += max == mid + 1 ? 0 : 1;
            ans[0] = step;
        }

        return ans;
    }

}
