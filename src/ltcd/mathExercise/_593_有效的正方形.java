package ltcd.mathExercise;

import java.util.HashSet;
import java.util.Set;

public class _593_有效的正方形 {

    public static void main(String[] args) {
        System.out.println(new _593_有效的正方形().validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{1, 1}));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int hypotenuse = -1;
        int border = -1;

        //计算p1与p2/p3/p4的距离
        //p1 与 p2
        int x = Math.abs(p1[0] - p2[0]);
        int y = Math.abs(p1[1] - p2[1]);
        x *= x;
        y *= y;
        border = x + y;

        //p1 与 p3
        x = Math.abs(p1[0] - p3[0]);
        y = Math.abs(p1[1] - p3[1]);
        x *= x;
        y *= y;
        hypotenuse = border == x + y ? -1 : x + y;

        //p1 与 p4
        x = Math.abs(p1[0] - p4[0]);
        y = Math.abs(p1[1] - p4[1]);
        x *= x;
        y *= y;
        if ((hypotenuse != -1 && x + y != hypotenuse && x + y != border) || x + y == 0) {
            return false;
        } else if (hypotenuse == -1){
            hypotenuse = x + y;
        }

        //p2 与 p4
        x = Math.abs(p2[0] - p4[0]);
        y = Math.abs(p2[1] - p4[1]);
        x *= x;
        y *= y;
        if ((x + y != hypotenuse && x + y != border) || x + y == 0) {
            return false;
        }

        //p3 与 p4
        x = Math.abs(p3[0] - p4[0]);
        y = Math.abs(p3[1] - p4[1]);
        x *= x;
        y *= y;
        if (( x + y != hypotenuse && x + y != border) || x + y == 0) {
            return false;
        }

        //p3 与 p2
        x = Math.abs(p3[0] - p2[0]);
        y = Math.abs(p3[1] - p2[1]);
        x *= x;
        y *= y;
        if (( x + y != hypotenuse && x + y != border) || x + y == 0) {
            return false;
        }

        if (border > hypotenuse) {
            return hypotenuse + hypotenuse == border;
        }

        return border + border == hypotenuse;
    }

}
