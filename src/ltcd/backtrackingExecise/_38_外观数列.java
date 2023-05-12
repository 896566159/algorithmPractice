package ltcd.backtrackingExecise;

public class _38_外观数列 {

    public static void main(String[] args) {
        _38_外观数列 v = new _38_外观数列();
        System.out.println(v.countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        return countAndSay(new StringBuilder("1"), n);
    }

    public String countAndSay(StringBuilder previousStr, int n) {
        if (n == 1) {
            return previousStr.toString();
        }

        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for (int i = 1; i < previousStr.length(); i++) {
            if (previousStr.charAt(i) != previousStr.charAt(pre)) {
                int count = i - pre;
                sb.append(count).append(previousStr.charAt(pre));
                pre = i;
            }
        }

        sb.append(previousStr.length() - pre).append(previousStr.charAt(pre));
        return countAndSay(sb, n - 1);
    }

}
