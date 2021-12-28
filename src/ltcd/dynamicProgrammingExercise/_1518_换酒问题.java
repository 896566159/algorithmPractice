package ltcd.dynamicProgrammingExercise;

public class _1518_换酒问题 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int a = numBottles / numExchange, b = numBottles % numExchange;
            ans += a;
            numBottles = a + b;
        }
        return ans;
    }

}
