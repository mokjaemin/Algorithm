package JAVA.TCT.Samsung;


import java.util.*;

// 아기 상어
public class Q1 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int size = 2;
    public static int[][] map;
    public static int[] pos = new int[2];
    public static int n;

    public static void main(String[] args){
        // 기본정보 받기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9){
                    pos[0] = i;
                    pos[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        // 시간
        int time = 0;
        int fish_eat = 0;

        while(true){
            // 먹을 수 있는 물고기의 수와 위치, 거리 구하기
            List<List<Integer>> fishes = new ArrayList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] < size && map[i][j] != 0){
                        int distance = check(i, j);
                        if(distance != -1){
                            fishes.add(Arrays.asList(distance, i, j));
                        }
                    }
                }
            }
            // 먹을 수 있는 물고기가 없다면 종료
            if(fishes.size() == 0){
                break;
            }
            // 먹기 로직
            // 정렬
            Collections.sort(fishes, Comparator
                    .comparing((List<Integer> arr) -> arr.get(0))
                    .thenComparing(arr -> arr.get(1))
                    .thenComparing(arr -> arr.get(2)));
            // 결과 생선
            int fish_x = fishes.get(0).get(1);
            int fish_y = fishes.get(0).get(2);
            // 상어 크기 증가
            fish_eat += 1;
            while(fish_eat >= size){
                fish_eat -= size;
                size += 1;
            }
            // 상어 위치 변경
            pos[0] = fish_x;
            pos[1] = fish_y;
            // 생선 제거
            map[fish_x][fish_y] = 0;
            // 시간 증가
            time += fishes.get(0).get(0);
        }
        System.out.println(time);
    }
    public static int check(int end_x, int end_y){
        PriorityQueue<List<Integer>> queue
                = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(0)));
        queue.add(Arrays.asList(0, pos[0], pos[1]));
        boolean[][] visited = new boolean[n][n];
        while(queue.size() > 0){
            List<Integer> now = queue.poll();
            int cost = now.get(0);
            int now_x = now.get(1);
            int now_y = now.get(2);
            if(now_x == end_x && now_y == end_y){
                return cost;
            }
            if(visited[now_x][now_y]){
                continue;
            }
            visited[now_x][now_y] = true;
            for(int i=0; i<4; i++){
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= n){
                    continue;
                }
                if(visited[next_x][next_y]){
                    continue;
                }
                if(map[next_x][next_y] > size){
                    continue;
                }
                queue.add(Arrays.asList(cost+1, next_x, next_y));
            }
        }
        return -1;
    }

}
