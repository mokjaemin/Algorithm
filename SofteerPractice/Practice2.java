package SofteerPractice;


import java.util.*;

// 2. 순서대로 방문하기 - DFS 깊이 우선 탐색
public class Practice2 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int[][] map;
    public static List<List<Integer>> roads = new ArrayList<>();
    public static int n;
    public static int end_x;
    public static int end_y;
    public static int answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 맵의 크기 (~4)
        n = sc.nextInt();
        // 방문해야하는 칸의 수 (~16)
        int m = sc.nextInt();
        // 0은 빈칸, 1은 벽
        map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        // 지나가야하는 경로
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            roads.add(Arrays.asList(x-1, y-1));
        }
        // 시작 지점
        int start_x = roads.get(0).get(0);
        int start_y = roads.get(0).get(1);
        // 끝 지점
        end_x = roads.get(m-1).get(0);
        end_y = roads.get(m-1).get(1);
        find(start_x, start_y, new boolean[n][n]);
        System.out.println(answer);
    }
    public static void find(int now_x, int now_y, boolean[][] visited){
        // 마지막 지점 방문
        if(now_x == end_x && now_y == end_y){
            boolean success = true;
            // 마지막 지점 빼고 모두 방문했는지 확인
            for(int i=0; i<roads.size()-1; i++){
                if(!visited[roads.get(i).get(0)][roads.get(i).get(1)]){
                    success = false;
                    break;
                }
            }
            // 목표 다 방문시 정답처리
            if(success){
                answer += 1;
            }
            return;
        }
        // 상하좌우 이동
        for(int i=0; i<4; i++){
            int next_x = now_x + dx[i];
            int next_y = now_y + dy[i];
            // 범위 벗어남
            if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= n){
                continue;
            }
            // 이미 방문
            if(visited[next_x][next_y]){
                continue;
            }
            // 벽
            if(map[next_x][next_y] == 1){
                continue;
            }
            visited[now_x][now_y] = true;
            find(next_x, next_y, visited);
            visited[now_x][now_y] = false;
        }
    }
}
