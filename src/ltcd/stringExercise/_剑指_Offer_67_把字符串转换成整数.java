package ltcd.stringExercise;

public class _剑指_Offer_67_把字符串转换成整数 {

    public int strToInt(String str) {
        if (str.length() == 0 || str.equals("-") || str.equals("+") || str.equals(" ")) {
            return 0;
        }

        int left = 0;
        int right = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                left = i;
                right = i;
                for (int j = left + 1; j < str.length(); j++) {
                    if (chars[j] - '0' >= 0 && chars[j] - '0' <= 9) {
                        right = j;
                    } else {
                        break;
                    }
                }
                break;
            } else if (chars[i] == '-' && i + 1 < chars.length && (chars[i] - '0' < 0 || chars[i] - '0' > 9)){
                return 0;
            } else if (chars[i] == '+' && i + 1 < chars.length && (chars[i] - '0' < 0 || chars[i] - '0' > 9)){
                return 0;
            } else if (chars[i] != ' ' && chars[i] != '-' && chars[i] != '+'){
                return 0;
            }
        }

        if (left == right && (chars[left] - '0' < 0 || chars[left] - '0' > 9)) {
            return 0;
        }

        if (right - left + 1 >= 18) {
            if (left - 1 >= 0 && chars[left - 1] == '-') {
                if (chars[left] == '0') {
                    while (left < right && chars[left] == '0') {
                        left++;
                    }

                    if (left == right && chars[left] == '0') {
                        return 0;
                    } else if (right - left + 1 >= 18) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Long.parseLong(str.substring(left, right + 1)) < Integer.MIN_VALUE ? Integer.MIN_VALUE : -Integer.parseInt(str.substring(left, right + 1));
                    }
                }
            }

            if (chars[left] == '0') {
                while (left < right && chars[left] == '0') {
                    left++;
                }

                if (left == right && chars[left] == '0') {
                    return 0;
                } else if (right - left + 1 >= 18) {
                    return Integer.MAX_VALUE;
                } else {
                    return Long.parseLong(str.substring(left, right + 1)) > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.parseInt(str.substring(left, right + 1));
                }
            }
        }

        if (right - left + 1 >= 18) {
            if (left - 1 >= 0 && chars[left - 1] == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }

        left = left - 1 >= 0 && chars[left - 1] == '-' ? left - 1 : left;
        long l = Long.parseLong(str.substring(left, right + 1));

        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) l;
    }

}
