package ltcd.stringExercise;

public class _2047_句子中的有效单词数 {

    public int countValidWords(String sentence) {
        int ans = 0;

        String[] words = sentence.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            boolean flag = false;
            int count = 0;

            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) >= 48 && words[i].charAt(j) <= 57) {
                    flag = false;
                    break;
                }
                if ((words[i].charAt(j) == ',' || words[i].charAt(j) == '!') && j != words[i].length() - 1 ) {
                    flag = false;
                    break;
                }
                if (words[i].charAt(j) == '-' && (j == 0 || j == words[i].length() - 1)){
                    flag = false;
                    break;
                }
                if (words[i].charAt(j) == '-' && !(words[i].charAt(j - 1) >= 97 && words[i].charAt(j - 1) <= 122
                        && words[i].charAt(j + 1) >= 97 && words[i].charAt(j + 1) <= 122)){
                    flag = false;
                    break;
                }

                if (words[i].charAt(j) == '-') {
                    if (count++ > 1) {
                        flag = false;
                        break;
                    }
                }
                flag = true;
            }

            if (flag) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _2047_句子中的有效单词数().countValidWords("a-.f"));
    }

}
