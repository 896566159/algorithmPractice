package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 数字0、1、2、3、4、5、6、7、8、9分别关联 a~z 26个英文字母。
 * 0 关联 "a","b","c"
 * 1 关联 "d","e","f"
 * 2 关联 "g","h","i"
 * 3 关联 "j","k","l"
 * 4 关联 "m","n","o"
 * 5 关联 "p","q","r"
 * 6 关联 "s","t"
 * 7 关联 "u","v"
 * 8 关联 "w","x"
 * 9 关联 "y","z"
 *
 * 例如：7关联"u","v"，8关联"x","w"，输入一个字符串例如“78”，
 * 和一个屏蔽字符串“ux”,那么“78” 可以组成多个字符串例如：“ux”，“uw”，“vx”，“vw”，过滤这些完全包含屏蔽字符串的每一个字符的字符串，然后输出剩下的字符串。
 * 示例：
 * 	输入：
 * 		78
 * 		ux
 * 	输出：
 * 		uw vx vw
 * 说明：ux 完全包含屏蔽字符串ux，因此剔除
 */
public class _过滤组合字符串_ {

    final static char[][] dic = new char[][] {
            new char[] {'a', 'b', 'c'},
            new char[] {'d', 'e', 'f'},
            new char[] {'g', 'h', 'i'},
            new char[] {'j', 'k', 'l'},
            new char[] {'m', 'n', 'o'},
            new char[] {'p', 'q', 'r'},
            new char[] {'s', 't'},
            new char[] {'u', 'v'},
            new char[] {'w', 'x'},
            new char[] {'y', 'z'}
    };
    static String str;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.next();
        str = scanner.next();

        // 第一个数字对应的所有字符串
        int index = digits.charAt(0) - '0';
        int n = dic[index].length;
        List<StringBuffer> paths = new ArrayList<>();

        // 第一个数字对应的所有字符串
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer().append(dic[index][i]);
            if (!sb.toString().equals(str)) {
                // 结果不去重
                paths.add(sb);
            }
        }

        // 剩余的数字组合
        for (int i = 1; i < digits.length(); i++) {
            index = digits.charAt(i) - '0';
            n = dic[index].length;
            List<StringBuffer> buffers = new ArrayList<>();
            int size = paths.size();

            // 枚举之前组成的字符串
            for (int j = 0; j < size; j++) {
                // 枚举当前数字键对应的字母
                for (int k = 0; k < n; k++) {
                    StringBuffer path = new StringBuffer(paths.get(j));
                    path.append(dic[index][k]);

                    if (!path.toString().equals(str)) {
                        buffers.add(path);
                    }
                }
            }

            paths = buffers;
        }

        // 检查字符串是否包含屏蔽字符串
        int result_count = res_str_list.size();
        String output_str = "";
        for (String x : res_str_list) {
            // 过滤
            if (!check(x, block_str)) {
                output_str += x + " ";
            }
        }

        System.out.println("-----------------");
        for (StringBuffer path : paths) {
            if (!check(path.toString(), str)) {
                System.out.print(path.toString() + " ");
            }
        }
    }

    // ---------------------------------------------网上做法---------------------------------------------------------------------
    static String num_str;
    static String block_str;
    public static ArrayList<String> res_str_list;
    static HashMap<Character, String> num_char_map = new HashMap<Character, String>();
    //预设值
    static {
        num_char_map.put('0', "abc");
        num_char_map.put('1', "def");
        num_char_map.put('2', "ghi");
        num_char_map.put('3', "jkl");
        num_char_map.put('4', "mno");
        num_char_map.put('5', "pqr");
        num_char_map.put('6', "st");
        num_char_map.put('7', "uv");
        num_char_map.put('8', "wx");
        num_char_map.put('9', "yz");
    }

//    public static void main(String[] args) {
//        // 处理输入
//        Scanner in = new Scanner(System.in);
//        num_str = in.nextLine();
//        block_str = in.nextLine();
//        res_str_list = new ArrayList<String>();
//
//        // 开始组合
//        dfs(new ArrayList<Character>(), 0);
//
//        // 检查字符串是否包含屏蔽字符串
//        int result_count = res_str_list.size();
//        String output_str = "";
//        for (String x : res_str_list) {
//            // 过滤
//            if (!check(x, block_str)) {
//                output_str += x + " ";
//            }
//        }
//
//        System.out.println(output_str.substring(0, output_str.length() - 1));
//    }

    //判断字符是否全部包含
    public static boolean check(String string1, String string2) {
        Set<Character> set1 = new HashSet<Character>();
        for (int i = 0; i < string1.length(); i++) {
            set1.add(string1.charAt(i));
        }

        Set<Character> set2 = new HashSet<Character>();
        for (int i = 0; i < string2.length(); i++) {
            set2.add(string2.charAt(i));
        }

        for (Character single_char : set2) {
            if (!set1.contains(single_char)) {
                return false;
            }
        }

        return true;
    }

    // 递归求出所有可能的排列组合
    public static void dfs(ArrayList<Character> list, int index) {
        if (index == num_str.length()) {
            String temp_str = "";
            for (int i = 0; i < list.size(); i++) {
                temp_str = temp_str + list.get(i);
            }
            res_str_list.add(temp_str);
            return;
        }

        for (char single_char : num_char_map.get(num_str.toCharArray()[index]).toCharArray()) {
            list.add(single_char);
            dfs(list, index + 1);
            list.remove(list.size() - 1);
        }
    }

}
