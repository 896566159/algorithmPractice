package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 网上新闻越来越多，希望对新闻进行热词处理并归类，方便获取信息，现在已经将每篇文章处理为 2 个字符串，即一个标题，一个正文串，字符串中使用“ ”作为分隔符进行分词。
 * M 篇新闻按照新闻发布的先后顺序处理完并输入，现在希望对所有新闻中出现的词语进行处理，输出出现频率最高的 topN 个词语，作为热词。
 * 标题中出现的词语频率系数为 3，正文中出现的词语频率系数为 1；
 * 返回的答案按照词语出现频率由高到低排序;
 * 当词语出现的频率相同时，在标题中出现的频率次数高的排在前面；
 * 如果仍然相同，则按照词语在标题中出现的先后顺序进行排序，先出现的排在前面；
 * 如果仍然相同，则按照词语在正文中出现的先后顺序进行排序，先出现的排在前面。
 *
 * 输入描述：
 * 	第一行输入为正整数 topN 和文章数 M，即要输出的出现频率最高的词语的个数和处理文章的数量，由于每篇文章被处理为标题和正文 2 行，因此后面有2 * M行数据。
 * 	从第二行起，是按顺序处理后每篇文章的标题串和正文串，即第二行是第一篇文章的标题串，第三行是第一篇文章的正文串，第四行是第二篇文章的标题串，第五行是第二篇文章的正文串，以此类推。
 *
 * 参数限制如下：
 * 	0 < topN < 1000
 * 	0 < M < 100000
 * 	0 < 每篇文章的词语数 < 5000
 *
 * 输出描述：
 * 使用一行输出出现频率最高的 topN 个词语，每个词语以“ ”隔开。
 *
 * 示例一：
 * 	输入：
 * 		3 2
 * 		xinguan feiyan xinzeng bendi quezhen anli
 * 		ju baodao chengdu xinzeng xinguan feiyan bendi quezhen anli yili shenzhen xinzeng bendi quezhen anli liangli yiqing zhhengti kongzhi lianghao
 * 		xinguan yimiao linchuang shiyan
 * 		wuzhong xinguan yimiao tongguo sanqi linchuang shiyan xiaoguo lianghao
 * 	输出：
 * 		xinguan xinzeng bendi
 * 解释：
 * 	各词语出现频率：
 * 	xinguan=2*3+2=8
 * 	feiyan=1*3+1=4
 * 	xinzeng=1*3+2=5
 * 	bendi=1*3+2=5
 * 	quezhen=1*3+2=5
 * 	anli=1*3+2=5
 * 	yimiao=1*3+1=4
 * 	linchuang=1*3+1=4
 * 	shiyan=1*3+1=4
 * 	返回频率最高的三个词语，有4个词语出现频率都为5，标题出现频率都为3，所以选择先出现的两个词语xinzeng和bendi
 */
public class _查找舆情热词_ {

    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        in.nextLine();

        // key为单词，value为数组，用来保存排序所需的信息
        // 数组种保存的信息是: 单词出现次数 标题中出现次数 标题中的顺序 正文中的顺序
        Map<String, int[]> map = new HashMap<>();
        int title_order = 0;
        int text_order = 0;
        for (int i = 0; i < N; i++) {
            // 标题
            String[] title = in.nextLine().split(" ");
            for (int j = 0; j < title.length; j++) {
                if (!map.containsKey(title[j])) {
                    map.put(title[j], new int[] {3, 1, title_order, -1});
                } else {
                    int[] arr = map.get(title[j]);
                    // 词频加3
                    arr[0] += 3;
                    // 单词在标题中的频率加 1
                    arr[1] += 1;
                    // 如果单词首次出现在标题中
                    arr[2] = arr[2] == -1 ? title_order : arr[2];
                }
                // 标题数量加 1
                title_order++;
            }

            //其次是正文
            String[] text = in.nextLine().split(" ");
            for (int j = 0; j < text.length; j++) {
                if (!map.containsKey(text[j])) {
                    map.put(text[j], new int[] {1, 0, -1, text_order});
                } else {
                    int[] arr = map.get(text[j]);
                    // 词频加 1
                    arr[0] += 1;
                    // 如果单词首次出现在正文中
                    arr[3] = arr[3] == -1 ? title_order : arr[3];
                }
            }
        }

        // Map按value排序，先将map转为list,再排序list(按value值进行排序)
        List<Map.Entry<String, int[]>> list = new ArrayList<Map.Entry<String, int[]>>(map.entrySet());
        list.sort((o1, o2) -> (o1.getValue()[0] == o2.getValue()[0] ? (o1.getValue()[1] == o2.getValue()[1] ?
                (o1.getValue()[2] == o2.getValue()[2] ? (o1.getValue()[3] - o2.getValue()[3])
                        : o1.getValue()[2] - o2.getValue()[2])
                : o2.getValue()[1] - o1.getValue()[1])
                : (o2.getValue()[0] - o1.getValue()[0])));

        // 输出
        for (int i = 0; i < M - 1; i++) {
            Map.Entry<String, int[]> entry = list.get(i);
            System.out.print(entry.getKey() + " ");
        }
        System.out.print(list.get(M - 1).getKey());
    }

}
