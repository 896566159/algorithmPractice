package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 企业路由器的统计页面，有一个功能需要动态统计公司访问最多的网页URL top N。请设计一个算法，可以高效动态统计Top N的页面。
 * 输入描述：
 * 每一行都是一个URL或一个数字，如果是URL，代表一段时间内的网页访问；
 * 如果是一个数字N，代表本次需要输出的Top N个URL。
 * 输入约束：
 * 	1、总访问网页数量小于5000个，单网页访问次数小于65535次；
 * 	2、网页URL仅由字母，数字和点分隔符组成，且长度小于等于127字节；
 * 	3、数字是正整数，小于等于10且小于当前总访问网页数；
 * 输出描述：
 * 	每行输入要对应一行输出，输出按访问次数排序的前 N 个URL，用逗号分隔。
 * 输出要求
 * 	1、每次输出要统计之前所有输入，不仅是本次输入；
 * 	2、如果有访问次数相等的URL，按URL的字符串字典序升序排列，输出排序靠前的URL；
 *
 * 示例1：
 * 	输入：
 * 		news.qq.com
 * 		news.sina.com.cn
 * 		news.qq.com
 * 		news.qq.com
 * 		game.163.com
 * 		game.163.com
 * 		www.huawei.com
 * 		www.cctv.com
 * 		3
 * 		www.huawei.com
 * 		www.cctv.com
 * 		www.huawei.com
 * 		www.cctv.com
 * 		www.huawei.com
 * 		www.cctv.com
 * 		www.huawei.com
 * 		www.cctv.com
 * 		www.huawei.com
 * 		3
 * 	输出：
 * 		news.qq.com,game.163.com,news.sina.com.cn
 * 		www.huawei.com,www.cctv.com,news.qq.com
 * 示例2：
 * 	输入：
 * 		news.qq.com
 * 		www.cctv.com
 * 		1
 * 		www.huawei.com
 * 		www.huawei.com
 * 		2
 * 		3
 * 	输出：
 * 		news.qq.com
 * 		www.huawei.com,news.qq.com
 * 		www.huawei.com,news.qq.com,www.cctv.com
 */
public class _热点网站统_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            try {
                // 输入的是数字
                int n = Integer.parseInt(line);
                // 输出 TOP_N
                printTopN(n, map);
            } catch (Exception e) {
                // 输入的是一个网址
                map.put(line, map.getOrDefault(line, 0) + 1);
            }
        }
    }

    private static void printTopN(int n, Map<String, Integer> map) {
        // 自定义优先队列
        PriorityQueue<URLCount> urlCounts = new PriorityQueue<>((a, b)->a.count == b.count ? a.url.compareTo(b.url) : b.count - a.count);
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = map.get(key);
            urlCounts.add(new URLCount(key, value));
        }

        // 输出前 n - 1 个，有逗号
        while (!urlCounts.isEmpty()) {
            if (--n < 1) {
                break;
            }
            System.out.print(urlCounts.poll().url + ",");
        }

        // 输出第 n 个，无逗号
        if (!urlCounts.isEmpty() && n == 0) {
            System.out.print(urlCounts.poll().url);
        }

        // 输出一个空行，与上面输出的 TOP_N 内容错开一行，方便继续输入 url
        System.out.println();
    }

    static class URLCount {
        String url;
        int count;

        public URLCount() {
        }

        public URLCount(String url, int count) {
            this.url = url;
            this.count = count;
        }
    }

}
