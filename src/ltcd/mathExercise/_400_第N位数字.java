package ltcd.mathExercise;

public class _400_第N位数字 {

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }

        long sum = 9;//统计有多少个数字，初始化：一位数的所有数的数字个数9
        long preSum = 0;//统计从1位数、2位数、3位数....目标数的位数，所有的数的各数位数字的数量
        int digits = 1;//统计目标数据有多少 位
        long pre = 1;//用迭代来乘 10

        //确定目标数的位数：digits
        for (int i = 2; i < 10 && sum < n; i++) {
            preSum = sum;//记录上一轮统计的所有数字和
            sum += 9 * pre * 10 * i;//统计i位数之前有多少数字：
                                        // 比如 i = 2,所有数字 = 9 + 90 * 2 = 189
                                        // 比如 i = 3,所有数字 = 9 + 90 * 2 + 900 * 3 = 2889
            pre *= 10;//每次 * 10
            digits = i;//记录数据的位数
        }


        int start = (int) Math.pow(10, digits - 1);//确定位数 digits 后，最小的 digits位数 是 10 ^ (digits - 1) 次方：
                                                    //比如目标数是 digits = 2位， 则最小的两位数是 10 ^ (2 - 1) = 10
                                                    //比如目标数是 digits = 3位， 则最小的两位数是 10 ^ (3 - 1) = 100
        long num = start + (n - 1 - preSum) / digits;//确定目标数：目标数 = start + (n - 1 - preSum) / digits
                                                        //start是最小的digits位数
                                                        //(n - 1 - preSum) / digits 与最小数的差值是多少
                                                        //n - 1是因为会有一个偏移量。比如 n=11，目标数应该是 10,不减 1 则目标数为 11
        long pos = num + (n - preSum) % digits;//确定位置 = num + (n - preSum) % digits
                                               // n - preSum 是 目标数num - start 的差值
                                               // (n - preSum) % digits 是目标数字的位数（下标从1开始）
        String str = num + "";//转成字符串
        int index = pos - num - 1 < 0 ?  str.length() - 1 : (int) (pos - num - 1);//转成字符串后，下标从0开始，需要重新调整
                                //下标调整为：str.length() - 1 -> str.length() - 2... 2->1, 1->0, 0 ->  str.length() - 1

        return str.charAt(index) - '0';//返回数字
    }

    public static void main(String[] args) {
        System.out.println(new _400_第N位数字().findNthDigit(11));
    }

}
