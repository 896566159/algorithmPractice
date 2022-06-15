package ltcd.binarySearchExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _378_有序矩阵中第_K_小的元素 {

    public static void main(String[] args) {
        System.out.println(new _378_有序矩阵中第_K_小的元素().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0];
        int right = matrix[len - 1][len - 1];

        while (left < right) {

            int mid = (left + right) >> 1;
            // 找二维矩阵中 <= mid 的元素总个数
            int count = countLessEquals(matrix, mid);

            if (count < k) {
                //如果小于等于 mid 的个数 小于 k 个，说明目标数在 右半部分，且不包含mid
                //下次搜多范围：【mid + 1, right】
                left = mid + 1;
            } else {
                //如果小于等于 mid 的个数 大于等于 k 个，说明目标数在 右半部分，且可能包含 mid
                //下次搜多范围：【left, mid】
                right = mid;
            }
        }

        return left;
    }

    /**
     * 计算 matrix 中小于等于 mid 的个数
     * @param matrix
     * @param threshold
     * @return
     */
    private int countLessEquals(int[][] matrix, int threshold) {
        int rows = matrix.length;
        int cols = rows;
        int count = 0;

        //一行一行的找到小于等于 threshold 的个数
        for (int i = 0; i < rows; i++) {

            //二分找出 <= threshold 的最大的那个数
            int left = 0;
            int right = cols - 1;

            while (left <= right) {
                int midIndex = (left + right) >> 1;

                if (matrix[i][midIndex] > threshold) {
                    right = midIndex - 1;
                } else {
                    left = midIndex + 1;
                }
            }

            count += left;

        }
        
        return count;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int length = matrix.length;
        Integer[] help = new Integer[length * length];

        int index = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                help[index] = matrix[i][j];
                index++;
            }
        }

        Arrays.sort(help);
        return help[k - 1];
    }

}
