package ltcd.stringExercise;

public class _面试题_0103_URL化 {

    public String replaceSpaces(String S, int length) {
        // 边界条件
        if(S == null || S.length() == 0) {
            return S;
        }

        // 双指针位置
        int preIndex = length - 1;
        int lastIndex = preIndex;
        char[] str = S.toCharArray();
        for(int i=0; i < length; i++) {
            if(str[i] == ' ') {
                lastIndex +=2;
            }
        }

        // 替换字符串
        while(lastIndex != preIndex) {
            if(str[preIndex] != ' ') {
                // 复制
                str[lastIndex] = str[preIndex];
                lastIndex--;
                preIndex--;
            } else {
                // 替换 0 2 % ; pre-1; last - 3
                str[lastIndex --] = '0';
                str[lastIndex --] = '2';
                str[lastIndex --] = '%';
                preIndex --;
            }
        }

        return String.valueOf(str).trim();
    }

}
