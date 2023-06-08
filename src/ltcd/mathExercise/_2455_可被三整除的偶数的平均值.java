package ltcd.mathExercise;

public class _2455_可被三整除的偶数的平均值 {

    public static void main(String[] args) {
        _2455_可被三整除的偶数的平均值 v = new _2455_可被三整除的偶数的平均值();
        v.averageValue(new int[] {4,4,9,10});
    }

    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                sum += num;
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

}
