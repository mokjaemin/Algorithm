package JAVA.TCT.DFSBFS;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[n][n];

        List<List<List<Integer>>> values = new ArrayList<>();
        for(int i=0; i<=k; i++){
            values.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 0){
                    continue;
                }
                values.get(map[i][j]).add(Arrays.asList(i, j));
            }
        }
        int sec = sc.nextInt();
        int end_x = sc.nextInt();
        int end_y = sc.nextInt();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        

        // 시간
        for(int i=0; i<sec; i++){
            // 값
            for(int j=1; j<=k; j++){
                List<List<Integer>> now = values.remove(j);
                List<List<Integer>> next = new ArrayList<>();
                for(List<Integer> value : now){
                    int now_x = value.get(0);
                    int now_y = value.get(1);
                    for(int a=0; a<4; a++){
                        int next_x = now_x + dx[a];
                        int next_y = now_y + dy[a];
                        if(next_x < 0 | next_y < 0 | next_x >= n | next_y >= n){
                            continue;
                        }
                        if(map[next_x][next_y] == 0){
                            map[next_x][next_y] = j;
                            next.add(Arrays.asList(next_x, next_y));
                        }
                    }
                }
                values.add(j, next);
            }
        }
        System.out.println(map[end_x-1][end_y-1]);
    }
}
