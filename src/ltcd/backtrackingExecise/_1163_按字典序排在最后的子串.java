package ltcd.backtrackingExecise;

public class _1163_按字典序排在最后的子串 {

    public static void main(String[] args) {
        _1163_按字典序排在最后的子串 v = new _1163_按字典序排在最后的子串();
    //        System.out.println(v.lastSubstring("zhcjvaskdfhaksdgnkvnksznvkjashdgwrjgosjbsadbklasfdasdfjkglabasgbjkdjkvbsadg"));
//        System.out.println(v.lastSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
//        System.out.println(v.lastSubstring("abab"));
        System.out.println(v.lastSubstring("xbylisvborylklftlkcioajuxwdhahdgezvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji"));

    }

    public String lastSubstring(String s) {
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[chars.length];
        char max = 'a';
        int length = chars.length;
        int start = length - 1;
        int notSame = length - 1;

        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] > max) {
                start = i;
                max = chars[i];
            } else if (chars[i] == max) {

                int left = i;
                int right = start;
                while (left < start && right <= notSame) {
                    if (chars[left] > chars[right]) {
                        start = i;
                        break;
                    } else if (chars[left] < chars[right]) {
                        break;
                    }
                    left++;
                    right++;
                }

                if (left == start || right > notSame) {
                    start = i;
                }

                if (left == start && start - i > 2) {
                    notSame = start;
                }
            }
        }

        return s.substring(start, chars.length);
    }

}
