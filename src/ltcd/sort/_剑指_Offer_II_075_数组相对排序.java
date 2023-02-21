package ltcd.sort;

public class _剑指_Offer_II_075_数组相对排序 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i = 0; i < arr1.length; i++) {
            max = Math.max(max, arr1[i]);
        }

        int[] cnt = new int[max + 1];
        //计数
        for (int i = 0; i < arr1.length; i++) {
            cnt[arr1[i]]++;
        }

        int[] ans = new int[arr1.length];
        int idx = 0;
        //按照arr2排序
        for (int i = 0; i < arr2.length; i++) {
            while (cnt[arr2[i]]-- > 0) {
                ans[idx++] = arr2[i];
            }
        }

        //对除了arr2中的剩余数据排序
        for (int i = 0; i < max + 1; i++) {
            while (cnt[i]-- > 0) {
                ans[idx++] = i;
            }
        }

        return ans;
    }
}
