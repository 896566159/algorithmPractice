package ltcd.bitOperation;

public class _67_二进制求和 {

    public String addBinary(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return a.length() == 0 ? b : a;
        }

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int lenA = charsA.length;
        int lenB = charsB.length;
        StringBuffer sb = new StringBuffer();
        int pre = 0;

        while (lenB != 0 && lenA != 0) {
            int cur = (charsA[--lenA] - '0') + (charsB[--lenB] - '0') + pre;
            pre = (int) (cur / 2);
            sb.append(cur % 2);
        }

        while (lenA != 0) {
            int cur = (charsA[--lenA] - '0') + pre;
            pre = cur / 2;
            sb.append(cur % 2);
        }

        while (lenB != 0) {
            int cur = (charsB[--lenB] - '0') + pre;
            pre = cur / 2;
            sb.append(cur % 2);
        }

        if (pre != 0) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

}
