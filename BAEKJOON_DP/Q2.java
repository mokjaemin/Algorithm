package BAEKJOON_DP;


import java.util.*;

// 스티커
public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for(int a=0; a<t; a++){
            int n = sc.nextInt();
            int[][] point = new int[2][n];
            for(int i=0; i<2; i++){
                for(int j=0; j<n; j++){
                    point[i][j] = sc.nextInt();
                }
            }
            if(n == 1){
                System.out.println(Math.max(point[0][0], point[1][0]));
                continue;
            }
            if(n == 2){
                System.out.println(Math.max(point[0][0]+point[1][1], point[0][1]+point[1][0]));
                continue;
            }
            int[][] dp = new int[2][n];
            dp[0][0] = point[0][0];
            dp[1][0] = point[1][0];
            dp[0][1] = point[1][0]+point[0][1];
            dp[1][1] = point[0][0]+point[1][1];
            for(int i=2; i<n; i++){
                int value0 = Math.max(dp[0][i-2], dp[1][i-1]);
                value0 = Math.max(value0, dp[1][i-2]);
                int value1 = Math.max(dp[1][i-2], dp[0][i-1]);
                value1 = Math.max(value1, dp[0][i-2]);
                dp[0][i] = value0 + point[0][i];
                dp[1][i] = value1 + point[1][i];
            }
            result.add(Math.max(dp[0][n-1], dp[1][n-1]));
        }
        for(int answer : result){
            System.out.println(answer);
        }
    }
}
