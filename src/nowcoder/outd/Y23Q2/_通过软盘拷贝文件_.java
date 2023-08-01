package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一名科学家想要从一台古董电脑中拷贝文件到自己的电脑中加以研究。
 * 但此电脑除了有一个3.5寸软盘驱动器以外，没有任何手段可以将文件持贝出来，而且只有一张软盘可以使用。因此这一张软盘是唯一可以用来拷贝文件的载体。
 * 科学家想要尽可能多地将计算机中的信息拷贝到软盘中，做到软盘中文件内容总大小最大。
 * 已知该软盘容量为1474560字节。文件占用的软盘空间都是按块分配的，每个块大小为512个字节。
 * 一个块只能被一个文件使用。拷贝到软盘中的文件必须是完整的，且不能采取任何压缩技术。
 *
 * 输入描述:
 * 	第1行为一个整数N，表示计算机中的文件数量。1<= N<= 1000
 * 	接下来的第2行到第N+1行(共N行)，每行为一个整数，表示每个文件的大小Si，单位为字节.
 * 	0<=i<Ni<=Si
 * 输出描述:
 * 	科学家最多能拷贝的文件总大小
 * 备注:
 * 	为了充分利用软盘空间，将每个文件在软盘上占用的块记录到本子上。即真正占用软盘空间的只有文件内容本身
 *
 *
 * 示例1：
 * 	输入:
 * 		3
 * 		737270
 * 		737272
 * 		737288
 * 	输出:
 * 		1474542
 * 说明:
 * 	3个文件中，每个文件实际占用的大小分别为737280字节、737280字节、737792字节。
 * 	只能选取前两个文件，总大小为1474542字节。虽然后两个文件总大小更大且未超过1474560字节，但因为实际占用的大小超过了1474560字节，所以不能选后两个文件
 *
 *
 * 示例2：
 * 	输入:
 * 		6
 * 		400000
 * 		200000
 * 		200000
 * 		200000
 * 		400000
 * 		400000
 * 	输出:
 * 		1400000
 * 说明:
 * 	从6个文件中，选择3个大小为400000的文件和1个大小为200000的文件，得到最大总大小为1400000.
 * 	也可以选择2个大小为400000的文件和3个大小为200000的文件，得到的总大小也是1400000
 */
public class _通过软盘拷贝文件_ {

    static int max = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] files = new int[n][2];
        int sum = 0;
        int org = 0;

        for (int i = 0; i < n; i++) {
            int file = Integer.parseInt(scanner.nextLine());
            int mod = file % 512;
            files[i] = new int[] {file + 512 - mod, file};
            sum += files[i][0];
            org += files[i][1];
        }

        if (sum < 1474560) {
            System.out.println(org);
            return;
        }

        // 排序
        Arrays.sort(files, (a, b)->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        dfs(0, 0, files, new boolean[n]);
        System.out.println(max);

        // 使用01背包解决

    }

    private static void dfs(int sum, int org, int[][] files, boolean[] used) {
        if (sum > 1474560) {
            return;
        }

        max = Math.max(max, org);
        for (int i = 0; i < files.length; i++) {
            if (!used[i] && sum + files[i][0] <= 1474560) {
                used[i] = true;
                dfs(sum + files[i][0], org + files[i][1], files, used);
                used[i] = false;
            }
        }
    }

}
