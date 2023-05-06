package ltcd.mathExercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _970_强整数 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        int tmpX = 1;
        int tmpY = 1;

        for (int i = 0; tmpX + tmpY <= bound; i++) {

            for (int j = 0; tmpX + tmpY <= bound; j++) {
                set.add(tmpX + tmpY);
                tmpY *= y;

                if (tmpY == 1) {
                    break;
                }
            }

            tmpY = 1;
            tmpX *= x;
            if (tmpX == 1) {
                break;
            }
        }

        return new ArrayList<>(set);
    }

}
