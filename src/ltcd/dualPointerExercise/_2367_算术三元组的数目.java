package ltcd.dualPointerExercise;

public class _2367_算术三元组的数目 {

    public static void main(String[] args) {
        _2367_算术三元组的数目 v = new _2367_算术三元组的数目();
        System.out.println(v.arithmeticTriplets(new int[]{0,1,2}, 1));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        int length = nums.length;
        int max = nums[length - 1];

        for (int i = 0; i < length - 2; i++) {
            // 如果当前元素加上 两倍diff > max，则后面的数一定也不满足
            if (nums[i] + 2 * diff > max) {
                break;
            }

            // 从 [i + 1, length - 1]区间中找是否存在 nums[i] + diff
            int j = find(nums[i] + diff, i + 1, length - 1, nums);

            if (j == -1) {
                continue;
            }

            int k = find(nums[i] + 2 * diff, i + 1, length - 1, nums);

            if (j != -1 && k != -1) {
                ans++;
            }
        }

        return ans;
    }

    private int find(int target, int left, int right, int[] nums) {
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }

}
