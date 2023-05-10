package ltcd.arrayExercise.matrixExercise;

import java.util.ArrayList;
import java.util.List;

public class _119_杨辉三角II {
    public static void main(String[] args) {
        new _119_杨辉三角II().getRow(3);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        if (rowIndex == 0) {
            res.add(1);
            return res;
        } else if (rowIndex == 1) {
            res.add(1);
            res.add(1);
            return res;
        }

        tmp.add(1);
        tmp.add(1);
        for (int i = 3; i <= rowIndex + 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            for (int j = 1; j < tmp.size(); j++) {
                list.add(tmp.get(j - 1) + tmp.get(j));
            }

            list.add(1);
            res = new ArrayList<>(list);
            tmp = list;
        }

        return res;
    }

}
