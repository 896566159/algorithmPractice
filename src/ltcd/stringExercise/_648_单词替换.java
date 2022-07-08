package ltcd.stringExercise;

import java.util.*;

public class _648_单词替换 {

    public String replaceWords(List<String> dictionary, String sentence) {
        TreeSet<String> strings = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int n1 = o1.length() - o2.length();
                int n2 = o1.compareTo(o2);
                return n1 == 0 ? n2 : n1;
            }
        });

        for (int i = 0; i < dictionary.size(); i++) {
            strings.add(dictionary.get(i));
        }

        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {

            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if (split[i].startsWith(next)) {
                    split[i] = next;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                sb.append(split[i]);
            } else {
                sb.append(" ").append(split[i]);
            }
        }

        return String.join(" ", split);
    }

}
