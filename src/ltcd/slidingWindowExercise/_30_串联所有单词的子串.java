package ltcd.slidingWindowExercise;

import java.util.*;

public class _30_串联所有单词的子串 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        // 每个单词的长度， 总长度
        int oneWordLen = words[0].length();
        int wordsLen = oneWordLen * words.length;

        if (s.length() == 0 || words.length == 0 || s.length() < wordsLen) {
            return res;
        }

        for (String word: words) {
            // 主串s中没有这个单词，直接返回空
            if (s.indexOf(word) < 0) {
                return res;
            }
            // map中保存每个单词，和它出现的次数
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        // 只讨论从0，1，...， oneWordLen-1 开始的子串情况，
        // 每次进行匹配的窗口大小为 wordsLen，每次后移一个单词长度，由左右窗口维持当前窗口位置
        for (int i = 0; i < oneWordLen; i++) {
            // 左右窗口
            int left = i;
            int right = i;
            //统计匹配成功的单词数量
            int count = 0;

            // 统计每个符合要求的 word
            Map<String, Integer> window = new HashMap<>();
            // 开始滑动窗口，右窗口不能超出主串长度
            while (right + oneWordLen <= s.length()) {
                // 扫描到的当前单词
                String curWord = s.substring(right, right + oneWordLen);
                // 有窗口右移
                right += oneWordLen;

                // words[]中没有这个单词，那么当前窗口肯定匹配失败，直接右移到这个单词后面
                if (!wordsMap.containsKey(curWord)) {
                    left = right;
                    // 窗口内单词统计map清空，重新统计
                    window.clear();
                    // 符合要求的单词数清0
                    count = 0;
                } else {
                    // 更新窗口中这个单词出现的次数
                    window.put(curWord, window.getOrDefault(curWord, 0) + 1);
                    count++;
                    // 如果这个单词出现的次数大于words[]中它对应的次数，又由于每次匹配和words长度相等的子串
                    // 如 ["foo","bar","foo","the"]  "| foobarfoobar| foothe"
                    // 第二个bar虽然是words[]中的单词，但是words[]中的次数少于窗口中的次数，那么右移一个单词长度后 "foo|barfoobarfoo|the"
                    // bar还是不符合，所以直接从这个不符合的bar之后开始匹配，也就是将这个不符合的bar和它之前的单词(串)全移出去
                    while (window.getOrDefault(curWord, 0) > wordsMap.getOrDefault(curWord, 0)) {
                        // 从当前窗口字符统计map中删除从左窗口开始到数量超限的所有单词(次数减一)
                        String w = s.substring(left, left + oneWordLen);
                        window.put(w, window.getOrDefault(w, 0) - 1);
                        // 符合的单词数减一
                        --count;
                        // 左窗口位置右移
                        left += oneWordLen;
                    }

                    // 当前窗口字符串满足要求
                    if (count == words.length) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new _30_串联所有单词的子串().findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
    }

}
