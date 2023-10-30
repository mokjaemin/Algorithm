package SofteerPractice;


import java.util.*;

// 2. 순서대로 방문하기 - DFS
public class Practice2 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int[][] map;
    public static List<List<Integer>> roads = new ArrayList<>();
    public static int n;
    public static int m;
    public static int answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 맵의 크기 (~4)
        n = sc.nextInt();

        // 방문해야하는 칸의 수 (~16)
        m = sc.nextInt();

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


        // 로직 실행
        boolean[][] visited = new boolean[n][n];
        visited[start_x][start_y] = true;
        find(start_x, start_y, 1, visited);
        System.out.println(answer);
    }
    public static void find(int now_x, int now_y, int count, boolean[][] visited){
        // 마지막 지점 방문
        if(count == m-1 && now_x == roads.get(count).get(0) && now_y == roads.get(count).get(1)){
            answer += 1;
            return;
        }
        // 다음 지점 처리
        if(now_x == roads.get(count).get(0) && now_y == roads.get(count).get(1)){
            count += 1;
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
            // visited를 여기서 처리하는 이유
            // = 마지막 노드를 이미 방문했는데, 재방문시 결과에 반영 됨.
            visited[next_x][next_y] = true;
            find(next_x, next_y, count, visited);
            visited[next_x][next_y] = false;
        }
    }
}
