package BAEKJOON_DP;


import java.util.*;

// 퇴사 2
public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][2];
        for(int i=0; i<n; i++){
            // 소요일
            map[i][0] = sc.nextInt();
            // 수당
            map[i][1] = sc.nextInt();
        }
        long max_value = 0;
        long[] dp = new long[n];
        for(int i=n-1; i>=0; i--){
            // 소요일
            int duration = map[i][0];
            // 수당
            int money = map[i][1];
            // 다음 일 가능한 날짜
            int next = i + duration;
            // 퇴사전까지 일 못끝냄
            if(duration + i > n){
                dp[i] = max_value;
                continue;
            }
            // 마지막날을 체크하는 경우
            if(i == n-1){
                dp[i] = money;
                max_value = Math.max(max_value, money);
                continue;
            }
            // 마지막날까지 일해야하는 경우
            if(next == n){
                dp[i] = Math.max(max_value, money);
                max_value = Math.max(max_value, dp[i]);
                continue;
            }
            dp[i] = Math.max(max_value, money+dp[next]);
            max_value = Math.max(max_value, dp[i]);
        }
        System.out.println(max_value);
    }
}
