package JAVA.TCT.DP;

import java.util.*;

// 1로 만들기
public class Practice1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=n; i++){
            if(i % 5 == 0){
                dp[i] = Math.min(dp[i], dp[i/5]+1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            dp[i] = Math.min(dp[i], dp[i-1]+1);
            System.out.print(i);
            System.out.print(" ");
            System.out.println(dp[i]);
        }
        
    }
}
