package JAVA.TCT.Samsung;


import java.util.*;

// 어른 상어
public class Q3 {

    public static int[][] map;
    public static int[][] smellNumMap;
    public static int[][] smellCountMap;

    // 상, 하, 좌, 우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    // 상어 방향
    public static int[] now_dir;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // 조건
        // 상어는 1~M 번호를 갖는다.
        // 번호가 작을수록 강력하다.
        // 크기는 NxN, M개의 칸에 상어가 존재
        // 상하좌우 - 1,2,3,4

        // n, m, k 입력
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        map = new int[n][n];
        smellCountMap = new int[n][n];
        smellNumMap = new int[n][n];

        // 맵 초기화
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        // 상어의 방향
        now_dir = new int[m+1];
        for(int i=1; i<=m; i++){
            now_dir[i] = sc.nextInt();
        }

        // 이동 우선순위
        // 상어 번호 - 상하좌우
        List<List<List<Integer>>> priority = new ArrayList<>();
        for(int i=0; i<=m; i++){
            priority.add(new ArrayList<>());
            for(int j=0; j<=4; j++){
                priority.get(i).add(new ArrayList<>());
            }
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=4; j++){
                for(int a=1; a<=4; a++){
                    priority.get(i).get(j).add(sc.nextInt());
                }
            }
        }

        // 움직임
        // 1. 자신의 위치에서 냄새를 뿌린다.
        // 2. 1초마다 모든 상어가 동시에 상하좌우로 인접한 칸 중 하나로 이동하고 자신의 냄새를 뿌린다.
        // 3. 냄새는 상어가 k번 이동시 사라진다.







        int time = 0;
        while(true){
            // 시간이 1000초가 늘어나면 종료
            if(time > 1000){
                break;
            }
            // 상어가 1마리만 있다면 종료
            int count = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] != 0){
                        count += 1;
                    }
                }
            }
            if(count == 1){
                break;
            }

            // 1. 냄새 뿌림, 이동 방향 결정 및 이동
            // - 1. 아무 냄새가 없는 칸으로 방향을 잡는다.
            // - 2. 그런 칸이 없다면, 자신의 냄새가 없는 칸으로 방향을 잡는다.
            // - 3. 여러개일 경우(아무 냄새 없는 칸이 여러개거나 자신의 냄새가 없는 칸이 여러개), 우선순위를 잡는다.
            List<List<Integer>> moves = new ArrayList<>();
            for(int x=0; x<n; x++){
                for(int y=0; y<n; y++){
                    if(map[x][y] != 0){
                        // 빈칸
                        List<Integer> empty = new ArrayList<>();
                        // 자신의 냄새
                        List<Integer> my_smell = new ArrayList<>();
                        // 상어 번호
                        int shark_num = map[x][y];
                        // 상하좌우 체크
                        for(int i=0; i<4; i++){
                            int next_x = x + dx[i];
                            int next_y = y + dy[i];
                            // 범위 체크
                            if(next_x < 0 | next_x >= n | next_y < 0 | next_y >= n){
                                continue;
                            }
                            if(smellNumMap[next_x][next_y] == 0){
                                empty.add(i);
                            }
                            if(smellNumMap[next_x][next_y] == shark_num){
                                my_smell.add(i);
                            }
                        }
                        // 빈칸이 존재한다면
                        if(empty.size() > 0){
                            int next_x = 0;
                            int next_y = 0;
                            // 그것이 하나라면
                            if(empty.size() == 1){
                                next_x = x + dx[empty.get(0)];
                                next_y = y + dy[empty.get(0)];
                                // 상어 방향 변경
                                now_dir[shark_num] = empty.get(0)+1;
                            }
                            // 그것이 여러개라면 우선순위 고려
                            else{
                                List<Integer> check = priority.get(shark_num).get(now_dir[shark_num]);
                                // 우선순위 고려
                                for(int c : check){
                                    if(empty.contains(c-1)){
                                        next_x = x + dx[c-1];
                                        next_y = y + dy[c-1];
                                        // 상어 방향 변경
                                        now_dir[shark_num] = c;
                                        break;
                                    }
                                }
                            }
                            map[x][y] = 0;
                            moves.add(Arrays.asList(shark_num, next_x, next_y));
                        }
                        // 빈칸이 없다면
                        else{
                            List<Integer> check = priority.get(shark_num).get(now_dir[shark_num]);
                            // 우선순위 고려
                            for(int c : check){
                                if(my_smell.contains(c-1)){
                                    int next_x = x + dx[c-1];
                                    int next_y = y + dy[c-1];
                                    // 상어 방향 변경
                                    now_dir[shark_num] = c;
                                    map[x][y] = 0;
                                    moves.add(Arrays.asList(shark_num, next_x, next_y));
                                    break;
                                }
                            }
                        }
                        smellNumMap[x][y] = shark_num;
                        smellCountMap[x][y] = k;
                    }
                }
            }
            // 2. 상어제거, 상어 번호가 작을 수록 살아남음
            Collections.sort(moves, Comparator.comparing(arr -> -arr.get(0)));
            for(List<Integer> move : moves){
                map[move.get(1)][move.get(2)] = move.get(0);
            }


            // 3. 시간 증가, 냄새 제거
            time += 1;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(smellCountMap[i][j] > 0){
                        smellCountMap[i][j] -= 1;
                        if(smellCountMap[i][j] == 0){
                            smellNumMap[i][j] = 0;
                        }
                    }
                }
            }
        }

        // 결과
        // 상어 1만 남는 순간 몇초인지 출력
        // 1000초가 넘는다면 -1 출력
        if(time >= 1000){
            System.out.println(-1);
        }
        else{
            System.out.println(time);
        }

    }
}
