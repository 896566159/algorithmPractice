package ltcd.slidingWindowExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class _1031_两个非重叠子数组的最大和 {

    public static void main(String[] args) {
        _1031_两个非重叠子数组的最大和 v = new _1031_两个非重叠子数组的最大和();
        System.out.println(v.maxSumTwoNoOverlap(new int[]{1,0,3}, 1, 2));
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int left = 0;
        int right = 0;
        int length = nums.length;
        int sum = 0;
        int[][] firstMap = new int[length][2];
        int[][] secondMap = new int[length][2];

        while (right - left < firstLen) {
            sum += nums[right];
            right++;
        }

        firstMap[left][0] = sum;
        firstMap[left][1] = left;
        while (right < length) {
            sum = sum - nums[left] + nums[right];
            right++;
            left++;
            firstMap[left][0] = sum;
            firstMap[left][1] = left;
        }

        left = 0;
        right = 0;
        sum = 0;
        while (right - left < secondLen) {
            sum += nums[right];
            right++;
        }

        secondMap[left][0] = sum;
        secondMap[left][1] = left;
        while (right < length) {
            sum = sum - nums[left] + nums[right];
            right++;
            left++;
            secondMap[left][0] = sum;
            secondMap[left][1] = left;
        }

        // 排序
        Arrays.sort(firstMap, (a, b)->{
            return Integer.compare(b[0], a[0]);
        });

        Arrays.sort(secondMap, (a, b)->{
            return a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]);
        });


        int max = 0;
//        for (int i = 0; i < length; i++) {
//
//            for (int j = 0; j < length; j++) {
//
//                if (firstMap[i][1] + firstLen <= secondMap[j][1]
//                        || secondMap[j][1] + secondLen <= firstMap[i][1]) {
//                    max = Math.max(firstMap[i][0] + secondMap[j][0], max);
//                }
//            }
//        }

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length; j++) {
                if (firstMap[i][1] + firstLen <= secondMap[j][1]) {
                    max = Math.max(firstMap[i][0] + secondMap[j][0], max);
                    break;
                }
            }
        }

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length; j++) {
                if (secondMap[j][1] + secondLen <= firstMap[i][1]) {
                    max = Math.max(firstMap[i][0] + secondMap[j][0], max);
                    break;
                }
            }
        }

        return max;
    }

}
