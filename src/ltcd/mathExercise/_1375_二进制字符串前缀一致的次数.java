package ltcd.mathExercise;

public class _1375_二进制字符串前缀一致的次数 {

    public static void main(String[] args) {
        _1375_二进制字符串前缀一致的次数 v = new _1375_二进制字符串前缀一致的次数();
        System.out.println(v.numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
//        System.out.println(v.numTimesAllBlue(new int[]{4,1,2,3}));
    }

    public int numTimesAllBlue(int[] flips) {
        int ans = 0, mx = 0, n = flips.length;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, flips[i]);
            if (mx == i + 1) {
                ans++;
            }
        }
        return ans;
    }

}
