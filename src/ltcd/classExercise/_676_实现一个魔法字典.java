package ltcd.classExercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _676_实现一个魔法字典 {

    Set<String> set = null;

    public _676_实现一个魔法字典() {
        set = new HashSet<>();
        set.add("hallo");
        set.add("hello");
        set.add("leetcode");
        set.add("judge");

//        ["hello"], ["hallo"], ["hell"], ["leetcodd"], [""]]
    }

    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            set.add(dictionary[i]);
        }
    }

    public boolean search(String searchWord) {
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();

            if (searchWord.length() == next.length()) {
                int count = 0;
                for (int i = 0; i < searchWord.length(); i++) {
                    if (searchWord.charAt(i) != next.charAt(i)) {
                        if (++count > 1) {
                            break;
                        }
                    }
                }

                if (count == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new _676_实现一个魔法字典().search("juage"));
    }

}
