package ltcd.dualPointerExercise;

import java.util.*;

/**
 * 第二个方法是自己写的，有问题
 */
public class _18_四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
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
