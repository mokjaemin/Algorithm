package BAEKJOON_DFSBFS;


import java.util.*;

// 안전 영역
public class Q9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int answer = 0;
        for(int height=0; height<=100; height++){
            boolean[][] visited = new boolean[n][n];
            int count = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j] && map[i][j] > height){
                        List<List<Integer>> queue = new ArrayList<>();
                        queue.add(Arrays.asList(i, j));
                        count += 1;
                        while(queue.size() > 0){
                            List<Integer> now = queue.remove(0);
                            int x = now.get(0);
                            int y = now.get(1);
                            if(visited[x][y]){
                                continue;
                            }
                            visited[x][y] = true;
                            for(int k=0; k<4; k++){
                                int next_x = x + dx[k];
                                int next_y = y + dy[k];
                                if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= n){
                                    continue;
                                }
                                if(visited[next_x][next_y]){
                                    continue;
                                }
                                if(map[next_x][next_y] <= height){
                                    continue;
                                }
                                queue.add(Arrays.asList(next_x, next_y));
                            }
                        }
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
