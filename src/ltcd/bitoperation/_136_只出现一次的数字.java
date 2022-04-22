package ltcd.bitOperation;

public class _136_只出现一次的数字 {

    //异或： ^
    //异或操作： a ^ a = 0
    //异或满足交换律： a ^ b ^ c = a ^ c ^ b ==> b = a ^ b ^ a = (a ^ a) ^ b
    public int singleNumber(int[] nums) {
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

}
