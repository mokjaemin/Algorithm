package BAEKJOON_DFSBFS;

import java.util.*;
// 미로 탐색
public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            String num = sc.next();
            for(int j=0; j<m; j++){
                map[i][j] = (int)(num.charAt(j)-48);
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(0)));
        queue.add(Arrays.asList(1, 0, 0));
        boolean[][] visited = new boolean[n][m];
        while(queue.size() > 0){
            List<Integer> now = queue.poll();
            int cost = now.get(0);
            int x = now.get(1);
            int y = now.get(2);
            if(x == n-1 && y == m-1){
                System.out.println(cost);
                return;
            }
            if(visited[x][y]){
                continue;
            }
            visited[x][y] = true;
            for(int i=0; i<4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= m){
                    continue;
                }
                if(map[next_x][next_y] == 0){
                    continue;
                }
                queue.add(Arrays.asList(cost+1, next_x, next_y));
            }
        }
    }
}
