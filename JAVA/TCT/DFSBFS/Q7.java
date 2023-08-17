package JAVA.TCT.DFSBFS;

import java.util.*;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int answer = 0;
        while(true){
            boolean success = false;
            boolean[][] visited = new boolean[n][n];
            for(int x=0; x<n; x++){
                for(int y=0; y<n; y++){
                    if(visited[x][y]){
                        continue;
                    }
                    Queue<List<Integer>> queue = new LinkedList<>();
                    queue.add(Arrays.asList(x, y));
                    int count = 0;
                    int sum = 0;
                    List<List<Integer>> indexes = new ArrayList<>();
                    while(queue.size() > 0){
                        List<Integer> now = queue.poll();
                        int now_x = now.get(0);
                        int now_y = now.get(1);
                        if(visited[now_x][now_y]){
                            continue;
                        } 
                        visited[now_x][now_y] = true;
                        count += 1;
                        sum += map[now_x][now_y];
                        indexes.add(Arrays.asList(now_x, now_y));
                        for(int i=0; i<4; i++){
                            int next_x = now_x + dx[i];
                            int next_y = now_y + dy[i];
                            // 범위 처리
                            if(next_x < 0 | next_y < 0 | next_x >= n | next_y >= n){
                                continue;
                            }
                            // 방문 처리
                            if(visited[next_x][next_y]){
                                continue;
                            }
                            // 조건 처리
                            int value = Math.abs(map[next_x][next_y]-map[now_x][now_y]);
                            if(value < l){
                                continue;
                            }
                            if(value > r){
                                continue;
                            }
                            queue.add(Arrays.asList(next_x, next_y));
                        }
                    }
                    if(indexes.size() > 1){
                        success = true;
                    }
                    for(List<Integer> index : indexes){
                        map[index.get(0)][index.get(1)] = sum/count;
                    }
                }
            }
            if(!success){
                break;
            }           
            answer += 1; 
        }
        System.out.println(answer);
    }
}
