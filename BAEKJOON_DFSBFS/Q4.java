package BAEKJOON_DFSBFS;

import java.util.*;

// 단지 번호 붙이기
public class Q4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            String value = sc.next();
            for(int j=0; j<n; j++){
                map[i][j] = (int)(value.charAt(j)-48);
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int count = 0;
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    List<List<Integer>> queue = new ArrayList<>();
                    queue.add(Arrays.asList(i, j));
                    count += 1;
                    int house_count = 0;
                    while(queue.size() > 0){
                        List<Integer> now = queue.remove(0);
                        int x = now.get(0);
                        int y = now.get(1);
                        if(visited[x][y]){
                            continue;
                        }
                        house_count += 1;
                        visited[x][y] = true;
                        for(int a=0; a<4; a++){
                            int next_x = x + dx[a];
                            int next_y = y + dy[a];
                            if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= n){
                                continue;
                            }
                            if(map[next_x][next_y] == 0){
                                continue;
                            }
                            if(visited[next_x][next_y]){
                                continue;
                            }
                            queue.add(Arrays.asList(next_x, next_y));
                        }
                    }
                    result.add(house_count);
                }
            }
        }
        System.out.println(count);
        Collections.sort(result);
        for(int r : result){
            System.out.println(r);
        }
    }
}
