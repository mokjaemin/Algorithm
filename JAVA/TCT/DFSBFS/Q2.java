package JAVA.TCT.DFSBFS;

import java.util.*;

// 연구소
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        List<List<Integer>> empty = new ArrayList<>();
        List<List<Integer>> viruses = new ArrayList<>();
        int countTotal = 0;
        int countWall = 3;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 0){
                    empty.add(Arrays.asList(i, j));
                }
                if(map[i][j] == 2){
                    viruses.add(Arrays.asList(i, j));
                }
                if(map[i][j] == 1){
                    countWall += 1;
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int len = empty.size();
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    // install
                    map[empty.get(i).get(0)][empty.get(i).get(1)] = 1;
                    map[empty.get(j).get(0)][empty.get(j).get(1)] = 1;
                    map[empty.get(k).get(0)][empty.get(k).get(1)] = 1;
                    
                    // spread
                    boolean[][] visited = new boolean[n][m];
                    int countVirus = 0;
                    for(List<Integer> virus : viruses){
                        int x = virus.get(0);
                        int y = virus.get(1);
                        if(visited[x][y]){
                            continue;
                        }
                        Queue<List<Integer>> queue = new LinkedList<>();
                        queue.add(Arrays.asList(x, y));
                        while(queue.size() > 0){
                            List<Integer> now = queue.poll();
                            int now_x = now.get(0);
                            int now_y = now.get(1);
                            if(visited[now_x][now_y]){
                                continue;
                            }
                            visited[now_x][now_y] = true;
                            countVirus += 1;
                            for(int a=0; a<4; a++){
                                int next_x = now_x + dx[a];
                                int next_y = now_y + dy[a];
                                if(next_x < 0 | next_y < 0 | next_x >= n | next_y >= m){
                                    continue;
                                }
                                if(map[next_x][next_y] == 1){
                                    continue;
                                }
                                queue.add(Arrays.asList(next_x, next_y));
                            }
                        }
                    }
                    // count
                    countTotal = Math.max(countTotal, n*m-countVirus-countWall);
                    
                    // // uninstall
                    map[empty.get(i).get(0)][empty.get(i).get(1)] = 0;
                    map[empty.get(j).get(0)][empty.get(j).get(1)] = 0;
                    map[empty.get(k).get(0)][empty.get(k).get(1)] = 0;
                }
            }
        }
        System.out.println(countTotal);
    }
}
