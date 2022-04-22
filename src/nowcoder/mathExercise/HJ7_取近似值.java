package nowcoder.mathExercise;

import java.util.Scanner;

public class HJ7_取近似值 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float v = sc.nextFloat();
        int res = (int)(v + 0.5) > (int)(v) ? (int)(v + 0.5) : (int)(v);
        System.out.println(res);
    }

}
