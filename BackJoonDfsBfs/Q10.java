package BackJoonDfsBfs;


import java.util.*;

// 빙산
public class Q10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int time = 0;
        boolean success = false;
        while(true){
            // 1. 녹는 양 측정
            List<List<Integer>> melt = new ArrayList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] >= 1){
                        int count = 0;
                        for(int k=0; k<4; k++){
                            int next_x = i + dx[k];
                            int next_y = j + dy[k];
                            if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= m){
                                continue;
                            }
                            if(map[next_x][next_y] == 0){
                                count += 1;
                            }
                        }
                        melt.add(Arrays.asList(i, j, count));
                    }
                }
            }
            // 2. 녹이기
            for(List<Integer> ice : melt){
                int x = ice.get(0);
                int y = ice.get(1);
                map[x][y] -= ice.get(2);
                if(map[x][y] < 0){
                    map[x][y] = 0;
                }
            }
            if(melt.size() == 0){
                break;
            }
            time += 1;

            // 3. 그룹 세기
            int count = 0;
            boolean[][] visited = new boolean[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] >= 1 && !visited[i][j]){
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
                                if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= m){
                                    continue;
                                }
                                if(map[next_x][next_y] >= 1){
                                    queue.add(Arrays.asList(next_x, next_y));
                                }
                            }
                        }
                    }
                }
            }
            // 4. 그룹이 분리되었다면 종료
            if(count >= 2){
                success = true;
                break;
            }
        }
        if(success){
            System.out.println(time);
        }
        else{
            System.out.println(0);
        }
    }
}
