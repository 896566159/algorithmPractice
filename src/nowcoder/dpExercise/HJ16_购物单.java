package nowcoder.dpExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ16_购物单 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //先获得总价格和数量
        String[] str = br.readLine().split(" ");
        int money = Integer.parseInt(str[0]);
        int number = Integer.parseInt(str[1]);
        //通过循环获得各商品的v p q，首先需先建立数组
        int[] v = new int[number + 1];
        int[] p = new int[number + 1];
        int[] q = new int[number + 1];
        //q对应的是附件属于哪个主件，需建立参数显示主件对应的附件
        int[] sub1 = new int[number + 1];
        int[] sub2 = new int[number + 1];

        //在循环中对价格进行归一化，由题可知，均为10的倍数，所以先除以100
        int dw = 100;
        boolean flag = true;  //如果有除不尽100的，直接后面均除以10
        for(int i = 1;i < number + 1;i++){
            str = br.readLine().split(" ");
            v[i] = Integer.parseInt(str[0]);
            if(flag && v[i]%dw != 0){
                dw = 10;
                flag = false;
                //需将前面的扩大10倍
                for(int m = 0;m < i;m++){
                    v[m] *= 10;
                    p[m] *= 10;
                }
            }

            v[i] /= dw;
            //将p直接改为价格*权重，减小计算量
            p[i] = Integer.parseInt(str[1]) * v[i];
            q[i] = Integer.parseInt(str[2]);

            //通过q对sub赋值
            if(q[i] > 0){
                if(sub1[q[i]] == 0){
                    sub1[q[i]] = i;
                }else{
                    sub2[q[i]] = i;
                }
            }
        }

        //同样总钱数也要归一化
        money /= dw;

        //动态规划
        int[][] dp = new int[number + 1][money + 1];
        for(int i = 1;i < number + 1;i++){
            int v1 = -1, v2 = -1, v3 = -1;
            int p1 = 0, p2 = 0, p3 = 0;
            if(sub1[i] != 0){
                v1 = v[i] + v[sub1[i]];
                p1 = p[i] + p[sub1[i]];
            }
            if(sub2[i] != 0){
                v2 = v[i] + v[sub2[i]];
                p2 = p[i] + p[sub2[i]];
            }
            if(sub1[i] != 0 && sub2[i] != 0){
                v3 = v1 + v2 -v[i];
                p3 = p1 + p2 - p[i];
            }
            for(int j = 1;j < money + 1;j++){
                dp[i][j] = dp[i-1][j];
                if(q[i] == 0){
                    //先加入主件，看是否获得最大
                    if(j >= v[i]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v[i]] + p[i]);
                    }
                    //加入相应的主件和附件，视为一个整体，判断，首先附件是否存在以及附件价格是否小于j
                    if(v1 != -1 && j >= v1){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v1] + p1);
                    }
                    if(v2 != -1 && j >= v2){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v2] + p2);
                    }
                    if(v3 != -1 && j >= v3){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v3] + p3);
                    }
                }
            }
        }

        System.out.println(dp[number][money] * dw);
    }

}
