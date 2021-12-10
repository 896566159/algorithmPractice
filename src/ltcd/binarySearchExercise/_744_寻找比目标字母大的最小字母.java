package ltcd.binarySearchExercise;

public class _744_寻找比目标字母大的最小字母 {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) >> 1;

            if (letters[mid] > target) {
                right = mid - 1;
            } else if (letters[mid] < target) {
                left = mid + 1;
            } else if (letters[left] < target && letters[right] > target){
                return letters[right];
            }
        }

        return ' ';
    }

}
