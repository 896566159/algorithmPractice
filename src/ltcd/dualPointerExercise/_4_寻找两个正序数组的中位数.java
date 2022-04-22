package ltcd.dualPointerExercise;

public class _4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;
        int left = 0;
        int right = 0;
        int astart = 0;
        int bstart = 0;

        for (int i = 0; i < (len >> 1); i++) {
            left = right;

            if (astart < nums1.length && (bstart >= nums2.length || nums2[astart] < nums2[bstart])) {
                right = nums1[astart++];
            } else {
                right = nums2[bstart++];
            }
        }

        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public static void main(String[] args) {
        System.out.println(new _4_寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3}));
    }
}
