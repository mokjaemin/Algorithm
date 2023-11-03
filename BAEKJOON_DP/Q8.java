package BAEKJOON_DP;


import java.util.*;

// 점프
public class Q8 {
    public static int n;
    public static int[][] map;
    public static long[][] dp;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        dp = new long[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        dfs(0, 0);
        System.out.println(dp[0][0]);
    }
    public static long dfs(int x, int y){
        if(x == n-1 && y == n-1){
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y] = 0;
        for(int i=0; i<2; i++){
            int value = map[x][y];
            int next_x = x + dx[i]*value;
            int next_y = y + dy[i]*value;
            if(next_x >=n | next_y >= n){
                continue;
            }
            dp[x][y] += dfs(next_x, next_y);
        }
        return dp[x][y];
    }
}
