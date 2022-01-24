package ltcd.depthFirstSearchExercise;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        int right = nums.length - 1;
        int left = 1;
        int index = 0;

        Arrays.sort(nums);
        if ((nums[0] < 0 && nums[right] < 0) || (nums[0] > 0 && nums[right] > 0)) {
            return new LinkedList<>();
        }

        while (index < left) {
            left = index + 1;
            right = nums.length - 1;
            path = new LinkedList<>();
            path.add(index);

            if ((nums[index] < 0 && nums[right] < 0) || (nums[index] > 0 && nums[right] > 0)) {
                break;
            }

            while (left < right - 1) {
                if (nums[left] + nums[right] + nums[index] == 0) {
                    path.add(left);
                    path.add(right);
                    break;
                } else if (nums[left] + nums[right] + nums[index] > 0){
                    right--;
                } else {
                    left++;
                }
            }

            while (index < nums.length && nums[index] == nums[index + 1]) {
                index++;
            }

        }

        return ans;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, 0, path, res, used);

        return res;
    }

    private void dfs(int[] nums, int begin, int sum, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (path.size() == 3) {
            if (sum == 0) {
                res.add(new LinkedList<>(path));
            }
            return;
        }

        if (path.size() > 3) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.offerLast(nums[i]);
            used[i] = true;
            dfs(nums, i + 1, sum + nums[i], path, res, used);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        new _15_三数之和().threeSum(new int[]{-1, 0, 1, -1});
    }

}
