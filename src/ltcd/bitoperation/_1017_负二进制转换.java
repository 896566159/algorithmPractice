package ltcd.bitoperation;

public class _1017_负二进制转换 {

    public static void main(String[] args) {
        _1017_负二进制转换 v = new _1017_负二进制转换();
        v.baseNeg2(3);
    }

    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }

        StringBuilder res = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            res.append(remainder);
            n -= remainder;
            n /= -2;
        }

        return res.reverse().toString();
    }

}
