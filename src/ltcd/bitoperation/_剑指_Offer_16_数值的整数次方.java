package ltcd.bitOperation;

public class _剑指_Offer_16_数值的整数次方 {

    public double myPow(double x, int n) {
        double ans = 1;

        for (int i = n; i > 1 ; i /= 2) {
            if ( i % 2 != 0) {
                ans *= x;
            }
            x *= x;
        }

        return ans;
    }

}
