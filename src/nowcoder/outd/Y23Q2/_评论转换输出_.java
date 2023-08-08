package nowcoder.outd.Y23Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 在一个博客网站上，每篇博客都有评论。每一条评论都是一个 非空英文字母字符串。
 * 评论具有树状结构，除了根评论外，每个评论都有一个父评论。
 * 当评论保存时，使用以下格式：
 * 	首先是评论的内容,
 * 	然后是回复当前评论的数量。
 * 	最后是当前评论的所有子评论。（子评论使用相同的格式嵌套存储）
 *
 * 例如：
 * 	第一条评论是"hello,2,ok,0,bye,0"，
 * 	第二条评论是"test,0"，
 * 	第三条评论是"one,1,two,1,a,0"
 * 所有评论被保存成"hello,2,ok,0,bye,0,test,0,one,1,two,1,a,0"。
 * 对于上述格式的评论，请以另外一种格式打印:
 * 首先打印评论嵌套的最大深度。
 * 然后是打印n行，第i(1<=i<=n)行对应于嵌套级别为的评论 (根评论的嵌套级别为1)对于第i行，嵌套级别为的评论按照它们出现的顺序打印，用空格分隔开。
 *
 *
 * 输入描述:
 * 	1行评论。由英文字母、数字和英文逗号组成
 * 	保证每个评论都是由英文字符组成的非空字符串
 * 	每个评论的数量都是整数 (至少由一个数字组成)
 * 	整个字符串的长度不超过106.
 * 	给定的评论结构保证是合法的。
 * 输出描述:
 * 	按照给定的格式打印评论。对于每一级嵌套，评论应该按照输入中的顺序打印
 *
 * 示例1
 * 	输入:
 * 		hello,2,ok,0,bye,0,test,0,one,1,two,1,a,0
 * 	输出:
 * 		3
 * 		hello test one
 * 		ok bye two
 * 		a
 * 说明:
 * 	如题目描述中图所示，最大嵌套级别为3。
 * 	嵌套级别为1的评论是"hello test one”，
 * 	嵌套级别为2的评论是"ok bvetwo"，
 * 	嵌套级别为3的评论为"a"。
 *
 * 示例2
 * 	输入:
 * 		A,5,A,0,a,0,A,0,a,0,A,0
 * 	输出:
 * 		2
 * 		A
 * 		A a A a A
 * 说明:
 * 	如下图所示，最大嵌套级别为2，
 * 	嵌套级别为1的评论是"A"，
 * 	嵌套级别为2的评论是"A a A a A"
 *
 * 示例3
 * 	输入:
 * 		A,3,B,2,C,0,D,1,E,0,F,1,G,0,H,1,I,1,J,0,K,1,L,0,M,2,N,0,O,1,P,0
 * 	输出:
 * 		4
 * 		A K M
 * 		B F H L N O
 * 		C D G I P
 * 		E J
 * 说明: 如下图所示。
 */
public class _评论转换输出_ {

    static List<List<String>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int index = 0;
        while (index < split.length) {
            index = f(split, 0, index);
        }

        int size = res.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static int f(String[] split, int level, int index) {
        if (index >= split.length) {
            return split.length;
        }

        // 确保当前层级的列表不为空，否则会空指针异常
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(split[index]);
        int children = Integer.parseInt(split[index + 1]);
        // 如果没有子节点，返回索引 +2
        if (children == 0) {
            return index + 2;
        }

        boolean isFisrt = true;
        while (children > 0 && index < split.length) {
            // 第一个子节点的索引 = 当前索引 + 2，其余节点的索引 = 上一个兄弟节点的返回值
            if (isFisrt) {
                isFisrt = false;
                index = f(split, level + 1, index + 2);
            } else {
                index = f(split, level + 1, index);
            }
            // 节点数量 - 1
            children--;
        }

        return index;
    }

}
