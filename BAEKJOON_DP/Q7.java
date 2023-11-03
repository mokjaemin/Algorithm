package BAEKJOON_DP;


import java.util.*;

// 내리막 길, DP+DFS, Q8과 유사
public class Q7 {
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static long[][] dp = new long[501][501];
    public static int n;
    public static int m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // 맵 생성
        map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        dfs(0, 0);
        System.out.println(dp[0][0]);
    }
    public static long dfs(int x, int y){
        // 목적지 도달
        if(x == n-1 && y == m-1){
            return 1;
        }
        // 이미 방문 한 노드
        if(dp[x][y] != -1){
            // (x, y)에서 (n-1, m-1)까지 갈 수 있는 경우의 수 반환
            return dp[x][y];
        }
        // 방문처리 및 값 초기화
        dp[x][y] = 0;
        // 인접 노드 탐색
        for(int i=0; i<4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            // 범위 벗어남
            if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= m){
                continue;
            }
            // 다음 노드가 현재 노드가 작을때만 이동
            if(map[next_x][next_y] < map[x][y]){
                // 해당 노드에서 목적지까지 가는 모든 경우의 수 더한다.
                dp[x][y] += dfs(next_x, next_y);
            }
        }
        return dp[x][y];
    }
}
