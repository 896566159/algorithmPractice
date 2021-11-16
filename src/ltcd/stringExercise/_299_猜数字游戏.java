package ltcd.stringExercise;

public class _299_猜数字游戏 {

//    public String getHint(String secret, String guess) {
//        if(secret == null || guess == null || secret.length() == 0 || guess.length() == 0 || secret.length() != guess.length()) {
//            return "";
//        }
//
//        int A = 0, B = 0, index = 0;
//        char[] charsA = secret.toCharArray();
//        char[] charsB = guess.toCharArray();
//        char[] charsC = new char[charsA.length];
//
//
//        for (int i = 0; i < charsA.length; i++) {
//            if (secret.charAt(i) == guess.charAt(i)){
//                A++;
//                secret.charAt(i) = '*';
//                guess.charAt(i) = '#';
//            } else {
//                charsC[index++] = secret.charAt(i);
//            }
//        }
//
//        for (int i = 0; i < index; i++) {
//            for (int j = 0; j < charsB.length; j++) {
//                if (charsC[i] == charsB[j]) {
//                    B++;
//                    break;
//                }
//            }
//        }
//
//        return A + "A" + B + "B";
//    }
//
////    字符串直接使用加号连接的效率比使用StringBuffer对象的append效率低
//    public String getHint1(String secret, String guess) {
//        if(secret == null || guess == null || secret.length() == 0 || guess.length() == 0 || secret.length() != guess.length()) {
//            return "";
//        }
//
//        int A = 0, B = 0;
//        char[] charsA = secret.toCharArray();
//        char[] charsB = guess.toCharArray();
//
//        for (int i = 0; i < charsA.length; i++) {
//            if (secret.charAt(i) == guess.charAt(i)){
//                A++;
//                secret.charAt(i) = '*';
//                guess.charAt(i) = '#';
//            }
//        }
//
//        for (int i = 0; i < charsA.length; i++) {
//            for (int j = 0; j < charsB.length; j++) {
//                if (secret.charAt(i) == charsB[j]) {
//                    B++;
//                    charsB[j] = '@';
//                    break;
//                }
//            }
//        }

//        return new StringBuffer().append(A).append("A").append(B).append("B").toString();
//    }

    public static String getHint2(String secret, String guess) {
        if(secret == null || guess == null || secret.length() == 0 || guess.length() == 0 || secret.length() != guess.length()) {
            return "";
        }

        int A = 0, B = 0;
        char[] charsA = secret.toCharArray();
        char[] charsB = guess.toCharArray();
        int[] count = new int[10];

        for (int i = 0; i < charsA.length; i++) {
            if (secret.charAt(i) == guess.charAt(i)){
                A++;
            } else {
                count[secret.charAt(i) - '0'] ++;
                count[guess.charAt(i) - '0'] --;

                if(count[guess.charAt(i) - '0'] > 0){
                    B++;
                    count[guess.charAt(i) - '0']--;
                }
                if(count[secret.charAt(i) - '0'] < 0){
                    B++;
                    count[secret.charAt(i) - '0'] ++;
                }
            }
        }

        return new StringBuffer().append(A).append("A").append(B).append("B").toString();
    }

    public static String getHint3(String secret, String guess) {
        int A = 0, B = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)){
                A++;
            } else {
                count[secret.charAt(i) - '0'] ++;
                count[guess.charAt(i) - '0'] --;

                if(count[guess.charAt(i) - '0'] > 0){
                    B++;
                    count[guess.charAt(i) - '0']--;
                }
                if(count[secret.charAt(i) - '0'] < 0){
                    B++;
                    count[secret.charAt(i) - '0'] ++;
                }
            }
        }

        return new StringBuffer().append(A).append("A").append(B).append("B").toString();
    }


    public static void main(String[] args) {
        System.out.println(getHint2("2962","7236"));
    }
}
