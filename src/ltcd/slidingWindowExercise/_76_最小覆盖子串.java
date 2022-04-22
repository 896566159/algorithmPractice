package ltcd.slidingWindowExercise;

import java.util.HashMap;
import java.util.Map;

public class _76_最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println(new _76_最小覆盖子串().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        //统计词频
        Map<Character, Integer> tfreq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tfreq.put(t.charAt(i), tfreq.getOrDefault(t.charAt(i), 0) + 1);
        }

        //记录滑动窗口中的词频
        Map<Character, Integer> window = new HashMap<>();
        //记录当前窗口中有多少个字符相匹配
        int success = 0;
        //记录最小覆盖串的起始位置和长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        //初始化滑动窗口（左闭右开）
        int left = 0;
        int right = 0;

        //开始滑动窗口
        while (right < s.length()) {
            //当前扫描到的字符
            char c = s.charAt(right);
            if (tfreq.containsKey(c)) {
                //将s.charAt(right)加入窗口
                window.put(c, window.getOrDefault(c, 0) + 1);
                //判断窗口中字符 c 的数量是否达到 t 串中的数量
                if (tfreq.get(c).equals(window.get(c))) {
                    success++;
                }
            }

            //扩大窗口
            right++;

            //判断窗口是否涵盖了 t 中所有字符
            while (success == tfreq.size()) {
                //更新结果
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                //缩小窗口范围
                char d = s.charAt(left);
                if (tfreq.containsKey(d)) {
                    if (window.get(d).equals(tfreq.get(d))) {
                        success--;
                    }
                    window.put(d, window.get(d) - 1);
                }

                //缩小窗口左边界
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public String minWindow1(String s, String t) {
        int left = 0;
        int right = 0;
        int valid = 0;
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        String res = "";
        int len = Integer.MAX_VALUE;
        int start = 0;

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.containsKey(t.charAt(i)) ? need.get(t.charAt(i)) + 1 : 1);
        }

        while (right < s.length()) {
            //将要移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //对窗口进行实际的业务操作(一般是将字符加入窗口）
            if (need.containsKey(c)) {
                windows.put(c, windows.containsKey(c) ? windows.get(c) + 1 : 1);//字符右移进窗口
                if (windows.get(c) == need.get(c)) {
                    valid++;
                }
            }

            //判断左侧窗口是否需要收缩
            while (valid == need.size()) {
                //更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //d是将要移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;
                //进行窗口内数据的一系列更新
                if (need.get(d) > 0) {
                    if (windows.get(d) == need.get(d)) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, len);
    }

}
