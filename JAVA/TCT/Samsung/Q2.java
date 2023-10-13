package JAVA.TCT.Samsung;

import java.util.*;

// 청소년 상어
public class Q2 {
    public static int[][] size_map = new int[4][4];
    public static int[][] dir_map= new int[4][4];
    public static List<Integer> fish_size = new ArrayList<>();
    // 상어 정보
    public static int[] pos = {0, 0};
    public static int dir;
    public static int result = 0;
    public static int answer = 0;
    // 반시계 방향 (위에서부터 시작)
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                size_map[i][j] = sc.nextInt();
                dir_map[i][j] = sc.nextInt()-1;
                fish_size.add(size_map[i][j]);
            }
        }

        // 배경
        // 상하좌우, 대각선 이동
        // 상어는 (0, 0) 먹고 시작
        result += size_map[0][0];
        answer += size_map[0][0];
        size_map[0][0] = 0;
        dir = dir_map[0][0];
        dir_map[0][0] = 0;


        // 물고기 정렬
        Collections.sort(fish_size);


        // 이동 로직

        // 물고기 이동
        fish_move();
        // 상어 이동
        shark_move();
        System.out.println(answer);
    }

    // 상어 이동
    // 지정된 방향으로만 이동가능, 한번에 여러칸 이동 가능
    // 물고기가 있는 칸 이동시 물고기 먹고, 그 물고기가 가진 방향 가짐
    // 이동하는 중 지나는 물고기는 먹지 않는다.
    // 이동할 수 있는 칸이 없다면 종료
    public static void shark_move(){
        // 상어 이동
        List<List<Integer>> fishes = new ArrayList<>();
        int next_x = pos[0];
        int next_y = pos[1];
        while(true) {
            next_x += dx[dir];
            next_y += dy[dir];
            if (next_x < 0 | next_x >= 4 | next_y < 0 | next_y >= 4) {
                break;
            }
            // 물고기 없는 칸으로는 이동 불가능
            if (size_map[next_x][next_y] == 0) {
                continue;
            }
            fishes.add(Arrays.asList(next_x, next_y));
        }
        if(fishes.size() == 0){
            return;
        }
        for(List<Integer> fish : fishes){
            // 기존 정보 추출
            int fish_x = fish.get(0);
            int fish_y = fish.get(1);
            int fish_size = size_map[fish_x][fish_y];
            int fish_dir = dir_map[fish_x][fish_y];

            int shark_x = pos[0];
            int shark_y = pos[1];
            int shart_dir = dir;

            int[][] new_size_map = new int[4][4];
            int[][] new_dir_map = new int[4][4];
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    new_size_map[i][j] = size_map[i][j];
                    new_dir_map[i][j] = dir_map[i][j];
                }
            }

            // 먹음
            result += fish_size;
            size_map[fish_x][fish_y] = 0;
            dir_map[fish_x][fish_y] = 0;
            pos[0] = fish_x;
            pos[1] = fish_y;
            dir = fish_dir;

            // 결과 갱신
            answer = Math.max(answer, result);


            // 다시 이동
            fish_move();
            shark_move();

            // 물고기 되돌리기
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    size_map[i][j] = new_size_map[i][j];
                    dir_map[i][j] = new_dir_map[i][j];
                }
            }

            // 뱉음
            result -= fish_size;
            size_map[fish_x][fish_y] = fish_size;
            dir_map[fish_x][fish_y] = fish_dir;
            pos[0] = shark_x;
            pos[1] = shark_y;
            dir = shart_dir;
        }
    }




    // 물고기 이동
    // 번호가 작은 물고기부터 이동
    // 한칸만 이동 가능
    // 이동할 수 있는 칸 : 빈칸, 다른 물고기가 있는 칸
    // 이동할 수 없는 칸 : 상어 존재, 공간의 경계를 넘는 칸
    // 이동 방식 : 현재 방향부터 시작해 45도 회전해가며 이동, 이동 못하면 그대로 위치
    // 다른 물고기 있는 칸 이동시 위치 바꾼다.
    public static void fish_move(){
        // 작은 물고기부터 이동
        for(int fish : fish_size){
            for(int i=0; i<4; i++){
                // 이미 처리한 물고기 재처리 방지
                boolean conti = true;
                for(int j=0; j<4; j++){
                    if(size_map[i][j] == fish){
                        // 회전
                        int dir = dir_map[i][j];
                        for(int d=0; d<8; d++){
                            // 이동할 칸
                            int next_x = i + dx[dir];
                            int next_y = j + dy[dir];
                            // 범위 벗어나면 진행
                            if(next_x < 0 | next_x >= 4 | next_y < 0 | next_y >= 4){
                                dir += 1;
                                if(dir == 8){
                                    dir = 0;
                                }
                                continue;
                            }
                            // 상어 존재하는 칸
                            if(next_x == pos[0] && next_y == pos[1]){
                                dir += 1;
                                if(dir == 8){
                                    dir = 0;
                                }
                                continue;
                            }
                            // 빈칸
                            if(size_map[next_x][next_y] == 0){
                                size_map[next_x][next_y] = size_map[i][j];
                                size_map[i][j] = 0;
                                dir_map[next_x][next_y] = dir;
                                dir_map[i][j] = 0;
                                break;
                            }
                            // 다른 물고기 있는 칸
                            else{
                                size_map[i][j] = size_map[next_x][next_y];
                                size_map[next_x][next_y] = fish;
                                dir_map[i][j] = dir_map[next_x][next_y];
                                dir_map[next_x][next_y] = dir;
                                break;
                            }
                        }
                        conti = false;
                        break;
                    }
                }
                if(!conti){
                    break;
                }
            }
        }
    }
}
