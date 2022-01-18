package ltcd.dynamicProgrammingExercise;

public class _剑指_Offer_II_003_前n个数字二进制中1的个数 {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for (int i = 0; i <= n; i++) {
            ans[i] = i % 2 == 0 ? ans[i >> 1] : ans[i - 1] + 1;
        }

        return ans;
    }

}
