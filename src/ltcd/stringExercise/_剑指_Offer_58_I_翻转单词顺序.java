package ltcd.stringExercise;

public class _剑指_Offer_58_I_翻转单词顺序 {

    public String reverseWords(String s) {

        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();

        // 搜索首个空格
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // 添加单词
            res.append(s.substring(i + 1, j + 1) + " ");

            // 跳过单词间空格
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // j 指向下个单词的尾字符
            j = i;
        }

        // 转化为字符串并返回
        return res.toString().trim();
    }

}
