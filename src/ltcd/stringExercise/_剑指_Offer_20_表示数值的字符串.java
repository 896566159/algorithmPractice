package ltcd.stringExercise;

public class _剑指_Offer_20_表示数值的字符串 {

    public boolean isNumber(String s) {

        String trim = s.trim();
        boolean num = false;
        int length = trim.length();
        int start = 0;
        int pointCount = 0;//小数点的个数
        int countPositiveNegative = 0;//由于正负号
        boolean e = false;

        //字符串为空
        //结尾是 ‘e'或者’E‘
        //字符串 = “-”或者“+”
        if (trim.length() == 0
                || trim.charAt(trim.length() - 1) == 'E'
                || trim.charAt(trim.length() - 1) == 'e'
                || trim.charAt(trim.length() - 1) == '+'
                || trim.charAt(trim.length() - 1) == '-'
                || trim.equals("-")
                || trim.equals("+")
                || trim.equals(".")
                || trim.charAt(0) == 'e'
                || trim.charAt(0) == 'E') {
            return false;
        }

        //如果一开始有两个正负号
        if (trim.charAt(0) == '+' || trim.charAt(0) == '-') {
            if (trim.charAt(1) == '+' || trim.charAt(1) == '-') {
                return false;
            }
            start = 1;//不管符号，直接找下一个数字
        }

        //如果一开始有 是小数点
        if (trim.charAt(0) == '.') {
            //如果第二个不是数字，直接返回false
            if (1 < trim.length() && (trim.charAt(1) - '0' < 0 || trim.charAt(1) - '9' > 0)) {
                return false;
            }
            pointCount++;
            start = 1;//不管符号，直接找下一个数字
        }

        for (int i = start; i < length; i++) {

            //如果是非数字
            if (trim.charAt(i) - '0' < 0 || trim.charAt(i) - '9' > 0) {
                if (trim.charAt(i) == '.') {
                    if (++pointCount > 1 || e) {//只能有一个小数点, 如果前面已经出现了e,不能够有小数点
                        return false;
                    }
                    continue;
                } else if (trim.charAt(i) == 'e' || trim.charAt(i) == 'E') {//如果是e,后面不能够再有小数点、也不能再有e
                    if (e) {//如果已经有e了，直接返回false
                        return false;
                    }

                    if (!num) {//如果e前面没有数字，则不合法
                        return false;
                    }

                    e = true;

                    //6e-12  这个串是合法的
                    if (i + 1 < trim.length() && (trim.charAt(1 + i) == '+' || trim.charAt(1 + i) == '-')) {
                        i++;
                        continue;
                    }
                } else {
                    //字母，返回false
                    return false;
                }
            } else {//数字
                num = true;
            }
        }

        return num;
    }

}
