package BackJoonDfsBfs;


import java.util.*;

// 토마토 - 미해결..
public class Q6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] map = new int[n][m][h];
        List<List<Integer>> queue = new ArrayList<>();
        for(int k=0; k<h; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    map[i][j][k] = sc.nextInt();
                    if(map[i][j][k] == 1){
                        queue.add(Arrays.asList(i, j, k));
                    }
                }
            }
        }
        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, -1, 0, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        int time = 0;
        boolean[][][] visited = new boolean[n][m][h];
        while(queue.size() > 0){
            List<Integer> now = queue.remove(0);
            int x = now.get(0);
            int y = now.get(1);
            int z = now.get(2);
            int value = map[x][y][z];
            if(visited[x][y][z]){
                continue;
            }
            visited[x][y][z] = true;
            time = Math.max(time, value);
            for(int i=0; i<6; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                int next_z = z + dz[i];
                if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= m | next_z < 0 | next_z >= h){
                    continue;
                }
                if(visited[next_x][next_y][next_z]){
                    continue;
                }
                if(map[next_x][next_y][next_z] != 0){
                    continue;
                }
                // 덜 익은, 익은 토마토
                queue.add(Arrays.asList(next_x, next_y, next_z));
                if(value != map[next_x][next_y][next_z]){
                    map[next_x][next_y][next_z] = value + 1;
                }
            }
        }
        boolean success = true;
        for(int k=0; k<h; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j][k] == 0){
                        success = false;
                    }
                }
            }
        }
        if(success){
            System.out.println(time-1);
        }
        else{
            System.out.println(-1);
        }
    }
}
