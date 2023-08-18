package nowcoder.outd.Y22Q3;

import java.util.*;

/**
 * 有一个简易内存池，内存按照大小粒度分类，每个粒度有若干个可用内存资源，
 * 用户会进行一系列内存申请，需要按需分配内存池中的资源 返回申请结果成功失败列表。
 * 分配规则如下：
 * 	分配的内存要大于等于内存的申请量，存在满足需求的内存就必须分配，优先分配粒度小的，但内存不能拆分使用；
 * 	需要按申请顺序分配，先申请的先分配，
 * 	有可用内存分配则申请结果为true，没有可用则返回false。
 * 注意：不考虑内存释放
 *
 * 输入描述：
 * 	输入为两行字符串
 * 	第一行为内存池资源列表
 * 		包含内存粒度数据信息，粒度数据间用逗号分割
 * 		一个粒度信息内用冒号分割
 * 		冒号前为内存粒度大小，冒号后为数量
 * 		资源列表不大于1024
 * 		每个粒度的数量不大于4096
 * 	第二行为申请列表
 * 		申请的内存大小间用逗号分割，申请列表不大于100000
 * 	如：
 * 	64:2,128:1,32:4,1:128
 * 	50,36,64,128,127
 *
 * 输出描述：
 * 	输出为内存池分配结果
 * 	如true,true,true,false,false
 *
 * 示例1：
 * 	输入：
 * 		64:2,128:1,32:4,1:128
 * 		50,36,64,128,127
 * 	输出：
 * 		true,true,true,false,false
 */
public class _内存资源分配_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        String[] requests = scanner.nextLine().split(",");

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> types = new ArrayList<>();
        // 统计不同内存大小的数量
        for (String s : split) {
            String[] item = s.split(":");
            int key = Integer.parseInt(item[0]);
            int count = Integer.parseInt(item[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + count);
            } else {
                map.put(key, count);
                types.add(key);
            }
        }
        // 排序
        Collections.sort(types);

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (String item : requests) {
            int target = Integer.parseInt(item);
            if (map.isEmpty()) {
                if (index++ > 0) {
                    sb.append(",false");
                } else {
                    sb.append("false");
                }
            }

            // 二分查找：找出一个最小的 且大于 target 的内存
            int left = 0;
            int right = types.size() - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (types.get(mid) < target) {
                    // 缩小范围 [mid + 1，right]
                    left = mid + 1;
                } else {
                    // 缩小范围 [left, mid]
                    right = mid;
                }
            }

            // 剩余的内存都很小，不够分配
            if (types.get(left) < target) {
                if (index++ > 0) {
                    sb.append(",false");
                } else {
                    sb.append("false");
                }
                continue;
            }

            // 还能分配
            Integer count = map.get(types.get(left));
            if (index++ > 0) {
                sb.append(",true");
            } else {
                sb.append("true");
            }

            if (count == 1) {
                // 最后一块，删除
                map.remove(types.get(left));
                types.remove(left);
            } else {
                map.put(types.get(left), count - 1);
            }
        }

        System.out.println(sb.toString());
    }

}
