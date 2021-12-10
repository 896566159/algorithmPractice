package ltcd.stringExercise;

public class _剑指_Offer_58_II_左旋转字符串 {

    public String reverseLeftWords(String s, int n) {
        return (s + s).substring(n, n + s.length());
    }

}
