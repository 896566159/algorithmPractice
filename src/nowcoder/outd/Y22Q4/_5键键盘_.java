package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 有一个特殊的5键键盘，上面有a，ctrl-c，ctrl-x，ctrl-v，ctrl-a五个键。
 * a键在屏幕上输出一个字母 a；ctrl-c 将当前选择的字母复制到剪贴板；
 * ctrl-x 将当前选择的字母复制到剪贴板，并清空选择的字母；
 * ctrl-v 将当前剪贴板里的字母输出到屏幕；
 * ctrl-a 选择当前屏幕上的所有字母。
 * 注意：
 * 	剪贴板初始为空，新的内容被复制到剪贴板时会覆盖原来的内容
 * 	当屏幕上没有字母时，ctrl-a 无效
 * 	当没有选择字母时，ctrl-c 和 ctrl-x 无效
 * 	当有字母被选择时，a 和 ctrl-v 这两个有输出功能的键会先清空选择的字母，再进行输出
 * 	给定一系列键盘输入，输出最终屏幕上字母的数量。
 * 输入描述:
 * 	输入为一行，为简化解析，用数字1 2 3 4 5代表 a，ctrl-c，ctrl-x，ctrl-v，ctrl-a 五个键的输入，数字用空格分隔。
 * 输出描述:
 * 	输出一个数字，为最终屏幕上字母的数量。
 *
 * 示例1:
 * 	输入:
 * 		1 1 1
 * 	输出:
 * 		3
 * 说明: 连续键入3个a，故屏幕上字母的长度为3。
 * 示例2:
 * 	输入:
 * 		1 1 5 1 5 2 4 4
 * 	输出:
 * 		2
 * 说明:
 * 	输入两个 a 后 ctrl-a 选择这两个 a，再输入 a 时选择的两个 a 先被清空，所以此时屏幕只有一个 a，
 * 	后续的 ctrl-a，ctrl-c 选择并复制了这一个 a，最后两个ctrl-v在屏幕上输出两个a，
 * 	故屏幕上字母的长度为2（第一个ctrl-v清空了屏幕上的那个a）。
 */
public class _5键键盘_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        if (n < 1) {
            System.out.println(0);
            return;
        }

        // 一开始没有字母，长度为 0
        int ans = split[0].equals("1") ? 1 : 0;
        // 粘贴板中的字母长度为 0
        int vKey = 0;
        // 标记所有字母是否被选中，一开始只能是未选中状态，因为要么没字母可选中，要么不是选中按键
        boolean selected = false;

        for (int i = 1; i < n; i++) {
            String cur = split[i];

            if (cur.equals("1")) {
                // 如果所有字母被选择，则长度变为 1。否则长度 加1
                if (selected) {
                    ans = 1;
                    selected = false;
                } else {
                    ans++;
                }
            } else if (cur.equals("2")) {
                // 如果选中了字母，说明要将字母粘贴到粘贴板
                vKey = selected ? ans : vKey;
            } else if (cur.equals("3")) {
                // 如果字母是被选中的，则将字母剪切到粘贴板
                if (selected) {
                    vKey = ans;
                    ans = 0;
                    selected = false;
                }
            } else if (cur.equals("4")) {
                // 如果字母被选中，则先清除内容，在复制粘贴板中的内容
                if (selected) {
                    ans = vKey;
                    selected = false;
                } else {
                    ans += vKey;
                }
            } else if (cur.equals("5")) {
                // 所有字母被选中
                selected = true;
            }
        }

        System.out.println(ans);
    }

}
