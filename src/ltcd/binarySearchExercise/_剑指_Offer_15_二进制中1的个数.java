package ltcd.binarySearchExercise;

public class _剑指_Offer_15_二进制中1的个数 {

    public int hammingWeight(int n) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans += ((n >> i) & 1);
        }

        return Integer.bitCount(n);
//        return ans;
    }

}
