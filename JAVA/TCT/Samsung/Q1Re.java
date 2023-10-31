package JAVA.TCT.Samsung;

import java.util.*;

// 아기 상어
public class Q1Re {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int shark_size = 2;
    public static int n;
    public static int[][] map;
    public static int[] shark_pos = new int[2];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 맵의 크기 (2~20)
        n = sc.nextInt();
        // (0)빈칸, (1,2,3,4,5,6)물고기, (9)상어
        map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9){
                    shark_pos[0] = i;
                    shark_pos[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        int eat = 0;

        while(true){
            // 1. 먹을 수 있는 물고기 찾기
            // - 거리, x, y
            List<Integer> eat_fish = find();
            // - 먹을 수 있는 물고기가 없다면 종료
            if(eat_fish == null){
                break;
            }
            // - 물고기를 먹으면 빈칸이 된다.
            // - 상어 위치 변경
            int x = eat_fish.get(1);
            int y = eat_fish.get(2);
            map[x][y] = 0;
            shark_pos[0] = x;
            shark_pos[1] = y;

            // 2. 상어 크기 증가
            // - 자신의 크기만큼의 물고기 수를 먹어야 1증가
            eat += 1;
            if(eat == shark_size){
                shark_size += 1;
                eat = 0;
            }

            // 3. 거리만큼 시간 증가
            time += eat_fish.get(0);
        }
        System.out.println(time);
    }
    // 먹을 수 있는 물고기 찾기 함수 - BFS
    public static List<Integer> find() {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> queue = new ArrayList<>();
        queue.add(Arrays.asList(1, shark_pos[0], shark_pos[1]));
        boolean[][] visited = new boolean[n][n];
        while (queue.size() > 0) {
            List<Integer> now = queue.remove(0);
            int distance = now.get(0);
            int x = now.get(1);
            int y = now.get(2);
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                if (next_x < 0 | next_x >= n | next_y < 0 | next_y >= n) {
                    continue;
                }
                int value = map[next_x][next_y];
                // - 자신보다 크기가 큰 물고기 칸은 지나갈 수 없다.
                if (value > shark_size) {
                    continue;
                }
                // 빈칸이거나 같은 크기의 물고기인 경우
                if (value == 0 | value == shark_size) {
                    queue.add(Arrays.asList(distance+1, next_x, next_y));
                    continue;
                }
                // 작으면 먹을 수 있다.
                if (value < shark_size) {
                    // 거리값
                    result.add(Arrays.asList(distance, next_x, next_y));
                }
            }
        }
        if (result.size() == 0) {
            return null;
        }
        // - 많다면, 지나가야하는 칸의 개수가 작고 위쪽, 왼쪽일수록 가깝다로 처리
        Collections.sort(result, Comparator.comparing((List<Integer> arr) -> arr.get(0))
                .thenComparing(arr -> arr.get(1))
                .thenComparing(arr -> arr.get(2)));
        return result.get(0);
    }
}
