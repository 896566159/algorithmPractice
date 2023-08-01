package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 给定一个输入字符串，字符串只可能由英文字母 (a ~z、A~ Z ) 和左右小括号 (、) 组成
 * 当字符里存在小括号时，小括号是成对的，可以有一个或多个小括号对，小括号对不会嵌套，小括号对内可以包含1个或多个英文字母也可以不包含英文字母。
 * 当小括号对内包含多个英文字母时，这些字母之间是相互等效的关系，而且等效关系可以在不同的小括号对之间传递，即当存在a和b等效和存在b和c等效时， a和c 也等效，
 * 另外，同一个英文字母的大写字和小写字母也相互等效(即使它们分布在不同的括号对里)
 * 要对这个输入字符串做简化，输出一个新的字符串，输出字符串里只需保留输入字符串里的没有被小括号对包含的字符(按照输入字符串里的字符顺序)，并将每个字符替换为在小括号对里包含的目字典序最小的等效字符。如果简化后的字符串为空，请输出为”0”
 *
 * 示例:输入字符串为"never(dont)live(run)up(f)()"，初始等效字符集合为(d,o,n,t)、(r,u,n)，由于等效关系可以传递，因此最终等效字符集合为(d,o,n,t,r,u)，将输入字符串里的剩余部分按字典序最小的等效字符替换后得到"devedgivedp
 * 输入描述:
 * 	input string
 * 	输入为1行，代表输入字符串
 * 输出描述:
 * 	output string
 * 	输出为1行，代表输出字符串
 * 备注:
 * 	输入字符串的长度在1~100000之间
 *
 * 示例1：
 * 	输入：
 * 		()abd
 * 	输出：
 * 		abd
 * 说明：输入字符串里没有被小括号包含的了字符串为"abd"，其中每个字符没有等效字符，输出为"abd"
 *
 * 示例2：
 * 	输入：
 * 		(abd)demand(fb)()for
 * 	输出：
 * 		aemanaaor
 * 说明: 等效字符集为(a，b，d，f)，输入字符串里没有被小括号包含的了字符串集合为'demandfor”，将其中字符替换为字典序最小的等效字符后输出为:"aemanaaor
 *
 * 示例3：
 * 	输入：
 * 		happy(xyz)new(wxy)year(t)
 * 	输出：
 * 		happwnewwear
 *
 * 说明：等效字符集为(x，y, z，w)，输入字符串里没有被小括号包含的了字符串集合为"happynewyear”，将其中字符替换为字典序最小的等效字等后输出为:"happwnewwear
 */
public class _字符串化繁为简_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] original = line.toCharArray();
        char[] chars = line.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        List<Set<Character>> equivalent = new ArrayList<>();
        int[] count = new int[26];

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == '(') {
                int j = i + 1;
                while (j < chars.length && chars[j] != ')') {
                    j++;
                }
                // 括号内字母有多个
                if (j - i >= 3) {
                    char[] bracket = line.toLowerCase().substring(i + 1, j).toCharArray();
                    Set<Character> union = new TreeSet<>();
                    List<Character> isSame = new ArrayList<>();
                    for (char c1 : bracket) {
                        if (!union.contains(c1) && count[c1 - 'a'] == 1) {
                            // 合并
                            isSame.add(c1);
                        } else {
                            union.add(c1);
                            count[c1 - 'a'] = 1;
                        }
                    }

                    // 合并
                    if (!isSame.isEmpty())  {
                        Set<Integer> mergeIndex = new TreeSet<>();
                        for (Character same : isSame) {
                            for (int k = 0; k < equivalent.size(); k++) {
                                if (equivalent.get(k).contains(same)) {
                                    // 合并
                                    union.addAll(equivalent.get(k));
                                    mergeIndex.add(k);
                                }
                            }
                        }

                        List<Set<Character>> tmp = new ArrayList<>();
                        for (int k = 0; k < equivalent.size(); k++) {
                            if (!mergeIndex.contains(k)) {
                                tmp.add(equivalent.get(k));
                            }
                        }
                        equivalent = tmp;
                    }
                    equivalent.add(union);
                }
                i = j;
            } else {
                sb.append(original[i]);
            }
        }

        // 替换
        char[] onBraket = sb.toString().toCharArray();
        sb = new StringBuilder();
        for (int i = 0; i < onBraket.length; i++) {
            char c = onBraket[i];
            boolean flag = true;

            for (int j = 0; j < equivalent.size(); j++) {
                Set<Character> set = equivalent.get(j);
                if (set.contains(c) || set.contains((char) (c + 32))) {
                    flag = false;
                    sb.append(set.iterator().next());
                    break;
                }
            }

            if (flag) {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }

}
