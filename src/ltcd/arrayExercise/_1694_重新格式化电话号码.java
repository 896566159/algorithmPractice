package ltcd.arrayExercise;

public class _1694_重新格式化电话号码 {

    public static String reformatNumber(String number) {
        int index = 0;
        StringBuffer sb = new StringBuffer();
        char[] chars = number.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || chars[i] == '-') {
                continue;
            }
            sb.append(chars[i]);
            if (index++ == 2) {
                sb.append('-');
                index = 0;
            }
        }

        if (sb.charAt(sb.length() - 2) == '-') {
            sb.replace(sb.length() - 2, sb.length() - 1, String.valueOf(sb.charAt(sb.length() - 3)));
            sb.replace(sb.length() - 3, sb.length() - 2, "-");
        }
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.replace(sb.length() - 1, sb.length(), "");
        }

        return sb.toString();
    }

}
