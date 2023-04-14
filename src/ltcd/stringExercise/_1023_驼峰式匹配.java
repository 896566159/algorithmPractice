package ltcd.stringExercise;

import dataStructure.list.ArrayList;
import dataStructure.list.List;

public class _1023_驼峰式匹配 {
    public static void main(String[] args) {
        _1023_驼峰式匹配 v = new _1023_驼峰式匹配();
        v.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB");
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        char[] par = pattern.toCharArray();
        int length = par.length;

        for (String query : queries) {
            char[] chars = query.toCharArray();
            int point = 0;

            for (int i = 0; i < chars.length; i++) {
                if (point < length && chars[i] == par[point]) {
                    point++;
                } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    point = -1;
                    break;
                }
            }

            ans.add(point == length);
        }

        return ans;
    }

}
