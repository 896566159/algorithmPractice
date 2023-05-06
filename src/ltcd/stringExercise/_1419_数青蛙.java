package ltcd.stringExercise;

public class _1419_数青蛙 {

    public static void main(String[] args) {
        _1419_数青蛙 v = new _1419_数青蛙();
        System.out.println(v.minNumberOfFrogs("crcoakroak"));
//        System.out.println(v.minNumberOfFrogs("ccrrooaakk"));
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs == null || croakOfFrogs.length() == 0
                || croakOfFrogs.charAt(croakOfFrogs.length() - 1) != 'k'
                || croakOfFrogs.charAt(0) != 'c') {
            return -1;
        }

        int ans = 0;
        char[] chars = croakOfFrogs.toCharArray();
        int[] arr = new int[4];
        int length = chars.length;
        char preChar = chars[0];

        for (int i = 0; i < length; i++) {
            char curChar = chars[i];
            if (curChar == 'k') {

                int max = 0;
                for (int j = 0; j <= 3; j++) {
                    if (--arr[j] < 0) {
                        return -1;
                    }
                    max = Math.max(max, arr[j]);
                }

                // 成功匹配一次 croak，青蛙数量至少是 1，还需要至少 (c、r、o、a 的最大的那个数量) 的青蛙才能同时发出 croak
                if (ans <= max) {
                    ans = max + 1;
                }

                // 如果最大值不是第一个字母，说明顺序有问题
                if (max != arr[0]) {
                    return -1;
                }

            } else {
                switch (curChar) {
                    case 'c':
                        arr[0]++;
                        break;
                    case 'r':
                        arr[1]++;
                        if (arr[1] > arr[0]) {
                            return -1;
                        }
                        break;
                    case 'o':
                        arr[2]++;
                        if (arr[2] > arr[1]) {
                            return -1;
                        }
                        break;
                    case 'a':
                        arr[3]++;
                        if (arr[3] > arr[2]) {
                            return -1;
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        // 最后还有未匹配的字符
        for (int j = 0; j < 3; j++) {
            if (arr[j] != 0) {
                return -1;
            }
        }

        return ans;
    }

}
