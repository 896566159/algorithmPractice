package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 某探险队负责对地下洞穴进行探险。
 * 探险队成员在进行探险任务时，随身携带的记录器会不定期地记录自身的坐标，但在记录的间隙中也会记录其他数据。
 * 探索工作结束后，探险队需要获取到某成员在探险过程中相对于探险队总部的最远的足迹位置。
 * 仪器记录坐标时，坐标的数据格式为 (x,y)，如(1,2)、(100,200)，其中 0 < x < 1000，0 < y <1000。
 * 同时存在非法坐标，如 (01,1)、(1,01)，(0,100) 属于非法坐标。
 * 设定探险队总部的坐标为 (0,0)，某位置相对总部的距离为：x*x + y*y。
 * 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
 * 若记录仪中的坐标都不合法，输出总部坐标（0,0）。
 * 备注：
 * 	不需要考虑双层括号嵌套的情况，比如sfsdfsd((1,2))。
 * 输入描述：
 * 	字符串，表示记录仪中的数据。
 * 	如：ferga13fdsf3(100,200)f2r3rfasf(300,400)
 * 输出描述：
 * 	字符串，表示最远足迹到达的坐标。
 * 	如： (300,400)
 *
 * 示例1：
 * 	输入：
 * 		ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)
 * 	输出：
 * 		(5,10)
 * 说明：
 * 	记录仪中的合法坐标有3个：(3,10)， (3,4)， (5,10)，其中 (5,10) 是相距总部最远的坐标， 输出(5,10)。
 *
 * 示例2：
 * 	输入：
 * 		asfefaweawfaw(0,1)fe
 * 	输出：
 * 		(0,0)
 * 说明：
 * 	记录仪中的坐标都不合法，输出总部坐标（0,0）。
 */
public class _最远足迹_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        int max = 0;
        int n = chars.length;
        int x = 0;
        int y = 0;

        // 可以直接从开始，因为(a,b)
        for (int i = 4; i < n; i++) {
            // 出现右括号，且右括号左边是数字，看是否存在与之匹配的左括号
            if (chars[i] == ')' && chars[i - 1] >= '0' && chars[i - 1] <= '9') {
                int j = i - 1;
                boolean flag = true;
                int countComma = 0;

                while (j >= 0) {
                    if (chars[j] == '(') {
                        // 匹配到左括号
                        // 如果逗号的右边数字是 0，不合法
                        if (chars[j + 1] == '0') {
                            flag = false;
                        }
                        break;
                    } else if (chars[j] == ',') {
                        // 如果逗号数量超过 2，不会出现合法的坐标
                        if (++countComma > 1) {
                            flag = false;
                            break;
                        }

                        // 如果逗号的右边数字是 0，不合法
                        if (chars[j + 1] == '0') {
                            flag = false;
                            break;
                        }
                    } else if (chars[j] > '9' || chars[j] < '0') {
                        // 出现非数字的字符
                        flag = false;
                        break;
                    }

                    j--;
                }

                // (x,y) 如果成对出现括号，且括号内有一个逗号，且逗号两边数字都不能以 0 开头，且括号内的()内容长度至少为 5
                if (flag && countComma == 1 && i - j > 4) {
                    String ponit = line.substring(j + 1, i);
                    String[] split = ponit.split(",");
                    int a = Integer.parseInt(split[0]);
                    int b = Integer.parseInt(split[1]);

                    if (a * a + b * b > max) {
                        max = a * a + b * b;
                        x = a;
                        y = b;
                    }
                }
            }
        }

        System.out.println("(" + x + " " + y + ")");
    }

}
