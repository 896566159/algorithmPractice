package ltcd.binarySearchExercise;

public class _69_Sqrt_x {

    public int mySqrt(int x) {
        if (x <= 1) return x;

        int left = 1;
        int right = x - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                if (mid + 1 > x / (mid + 1)) return mid;
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
