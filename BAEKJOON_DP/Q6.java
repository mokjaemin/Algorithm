package BAEKJOON_DP;


import java.util.Scanner;

// 타일 채우기
public class Q6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        for(int i=4; i<=n; i+=2){
            dp[i] = 3*dp[i-2];
            for(int j=4; j<=i; j+=2){
                dp[i] += 2*dp[i-j];
            }
        }
        System.out.println(dp[n]);
    }
}
