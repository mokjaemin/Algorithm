package JAVA.TCT.DFSBFS;

import java.util.*;

// 음료수 얼려 먹기
public class Practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nm = scanner.nextLine();
        int n = (int)(nm.charAt(0) - 48);
        int m = (int)(nm.charAt(2) - 48);
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            String now = scanner.nextLine();
            for(int j=0; j<m; j++){
                map[i][j] = (int)(now.charAt(j)-48);
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    List<List<Integer>> queue = new ArrayList<>();
                    queue.add(Arrays.asList(i, j));
                    answer += 1;
                    while(queue.size() > 0){
                        List<Integer> now = queue.remove(0);
                        map[now.get(0)][now.get(1)] = -1;
                        for(int a=0; a<4; a++){
                            int next_x = now.get(0)+dx[a];
                            int next_y = now.get(1)+dy[a];
                            if(next_x < 0 | next_y < 0 | next_x >=n | next_y >=m){
                                continue;
                            }
                            if(map[next_x][next_y] == 0){
                                queue.add(Arrays.asList(next_x, next_y));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
