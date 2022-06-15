package ltcd.slidingWindowExercise;

public class _904_水果成篮 {

    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }

        int left = 0;
        int right = 0;
        int ans = 0;
        int length = fruits.length;
        int fruitA = fruits[0];//第一类水果
        int fruitB = fruits[0];//第二类水果

        while (right < length) {
            int fruit = fruits[right];

            //水果中类少于 2
            if (fruitA == fruitB) {
                fruitB = fruit;//将 fruitB 类水果覆盖为当前遍历到的水果 fruit ——为了满足两种水果的要求
                ans = Math.max(ans, right - left + 1);//更新能够采摘果树的最大数量
                right++;//窗口右移
                continue;
            }

            //已经有两种水果被采集了,且当前 水果类别fruit 与遍历过的水果筐中的水果fruitA、fruitB不一致
            if (fruitA != fruit && fruitB != fruit) {
                left = right - 1;
                //找到 水果fruitA、fruitB中，离当前最近的一类水果
                while (left - 1 >= 0 && fruits[left - 1] == fruits[left]) {
                    left--;
                }
                fruitA = fruits[left];//将离当前最近的一类水果作为 fruitA
                fruitB = fruit;//更新 fruitB 水果为当前遍历到的水果 fruit
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }

}
