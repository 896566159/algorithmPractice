package ltcd.stringExercise;

import java.util.ArrayList;
import java.util.List;

public class _1408_数组中的字符串匹配 {

    public static void main(String[] args) {
        new _1408_数组中的字符串匹配().stringMatching(new String[]{"mass","as","hero","superhero"});
    }

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();

        for (String word : words) {
            for (int i = 0; i < words.length; i++) {
                if (word.length() >= words[i].length()) {
                    continue;
                }

                if (words[i].contains(word)) {
                    res.add(word);
                    break;
                }
            }
        }

        return res;
    }

}
