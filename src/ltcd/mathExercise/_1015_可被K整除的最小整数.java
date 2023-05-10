package ltcd.mathExercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1015_可被K整除的最小整数 {

    public static void main(String[] args) {
        new _1015_可被K整除的最小整数().smallestRepunitDivByK(3);
    }

    public int smallestRepunitDivByK(int k) {
        Set<Integer> set = new HashSet<>();
        int x = 1 % k;
        while (x > 0 && set.add(x)) {
            x = (x * 10 + 1) % k;
        }

        return x > 0 ? -1 : set.size() + 1;
    }

}
