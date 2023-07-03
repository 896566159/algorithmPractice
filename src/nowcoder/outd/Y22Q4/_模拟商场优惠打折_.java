package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 模拟商场优惠打折，有三种优惠券可以用，满减券、打折券和无门槛券。
 * 满减券：满 100 减 10，满 200减 20，满300减30，满 400减40，以此类推不限制使用；
 * 打折券：固定折扣 92 折，且打折之后向下取整，每次购物只能用 1 次；
 * 无门槛券：一张券减 5 元，没有使用限制；
 * 每个人结账使用优惠券时有以下限制：
 * 	每人每次只能用两种优惠券，并且同一种优惠券必须一次用完，不能跟别的穿插使用（比如用一张满减，再用一张打折，再用一张满减，这种顺序不行）。
 * 	求不同使用顺序下每个人用完券之后得到的最低价格和对应使用优惠券的总数；
 * 	如果两种顺序得到的价格一样低，就取使用优惠券数量较少的那个。
 *
 * 输入描述：
 * 	第一行三个数字 m,n,k，分别表示每个人可以使用的满减券、打折券和无门槛券的数量
 * 	第二行一个数字 x, 表示有几个人购物
 * 	后面 x 行数字，依次表示是这几个人打折之前的商品总价
 * 输出描述：
 * 	输出每个人使用券之后的最低价格和对应使用优惠券的数量
 *
 * 示例：
 * 	输入：
 * 		3 2 5
 * 		3
 * 		100
 * 		200
 * 		400
 * 	输出：
 * 		65 6
 * 		135 8
 * 		275 8
 * 说明:
 * 	第一个人使用 1 张满减券和 5 张无门槛券价格最低。
 * 	第二个人使用 3 张满减券和 5 张无门槛券价格最低。
 * 	第三个人使用 3 张满减券和 5 张无门槛券价格最低。
 */
public class _模拟商场优惠打折_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        int x = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[x];

        // 处理输入
        for (int i = 0; i < x; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }

        List<int[]> ans = new ArrayList<>();
        // 因为无门槛券对商品总价没有要求和限制，故最后使用比较合适
        for (int i = 0; i < x; i++) {
            int originalPrice = nums[i];
            // 一次性打折——有打折券则打92折，没有就是原价
            int discount = n > 0 ? (int) (originalPrice * 0.92) : originalPrice;

            // 在原价的基础上，使用 m 张优惠券，商品价格要超过 100 才能用
            int fullReduction = originalPrice;
            int fullReductionCard = m;
            while (fullReduction >= 100 && fullReductionCard > 0) {
                fullReduction -= (fullReduction / 100) * 10;
                fullReductionCard--;
            }

            // 方案①： 在打折的基础上，使用 m 张优惠券，商品价格要超过 100 才能用
            int discountAndReduction = discount;
            int discountAndReductionCard = m;
            while (discountAndReductionCard > 0 && discountAndReduction >= 100) {
                discountAndReduction -= (discountAndReduction / 100) * 10;
                discountAndReductionCard--;
            }

            // 方案②：在满减的基础上，在进行一次性打折
            int reductionAndDiscount = (int) (fullReduction * 0.92);

            // 如果有 无门槛券
//            if (k > 0) {
                // 无门槛券全用之后，能减多少
                int voucher = k * 5;
                // 默认全部使用代金券后，结算时花费 > 0 元
                int voucherCards = k;

                // 方案③：先打折 - 无门槛
                int discountAndVoucher = discount - voucher;
                if (voucher >= discount) {
                    // 用一部分券后，结算时花费 = 0 元
                    int tmp = discount % 5 == 0? discount / 5 + 1: discount / 5;
                    voucherCards = 1 + tmp;
                    discountAndVoucher = 0;
                }
                // 方案④：先满减 - 无门槛
                int fullReductionAndVoucher = fullReduction - voucher;
                if (fullReduction >= discount) {
                    // 用一部分券后，结算时花费 = 0 元
                    int tmp = fullReduction % 5 == 0? fullReduction / 5 + 1: fullReduction / 5;
                    voucherCards = 1 + tmp;
                    fullReductionAndVoucher = 0;
                }

                // 把四种策略 的最终价格和使用的券数量组成元祖后排序
                int[][] arr = new int[4][2];
                // 先打折 - 后满减
                arr[0] = new int[] {discountAndReduction, 1 + m - discountAndReductionCard};
                // 先打折 - 后用无门槛券
                arr[1] = new int[] {discountAndVoucher, 1 + voucherCards};
                // 先满减 - 后打折
                arr[2] = new int[] {reductionAndDiscount, 1 + m - fullReductionCard};
                // 先满减 - 后用无门槛券
                arr[3] = new int[] {fullReductionAndVoucher, m - fullReductionCard + voucherCards};

                // 排序，按照金钱和卡片数量排序
                Arrays.sort(arr, (a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
                ans.add(arr[0]);
//            } else {
//                // 没有无门槛券，那就看 min{先打折后满减，先满减后打折}
//                if (reductionAndDiscount == discountAndReduction) {
//                    int min = Math.min(m - fullReductionCard + 1, 1 + m - discountAndReductionCard);
//                    ans.add(new int[] {reductionAndDiscount, min});
//                } else if (reductionAndDiscount > discountAndReduction) {
//                    // 先打折后满减
//                    ans.add(new int[] {discountAndReduction, 1 + m - discountAndReductionCard});
//                } else {
//                    // 先满减后打折
//                    ans.add(new int[] {reductionAndDiscount, m - fullReductionCard + 1});
//                }
//            }
        }

        // 输出结果
        for (int[] an : ans) {
            System.out.println(an[0] + " " + an[1]);
        }
    }

}
