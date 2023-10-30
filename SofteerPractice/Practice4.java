package SofteerPractice;

import java.util.*;

// 4. Garage Game - 구현, DFS, BFS
public class Practice4 {
    public static int answer = 0;
    public static int n;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // ~ 15
        n = sc.nextInt();
        int[][] map = new int[3*n][n];
        // Map 입력
        for(int i=0; i<3*n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        // 로직 - BFS/DFS
        // 1. 카고에서 한칸 선택
        // 2. 점수 구하기
        // 3. 맵 갱신
        // 4. 재귀
        logic(map, 0, 0);
        System.out.println(answer);
    }
    public static void logic(int[][] map, int count, int point){
        if(count == 3){
            answer = Math.max(answer, point);
            return;
        }
        boolean[][] visited = new boolean[3*n][n];
        for(int x=2*n; x<3*n; x++){
            for(int y=0; y<n; y++){
                if(visited[x][y]){
                    continue;
                }
                // 1. BFS, 카고에서 한칸 선택
                List<List<Integer>> result = new ArrayList<>();
                List<List<Integer>> poses = new ArrayList<>();
                poses.add(Arrays.asList(x, y));
                int value = map[x][y];
                while(poses.size() > 0){
                    List<Integer> pos = poses.remove(0);
                    int now_x = pos.get(0);
                    int now_y = pos.get(1);
                    if(visited[now_x][now_y]){
                        continue;
                    }
                    visited[now_x][now_y] = true;
                    result.add(Arrays.asList(now_x, now_y));
                    for(int i=0; i<4; i++){
                        int next_x = now_x + dx[i];
                        int next_y = now_y + dy[i];
                        if(next_x < 2*n | next_x >= 3*n | next_y < 0 | next_y >= n){
                            continue;
                        }
                        if(map[next_x][next_y] != value){
                            continue;
                        }
                        if(visited[next_x][next_y]){
                            continue;
                        }
                        poses.add(Arrays.asList(next_x, next_y));
                    }
                }
                // 2. 점수 구하기
                int size = result.size();
                int min_x = 2*n;
                int max_x = 0;
                int min_y = n;
                int max_y = 0;
                for(List<Integer> pos : result){
                    min_x = Math.min(min_x, pos.get(0));
                    max_x = Math.max(max_x, pos.get(0));
                    min_y = Math.min(min_y, pos.get(1));
                    max_y = Math.max(max_y, pos.get(1));
                }
                int plus_point = size + (max_x-min_x+1)*(max_y-min_y+1);

                // 3. 맵 갱신
                Collections.sort(result, Comparator.comparing(arr -> arr.get(0)));
                int[][] new_map = new int[3*n][n];
                for(int i=0; i<3*n; i++){
                    for(int j=0; j<n; j++){
                        new_map[i][j] = map[i][j];
                    }
                }
                for(List<Integer> pos : result){
                    int pos_x = pos.get(0);
                    int pos_y = pos.get(1);
                    for(int i=pos_x; i>0; i--){
                        new_map[i][pos_y] = new_map[i-1][pos_y];
                    }
                    new_map[0][pos_y] = 0;
                }

                // 4. DFS
                logic(new_map, count+1, point+plus_point);
            }
        }
    }
}