package ltcd.preSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文意味着从左往右第 i 个字母和从右往左第 i 个字母是相同的。（回文串关于回文中心是对称的。）
 *
 * 如果有偶数个 a，那么可以均分成两部分，分别放置在字符串的中心对称位置上。例如有 4 个 a，可以在字符串的最左边放置 2 个 a，最右边放置 2 个 a，这样字符串中的 a 是回文的。其它字母如果出现偶数次，也同理。
 *
 * 如果有奇数个 a，多出的一个 a 要单独拿出来讨论：
 *
 * ① 假如只有 a 出现奇数次，其它字母都出现偶数次。此时字符串的长度一定是奇数，那么可以把多出的这个 a 放在字符串的中心，我们仍然可以得到一个回文串，无需替换任何字母。
 * ② 如果有两种字母出现奇数次（假设是字母 a,b），由于多出的一个 a 和一个 b 无法组成回文串，可以把一个 b 改成 a（或者把一个 a 改成 b），这样 a 和 b 就都出现偶数次了。
 * ③ 如果有三种字母出现奇数次（假设是字母 a,b,c），把一个 b 改成 c，就转换成只有 a 出现奇数次的情况了。
 * 总结：一般地，如果有 m 种字母出现奇数次，只需修改其中 m/2 个字母。换句话说，如果第 i 次询问有 m/2 <= k, 那么 answer[i]\textit{answer}[i]answer[i] 为真，反之为假。
 * 最后要解决的问题是，如何快速求出子串中每种字母的个数？
 * 可以创建 26 个前缀和数组，分别统计每种字母。以字母 a 为例，在计算前缀和时，如果 s[i] = a 就视作 1，否则视作 0。
 */
public class _1177_构建回文串检测_ {


    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        System.out.println("统计每个字符的前缀和" + canMakePaliQueries1(s, queries));
        System.out.println("统计每个字符的前缀和——奇偶数" + canMakePaliQueries2(s, queries));
        return canMakePaliQueries3(s, queries);
    }

    private List<Boolean> canMakePaliQueries3(String s, int[][] queries) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] preSum = new int[n + 1];

        // 前缀和统计，只在乎奇偶
        for (int i = 0; i < n; i++) {
            int bit = 1 << (chars[i] - 'a');
            // 该比特对应字母的奇偶性：奇数变偶数，偶数变奇数
            preSum[i + 1] = preSum[i] ^ bit;
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int k = query[2];
            int m = 0;

            // 异或的运算法则为：0 ⊕ 0 = 0，1 ⊕ 0 = 1，0 ⊕ 1 = 1，1 ⊕ 1 = 0（同为 0，异为 1）
            m = Integer.bitCount(preSum[right + 1] ^ preSum[left]);
            ans.add(m / 2 <= k);
        }

        return ans;
    }

    private List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] preSum = new int[n + 1][26];

        // 前缀和统计，只在乎奇偶
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i].clone();
            preSum[i + 1][chars[i] - 'a']++;
            preSum[i + 1][chars[i] - 'a'] = preSum[i + 1][chars[i] - 'a'] % 2;
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int k = query[2];
            int m = 0;

            for (int i = 0; i < 26; i++) {
                m += preSum[right + 1][i] == preSum[left][i] ? 0 : 1;
            }

            ans.add(m / 2 <= k);
        }

        return ans;
    }

    private List<Boolean> canMakePaliQueries1(String s, int[][] queries) {
        int n = s.length();
        int[][] preSum = new int[n + 1][26];
        char[] chars = s.toCharArray();

        // 统计前缀和
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i].clone();
            preSum[i + 1][chars[i] - 'a']++;
        }

        // 预分配空间
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int k = query[2];
            // 统计字符串在区间 [left, right] 中有多少奇数个字母
            int m = 0;

            for (int i = 0; i < 26; i++) {
                // 奇数+1，偶数+0
                m += (preSum[right + 1][i] - preSum[left][i]) % 2;
            }

            ans.add(m / 2 <= k);
        }

        return ans;
    }

}
