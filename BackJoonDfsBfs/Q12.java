package BackJoonDfsBfs;

import java.util.*;

// 로봇 청소기
public class Q12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] pos = {sc.nextInt(), sc.nextInt()};
        int dir = sc.nextInt();
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        // 0 - 청소되지 않은 칸, 1 - 벽

        // 북, 동, 남, 서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int result = 0;
        while(true){
            // 1. 현재 칸이 청소되지 않는 경우 청소한다.
            if(map[pos[0]][pos[1]] == 0){
                result += 1;
                // - 맵에 청소 처리
            }
            // 2. 주변 청소 칸 여부 체크
            boolean success = false;
            for(int i=1; i<=4; i++){
                int next_dir = dir - i;
                if(next_dir < 0){
                    next_dir += 4;
                }
                int next_x = pos[0] + dx[next_dir];
                int next_y = pos[1] + dy[next_dir];
            }
        }
    }
}
