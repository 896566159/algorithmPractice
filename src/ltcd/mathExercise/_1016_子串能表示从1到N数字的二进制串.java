package ltcd.mathExercise;

public class _1016_子串能表示从1到N数字的二进制串 {

    public static void main(String[] args) {
//        System.out.println(new _1016_子串能表示从1到N数字的二进制串().queryString("0000010001000111101110001111001001011000011111110001010100101000011110100001101011000001110110001101110101010110001111001110001010010001111000001101000100001111011000110111101101011100111101101000100001010010011111101101011001001001100101100110000010101010100100011001101011001000100100001010110010111000001011000101010110010010110001100110011111110011000111000110001110111110101001100011101111000010110100011101001011101000100010100000101011001100100101101100110011000110010000110100001111111001000010010110010011010111000000000110010010000101001000010100011110111001000111000001000000001001110100100000001110000011101010011101001100110000111101000110000110000000011101010101011110100011100100100010", 35));
        System.out.println(new _1016_子串能表示从1到N数字的二进制串().queryString("10010111100001110010", 10));
    }

    public boolean queryString(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);

        int i = 1;
        while (i <= n) {
            int length = sb.length() - 1;

            while (length >= 0) {
                char c = sb.charAt(length);
                if (c == '0') {
                    sb.setCharAt(length, '1');
                    break;
                } else {
                    sb.setCharAt(length, '0');
                }
                length--;
            }

            if (length < 0) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(1);
                tmp.append(sb);
                sb = tmp;
            }

            System.out.println(sb.toString());
            if (!s.contains(sb)) {
                return false;
            }
            i++;
        }

        return true;
    }

}
