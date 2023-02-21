package ltcd.binarySearchExercise;

public class _367_有效的完全平方数 {

    public static void main(String[] args) {
        isPerfectSquare(2147395600);
    }

    public static boolean isPerfectSquare(int num) {

        // long left = 0;
        // long right = num;


        // while (left < right) {
        //     long mid = (left + right + 1) >> 1;

        //     if (mid * mid <= num) {
        //         left = mid;
        //     } else {
        //         right = mid - 1;
        //     }

        // }

        // return  right * right == num;

        //原理:(n+1)^2-n^2=2n+1
        // 4=1+3 9=1+3+5 16=1+3+5+7以此类推，模仿它可以使用一个while循环，不断减去一个从1开始不断增大的奇数，若最终减成了0，说明是完全平方数，否则，不是。
        int start = 1;
        while (num > 0) {
            num -= start;
            start += 2;
        }

        return num == 0;
    }

}
