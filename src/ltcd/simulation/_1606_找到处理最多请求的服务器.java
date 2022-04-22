package ltcd.simulation;

import java.util.ArrayList;
import java.util.List;

public class _1606_找到处理最多请求的服务器 {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] freeTime = new int[k];
        int[] r = new int[k];
        int len = arrival.length;

        for (int i = 0; i < len; i++) {
            int time = arrival[i];
            int duration = load[i];
            int server = i % k;
            int end = server;
            boolean flag = false;

            while (time < freeTime[server]) {
                if (server < k) {//还有服务器未被检索
                    server++;
                }
                if (server == k) {//从0号服务器重新开始检索
                    server = 0;
                }
                if (server == end) {//该请求被放弃
                    flag = true;
                    break;
                }
            }

            if (flag) {//该请求被放弃,直接跳到一下个请求
                continue;
            }
            freeTime[server] = time + duration;//第server号服务器的空闲时间更新
            r[server]++;//第server号服务器处理请求次数增加
        }

        //上面的处理的到了每台服务器处理请求的次数，只要将最大的请求次数找出来即可
        int max = 0;
        List<Integer> ans = null;
        for (int i = 0; i < k; i++) {
            if (max < r[i]) {
                max = r[i];
                ans = new ArrayList<>();
                ans.add(i);
            } else if (max == r[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

}
