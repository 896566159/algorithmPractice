package nowcoder.outd.hard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在做物理实验时，为了计算物体移动的速率，通过相机等工具周期性的采样物体移动距离。
 * 由于工具故障，采样数据存在误差甚至相误的情况。
 * 需要通过一个算法过滤掉不正确的采样值，不同工具的故意模式存在差异，算法的各关门限会根据工具类型做相应的调整。
 * 请实现一个算法，计算出给定一组采样值中正常值的最长连续周期。
 *
 * 判断第1个周期的采样数据S0是否正确的规则如下(假定物体移动速率不超过10个单元前一个采样周期S[i-1]):
 * 	S[i] <= 0，即为错误值
 * 	S[i] < S[i-1]，即为错误值
 * 	S[i]-S[i-1] >= 10，即为错误值。其它情况为正常值
 *
 * 判断工具是否故障的规则如下:
 * 	在M个周期内，采样数据为错误值的次数为T(次数可以不连续)，则工具故障。
 * 判断故障恢复的条件如下:
 * 	产生故障后的P个周期内，采样数据一直为正常值，则故障恢复
 *
 * 错误采样数据的处理方式:
 * 	检测到故障后，丢弃从故障开始到故障恢复的采样数据
 * 	在检测到工具故障之前，错误的采样数据，则由最近一个正常值代替;如果前面没有正常的采样值，则丢弃此采样数据
 * 给定一段周期的采样数据列表S，计算正常值的最长连续周期。
 *
 * 输入描述：
 * 	故障确认周期数和故障次数门限分别为M和T，故障恢复周期数为P。
 * 	第i个周期，检测点的状态为S[i]。
 * 	输入为两行，格式如下:
 * 	M T P
 * 	s1 s2 s3 ...
 * 	M、T 和 P 的取值范围为[1100000]
 * 	s1取值范围为[0，100000]，从0开始编号
 * 输出描述：
 * 	一行，输出正常值的最长连续周期。
 *
 * 示例：
 * 	输入：
 * 		10 6 3
 * 		-1 1 2 3 100 10 13 9 10
 * 	输出：
 * 		8
 * 说明：第1、5、6这3个周期是错误值
 * 	  没有出现连续的10次采样中，累计错误值次数 >= 3 的情况
 * 	  所以没有出现故障，错误项可以采取恢复
 * 	  第1个错误项的前面没有正确值，所以第1个错误值丢掉
 * 	  第5、6这2个周期的错误值可以用第4个周期的正确值来恢复
 * 	  故恢复后：1 2 3 3 3 13 9 10
 * 	  答案为8
 *
 * 验证示例1：
 * 	输入：
 * 		5 2 3
 * 		-1 1 2 3 100 10 13 9 10
 * 	输出：
 * 		0
 * 说明：第1、5、6这3个周期是错误值
 * 	  且在[1, 5]这5个周期中，错误项到达了2 >= t(2)，故发生故障
 * 	  在故障发生后，没有出现连续的 3 个周期都是正常值，故障一直没有被恢复，数据全部被丢掉
 *
 * 验证示例2：
 * 	输入：
 * 		5 2 3
 * 		-1 1 2 3 100 10 13 14 15
 * 	输出：
 * 		3
 * 说明：第1、5、6这3个周期是错误值
 * 	  且在[1, 5]这5个周期中，错误项到达了2 >= t(2)，故发生故障
 * 	  在故障发生后，有出现连续的 3 个周期都是正常值（最后3项都是正常值），
 * 	  连续正常值项：3 >= P，故障在第7项之后恢复，恢复前的数据丢掉后只剩下3项：13 14 15
 * 	  剩下的3项：13 14 15，都是正常值，保留
 * 	  答案就是3
 */
public class _采样过滤_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        // 故障确认周期数
        int m = Integer.parseInt(split[0]);
        // 故障次数门限
        int t = Integer.parseInt(split[1]);
        // 故障恢复周期数
        int p = Integer.parseInt(split[2]);
        // 检测点状态
        int[] sampleData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = sampleData.length;


        System.out.println("网上的做法：");
        int[] sample_data = new int[n];
        System.arraycopy(sampleData, 0, sample_data, 0, n);
        method(sample_data, m, t, p);
        System.out.println("我的做法：");

        /**
         * 采样数据错误（三种情况会导致错误值）
         * 工具是否故障（M个周期内，累计错误次数为T）
         *      工具故障恢复：产生故障后的P个周期内，采样数据是否一直正常，是——恢复，否——还是故障
         * 错误采样数据处理：
         *      ①工具未发生故障前，
         *          错误采样数据用最近的一个正常值来替代
         *          如果前面没有正常的采样数据，则丢弃此数据
         *      ②工具发生故障，丢弃从 故障开始到故障恢复之间的 采样数据
         */
        // 标记采样错误数据项
        int[] errorData = new int[n];
        for (int i = 0; i < n; i++) {
            //S[i] <= 0、 S[i] < S[i-1]、 S[i]-S[i-1] >= 10，即为错误值。其它情况为正常值
            if (sampleData[i] <= 0
                    || (i > 0 &&
                    (sampleData[i] < sampleData[i - 1] || sampleData[i] - sampleData[i - 1] >= 10))) {
                errorData[i] = 1;
            } else {
                errorData[i] = 0;
            }
        }

        int index = 0;
        while (index < n) {
            // 检测工具故障发生——M个周期内，累计错误次数为T
            int countError = 0;
            int j = index;
            int start = j;

            // 找到故障发生的开始位置: M个周期内，累计错误次数为T
            while (j < n) {
                // 当前采样错误，检查连续的 M个周期内，累计错误次数为 T
                if (errorData[j] == 1) {
                    // 统计连续的 M个周期内，累计错误次数
                    start = j;
                    int end = start;
                    while (end < n && end < j + m) {
                       if (errorData[end] == 1) {
                           // 错误次数增加
                           countError++;
                       }
                        end++;
                    }
                    // 发生了故障：连续的 M个周期内，累计错误次数为 T
                    if (countError >= t) {
                        j = end;
                        break;
                    } else {
                        // 错误数据清零
                        countError = 0;
                        // 工具未发生故障前，错误采样数据用最近的一个正常值来替代，或者丢弃掉该采样错误的数据
                        if (j > 0 && t > countError && errorData[j - 1] == 0) {
                            // 用最近的一个正常值来替代
                            errorData[j] = 0;
                            sampleData[j] = sampleData[j - 1];
                        } else {
                            // 丢弃掉该采样错误的数据
                            errorData[j] = 2;
                        }
                    }
                }
                j++;
            }

            // 工具发生故障：M个周期内，累计错误次数为T
            // 工具故障恢复：产生故障后的P个周期内，采样数据是否一直正常，是——恢复，否——还是故障
            // 工具发生故障，丢弃从 故障开始到故障恢复之间的 采样数据
            if (countError == t) {
                // 丢弃从 故障开始到故障恢复之间的 采样数据
                for (int i = start; i < j; i++) {
                    errorData[i] = 2;
                }

                // 故障：[start， j - 1]，这 m 个区间内。从 j 开始，找到 故障恢复点
                while (j < n) {
                    if (errorData[j] == 0) {
                        // 从此点开始，连续的 p 个周期是否都正常
                        int k = j;
                        while (k < n && errorData[k] == 0) {
                            k++;
                        }
                        // 故障恢复
                        if (k - j + 1 >= p) {
                            break;
                        }
                    }
                    // 工具发生故障，丢弃从 故障开始到故障恢复之间的 采样数据
                    errorData[j] = 2;
                    j++;
                }
            }

            // 发生-恢复、没发生、继续，发生-没恢复不继续
            index = j;
        }

        // 2-丢弃的数据，1-错误数据，0-正常采样数据
        int res = 0;
        int location = 0;
        for (int item : errorData) {
            if (item != 0) {
                if (location > res) {
                    res = location;
                }
                location = 0;
            } else {
                location += 1;
            }
        }
        System.out.println(Math.max(res, location));
    }

    static void method(int[] sample_data, int m, int t, int p) {
        // 判断数据异常
        int[] items = new int[sample_data.length];
        for (int i=0;i<sample_data.length;i++) {
            if (sample_data[i] <= 0) {
                items[i] = 0;
            } else if (i > 0 && ((sample_data[i] - sample_data[i - 1] >= 10) || sample_data[i] < sample_data[i - 1])) {
                items[i] = 0;
            } else {
                items[i] = 1;
            }
        }

        //
        int i = 0;
        while (i < sample_data.length) {
            //可以用之前数据替代的情况
            if (items[i] == 0 && i > 0 && items[i - 1] == 1) {
                sample_data[i] = sample_data[i - 1];
                items[i] = 1;
            }
            int error_num=0;
            int corrent =0;
            int j = i;

            //求得采样错误总数量
            while (m > 0 && j < sample_data.length) {
                if (items[j] == 0) {
                    error_num += 1;
                    if (error_num >= t) {
                        if (j > 0) {
                            corrent = j - 1;
                        } else {
                            corrent = 0;
                        }
                    }
                }
                j += 1;
            }

            // 大于故障次数门限 T
            if (error_num >= t) {
                boolean pos= false;
                int k = 0;
                while (k < i && items[k] != 1) {
                    k += 1;
                }
                pos = true;

                if (i + t == sample_data.length - 1) {
                    k = i;
                    while (k < corrent + 1) {
                        sample_data[k] = sample_data[i - 1];
                        items[k] = 1;
                        k += 1;
                    }
                    break;
                } else if (i + m <= sample_data.length) {
                    for (int l = i;l<sample_data.length; l++) {
                        if (l < corrent +1) {
                            if (i > 0) {
                                sample_data[l] = sample_data[i-1];
                            } else {
                                sample_data[l] = sample_data[0];
                            }
                            items[l] = 1;
                        } else {
                            items[l] = 0;
                        }
                    }
                } else {
                    for (int q = i; q < i+m;q++) {
                        if (q < corrent + 1) {
                            sample_data[q] = sample_data[i -1];
                            items[q] = 1;
                        } else {
                            items[q] = 0;
                        }
                    }
                    if (i + m + p >= sample_data.length + 1) {
                        for (int k_1 = i;k_1<sample_data.length; k_1++) {
                            items[k_1] = 0;
                        }
                        items[k] = 0;
                        i = k +p;
                    }
                }
            } else {
                i += 1;
            }
        }

        int res = 0;
        int location = 0;
        for (int item : items) {
            if (item != 1) {
                if (location > res) {
                    res = location;
                }
                location = 0;
            } else {
                location += 1;
            }
        }
        System.out.println(Math.max(res, location));
    }
}
