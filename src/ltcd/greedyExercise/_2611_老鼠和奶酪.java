package ltcd.greedyExercise;

import java.util.Arrays;

public class _2611_老鼠和奶酪 {

    public static void main(String[] args) {
        _2611_老鼠和奶酪 v = new _2611_老鼠和奶酪();
        System.out.println(v.miceAndCheese(new int[]{1,4,4,6,4}, new int[]{6,5,3,6,1}, 1));
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int length = reward1.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            // 第二只老鼠先吃完
            res += reward2[i];
            // 计算差值——比较相同 i 位置上，两只老鼠能够吃到的数量
            reward1[i] -= reward2[i];
        }

        Arrays.sort(reward1);
        for (int i = length - k; i < length; i++) {
            // 加上差值。
            res += reward1[i];
        }

        return res;
    }

}
