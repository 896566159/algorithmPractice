package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 现在有多组整数数组,需要将他们合并成一个新的数组。
 * 合并规则,从每个数组里按顺序取出固定长度的内容合并到新的数组中,取完的内容会删除掉,
 * 如果该行不足固定长度或者已经为空,
 * 则直接取出剩余部分的内容放到新的数组中,继续下一行。
 * 如样例1,获得长度3,先遍历第一行,获得2,5,6；再遍历第二行,获得1,7,4；再循环回到第一行,获得7,9,5；再遍历第二行,获得3,4；
 * 再回到第一行,获得7,按顺序拼接成最终结果。
 * 输入描述：
 *  第一行是每次读取的固定长度,0<长度<10；
 *  第二行是整数数组的数目0<数目<1000,
 *  第3~n行是需要合并的数组,不同的数组用回车换行分隔,数组内部用逗号分隔。最大不超过100个元素
 * 输出描述：
 * 输出一个新的数组,用逗号分隔
 *
 * 示例一：
 * 	输入：
 * 		3
 * 		2
 * 		2,5,6,7,9,5,7
 * 		1,7,4,3,4
 * 	输出：
 * 		2,5,6,1,7,4,7,9,5,3,4,7
 *
 * 示例二：
 * 	输入：
 * 		4
 * 		3
 * 		1,2,3,4,5,6
 * 		1,2,3
 * 		1,2,3,4
 * 	输出：
 * 		1,2,3,4,1,2,3,1,2,3,4,5,6
 */
public class _数组合并_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        List<String[]> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine().split(","));
        }
        
        List<String> res = new ArrayList<>();
        int count = 0;
        int i = 0;
        do {
            count = res.size();
            for (int j = 0; j < n; j++) {
                String[] strings = list.get(j);

                for (int k = i * m; k < (i + 1) * m  && k < strings.length ; k++) {
                    res.add(strings[k]);
                }
            }
            i++;
        } while (count != res.size());

        for (int j = 0; j < count - 1; j++) {
            System.out.print(res.get(j) + ",");
        }
        System.out.print(res.get(count - 1));
    }

}
