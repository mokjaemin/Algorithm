package BAEKJOON_RANDOM2;


import java.util.*;

// 진우의 달 여행
public class Q3 {
    public static int[] dy = {-1, 0, 1};
    public static int n;
    public static int m;
    public static int[][] map;
    public static int answer = (int)1e9;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int y=0; y<m; y++){
            dfs(0, y, -1, map[0][y]);
        }
        System.out.println(answer);
    }
    public static void dfs(int x, int y, int last, int sum){
        if(x == n-1){
            answer = Math.min(answer, sum);
            return;
        }
        for(int i=0; i<3; i++){
            // 저번에 처리한 방향
            if(i == last){
                continue;
            }
            int next_x = x + 1;
            int next_y = y + dy[i];
            if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= m){
                continue;
            }
            dfs(next_x, next_y, i, sum+map[next_x][next_y]);
        }
    }
}
