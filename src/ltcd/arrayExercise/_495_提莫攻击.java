package ltcd.arrayExercise;

public class _495_提莫攻击 {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {

        int preEnd = timeSeries[0] + duration;
        int ans = duration;

        for (int i = 1; i < timeSeries.length; i++) {
            if (preEnd < timeSeries[i]) {
                ans += duration;
            } else {
                ans +=  timeSeries[i] - preEnd;
            }
            preEnd = timeSeries[i] + duration;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
    }

}
