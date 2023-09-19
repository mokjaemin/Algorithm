package JAVA.TCT.ShortestWay;

import java.util.*;

// 화성 탐사
public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> answer = new ArrayList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            for(int a=0; a<n; a++){
                for(int b=0; b<n; b++){
                    map[a][b] = sc.nextInt();
                }
            }
            boolean[][] visited = new boolean[n][n];
            PriorityQueue<List<Integer>> queue
                    = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(0)));
            queue.add(Arrays.asList(map[0][0], 0, 0));
            while(queue.size()>0){
                List<Integer> now = queue.poll();
                int cost = now.get(0);
                int x = now.get(1);
                int y = now.get(2);
                if(x == n-1 && y == n-1){
                    answer.add(cost);
                    break;
                }
                if(visited[x][y]){
                    continue;
                }
                visited[x][y] = true;
                for(int a=0; a<4; a++){
                    int next_x = x+dx[a];
                    int next_y = y+dy[a];
                    if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= n){
                        continue;
                    }
                    if(visited[next_x][next_y]){
                        continue;
                    }
                    queue.add(Arrays.asList(cost+map[next_x][next_y], next_x, next_y));
                }
            }
        }
        for(int result : answer){
            System.out.println(result);
        }
    }
}
