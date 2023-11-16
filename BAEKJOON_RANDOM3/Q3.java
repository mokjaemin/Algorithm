package BAEKJOON_RANDOM3;


import java.io.*;
import java.util.*;

// 미세먼지 안녕
public class Q3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        List<Integer> cleaner = new ArrayList<>();
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    cleaner.add(i);
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        // T번 반복
        for(int t=0; t<T; t++){
            int[][] dirty_map = new int[R][C];
            // 먼지 확산
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j] >= 1){
                        int value = map[i][j]/5;
                        int count = 0;
                        for(int k=0; k<4; k++){
                            int next_x = i + dx[k];
                            int next_y = j + dy[k];
                            // 범위가 벗어나는 경우
                            if(next_x < 0 | next_x >= R | next_y < 0 | next_y >= C){
                                continue;
                            }
                            // 청소기가 있는 경우
                            if(map[next_x][next_y] == -1){
                                continue;
                            }
                            count += 1;
                            dirty_map[next_x][next_y] += value;
                        }
                        dirty_map[i][j] += map[i][j]-value*count;
                    }
                }
            }

            // 위쪽 청소
            int[][] clean_map = new int[R][C];
            int x = cleaner.get(0);
            for(int i=2; i<C; i++){
                clean_map[x][i] = dirty_map[x][i-1];
            }
            for(int i=x-1; i>=0; i--){
                clean_map[i][C-1] = dirty_map[i+1][C-1];
            }
            for(int i=C-2; i>=0; i--){
                clean_map[0][i] = dirty_map[0][i+1];
            }
            for(int i=1; i<x; i++){
                clean_map[i][0] = dirty_map[i-1][0];
            }
            // 청소 안된 부분 체크
            for(int i=1; i<x; i++){
                for(int j=1; j<C-1; j++){
                    clean_map[i][j] = dirty_map[i][j];
                }
            }
            clean_map[x][0] = -1;

            // 아래 청소
            x = cleaner.get(1);
            for(int i=2; i<C; i++){
                clean_map[x][i] = dirty_map[x][i-1];
            }
            for(int i=x+1; i<R; i++){
                clean_map[i][C-1] = dirty_map[i-1][C-1];
            }
            for(int i=1; i<C; i++){
                clean_map[R-1][i-1] = dirty_map[R-1][i];
            }
            for(int i=R-2; i>x; i--){
                clean_map[i][0] = dirty_map[i+1][0];
            }
            // 청소 안된 부분 체크
            for(int i=x+1; i<R-1; i++){
                for(int j=1; j<C-1; j++){
                    clean_map[i][j] = dirty_map[i][j];
                }
            }
            clean_map[x][0] = -1;

            // 맵 갱신
            map = clean_map;
        }
        int answer = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] != -1){
                    answer += map[i][j];
                }
            }
        }
        System.out.println(answer);
    }
}
