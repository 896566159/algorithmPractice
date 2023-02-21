package ltcd.arrayExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _1139_最大的以_1_为边界的正方形 {

    public static int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int withOne = 0;
        List<EgdeAndPoint> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果该点等于 1，则看着点的横线和竖向最断的连续 1 有多长
                if (grid[i][j] == 1) {
                    withOne = 1;
                    int maxR = 1;
                    int maxC = 1;

                    //看横向的
                    for (int k = j + 1; k < n && grid[i][k] == 1; k++) {
                        maxR++;
                    }

                    //看纵向的
                    for (int k = i + 1; k < m && grid[k][j] == 1; k++) {
                        maxC++;
                    }

                    //连续最长 = min{横向， 纵向}
                    int max = maxC > maxR ? maxR : maxC;

                    if (max > 1) {
                        for (int k = 2; k < max; k++) {
                            EgdeAndPoint egdeAndPoint = new EgdeAndPoint(max, i, j);
                            list.add(egdeAndPoint);
                        }
                    }
                }
            }
        }

        Collections.sort(list, (o1, o2) -> o2.getLen() - o1.getLen());
        for (EgdeAndPoint point : list) {
            int len = point.getLen();
            int x = point.getX() + len - 1;
            int y = point.getY() + len - 1;

            boolean flag = true;
            //只需要判断另外横向、纵向另外两侧
            //判断纵向
            for (int i = point.getX(); i <= x; i++) {
                if (grid[i][y] != 1) {
                    flag = false;
                    break;
                }
            }

            //判断横向
            for (int i = point.getY(); i <= y; i++) {
                if (grid[x][i] != 1) {
                    flag = false;
                    break;
                }
            }


            if (flag) {
                return point.getLen() * point.getLen();
            }
        }

        return withOne;
    }

}

class EgdeAndPoint {
    private int len;
    private int x;
    private int y;

    public EgdeAndPoint() {
    }

    public EgdeAndPoint(int len, int x, int y) {
        this.len = len;
        this.x = x;
        this.y = y;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
