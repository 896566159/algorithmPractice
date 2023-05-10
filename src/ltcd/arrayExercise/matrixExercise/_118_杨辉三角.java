package ltcd.arrayExercise.matrixExercise;

import java.util.ArrayList;
import java.util.List;

public class _118_杨辉三角 {

    public List<List<Integer>> generate(int numRows) {
        int start = 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(new ArrayList<>(tmp));

        if (numRows == 1) {
            return res;
        }

        tmp.add(1);
        res.add(new ArrayList<>(tmp));
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int mid = i >> 1;
            int size = tmp.size();
            for (int j = 1; j < size; j++) {
                list.add(tmp.get(j - 1) + tmp.get(j));
            }
            list.add(1);

            tmp = new ArrayList<>(list);
            res.add(list);
        }

        return res;
    }

}
