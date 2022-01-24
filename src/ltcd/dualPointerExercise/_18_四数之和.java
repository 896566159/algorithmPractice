package ltcd.dualPointerExercise;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _18_四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 3) {
            return new LinkedList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            long sum = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];

            if ((sum > target) || (sum < target)) {
                break;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }

                path = new LinkedList<>();//重新开辟空间
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right ) {
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];

                    if (tmp == target) {
                        path.add(i);
                        path.add(j);
                        path.add(left);
                        path.add(right);
                        ans.add(path);

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;

                    } else if (tmp < target) {
                        left++;

                        while (left < right && nums[left] == nums[left + 1]) left++;
                    } else {
                        right--;

                        while (left < right && nums[left] == nums[left + 1]) right--;
                    }
                }

                while ( nums[j] == j + 1 && j < nums.length - 3) {
                    j++;
                }
            }

            while ( nums[i] == i + 1 && i < nums.length - 4) {
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new _18_四数之和().fourSum(new int[]{1,0,-1,0,-2,2}, 0);
    }
}
