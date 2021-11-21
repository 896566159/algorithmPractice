package ltcd.arrayExercise;

import java.util.Arrays;

public class _594_最长和谐子序列 {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int same = 1;
            if (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                int j = i;

                while (j < nums.length) {
                    if (j + 1 < nums.length) {
                        if (nums[j] != nums[j + 1]) {
                            break;
                        } else {
                            same++;
                        }
                    }
                    j++;
                }
            }

            if (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                int j = i + 1;
                int count = same + 1;
                while (j < nums.length) {
                    if (j + 1 < nums.length) {
                        if (nums[j] != nums[j + 1]) {
                            ans = count > ans ? count : ans;
                            break;
                        } else {
                            count++;
                        }
                    }
                    j++;
                }
            }

            i = i + same;
        }

        return ans;
    }

    public static void main(String[] args) {
        _594_最长和谐子序列 v = new _594_最长和谐子序列();
        v.findLHS(new int[]{1,3,2,2,5,2,3,7});
    }

}
