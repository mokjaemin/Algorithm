package JAVA.TCT.DP;

import java.util.*;

public class Q5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        dp[0] = 1;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int value2 = 2;
        int value3 = 3;
        int value5 = 5;

        for(int i=1; i<n; i++){
            dp[i] = Math.min(value2, value3);
            dp[i] = Math.min(dp[i], value5);

            if(dp[i] == value2){
                index2 += 1;
                value2 = dp[index2]*2;
            }

            if(dp[i] == value3){
                index3 += 1;
                value3 = dp[index3]*3;
            }

            if(dp[i] == value5){
                index5 += 1;
                value5 = dp[index5]*5;
            }
        }
        System.out.println(dp[n-1]);
    }
}
