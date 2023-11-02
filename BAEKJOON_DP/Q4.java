package BAEKJOON_DP;


import java.util.*;

// 파도반 수열
public class Q4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<t; i++){
            values.add(sc.nextInt());
        }
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        for(int i=7; i<=100; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }
        for(int value : values){
            System.out.println(dp[value]);
        }
    }
}
