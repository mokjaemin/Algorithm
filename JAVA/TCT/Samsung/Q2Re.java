package JAVA.TCT.Samsung;

import java.util.*;


//        19
//        0 2 9 10
//        6 0 1 14
//        16 5 15 13
//        3 4 11 8
//
//        25
//        0 9 10 14
//        16 0 0 1
//        5 2 13 8
//        3 4 11 15
//
//        22
//        0 2 9 10
//        6 12 1 14
//        16 5 0 13
//        3 4 11 8
//
//        33
//        12 9 10 14
//        16 6 0 1
//        5 13 0 8
//        3 4 2 0
//
//        15
//        0 2 9 10
//        6 12 1 14
//        16 5 15 13
//        3 4 11 0

// 청소년 상어
public class Q2Re {
    public static class Fish implements Comparable<Fish>{
        int x;
        int y;
        int number;
        int direction;

        public Fish(int x, int y, int number, int direction){
            this.x = x;
            this.y = y;
            this.number = number;
            this.direction = direction;
        }

        @Override
        public int compareTo(Fish other){
            if(this.number < other.number){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
    // 0, 위, 위왼, 왼, 왼아, 아, 오아, 오, 오위
    public static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    // 상어가 먹는 물고기들의 번호의 합
    public static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // 기본 정보
        List<Fish> fishes = new ArrayList<>();
        int[] shark_pos = {0, 0};
        int shark_dir = 0;
        int[][][] map = new int[4][4][2];
        int sum = 0;


        // 4x4 맵
        // 물고기는 번호(1~16, UNIQUE)와 방향(8 방향)을 갖고 있다.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    map[i][j][k] = sc.nextInt();
                }
                // 상어는 (0, 0) 위치에 물고기를 먹고 시작하며 방향이 같아짐
                if (i == 0 && j == 0) {
                    shark_dir = map[i][j][1];
                    sum += map[i][j][0];
                    map[i][j][0] = 0;
                    map[i][j][1] = 0;
                    continue;
                }
                fishes.add(new Fish(i, j, map[i][j][0], map[i][j][1]));
            }
        }

        // 로직 시작
        fish_move(fishes, shark_pos, shark_dir, map, sum);
        System.out.println(answer);

    }

    public static void shark_move(List<Fish> fishes, int[] shark_pos, int shark_dir, int[][][] map, int sum){
        // - 이동할 수 있는 칸 없을 시 종료
        for(int i=1; i<=4; i++){
            int next_shark_x = shark_pos[0] + dx[shark_dir]*i;
            int next_shark_y = shark_pos[1] + dy[shark_dir]*i;
            // 범위 벗어남
            if(next_shark_x < 0 | next_shark_x >= 4 | next_shark_y < 0 | next_shark_y >= 4){
                break;
            }
            // - 물고기가 없는 칸으로 이동 불가능
            if(map[next_shark_x][next_shark_y][0] == 0){
                continue;
            }
            // - 물고기를 먹는다면 물고기를 먹고 그 물고기의 방향을 가짐
            // 상어 정보 생성
            int[] new_shark_pos = {next_shark_x, next_shark_y};
            int new_shark_dir = map[next_shark_x][next_shark_y][1];
            int fish_num = map[next_shark_x][next_shark_y][0];
            // 맵 생성
            int[][][] new_map = new int[4][4][2];
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    for (int c = 0; c < 2; c++) {
                        new_map[a][b][c] = map[a][b][c];
                    }
                }
            }
            new_map[next_shark_x][next_shark_y][0] = 0;
            new_map[next_shark_x][next_shark_y][1] = 0;
            // 리스트 생성
            List<Fish> new_fishes = new ArrayList<>();
            for(Fish fish : fishes){
                if(fish.number == fish_num){
                    continue;
                }
                new_fishes.add(new Fish(fish.x, fish.y, fish.number, fish.direction));
            }
            System.out.println(sum+fish_num);
            for(int a=0; a<4; a++){
                for(int j=0; j<4; j++){
                    System.out.print(new_map[a][j][0]);
                    System.out.print(" ");
                }
                System.out.println(" ");
            }
            System.out.println(" ");
            answer = Math.max(answer, sum+fish_num);
            fish_move(new_fishes, new_shark_pos, new_shark_dir, new_map, sum+fish_num);
        }
    }

    // 물고기 이동 함수
    public static void fish_move(List<Fish> fishes, int[] shark_pos, int shark_dir, int[][][] map, int sum){
        // - 번호가 작은 물고기부터 순서대로 이동
        Collections.sort(fishes);
        for(Fish fish : fishes){
            int dir = fish.direction;
            int x = fish.x;
            int y = fish.y;
            int num = fish.number;
            // - 이동할 수 있는 칸을 찾기 위해 반시계 45도 회전, 이동할 수 없다면 멈춤
            for(int i=0; i<8; i++){
                int next_x = x + dx[dir];
                int next_y = y + dy[dir];
                // 범위가 벗어난다.
                if(next_x < 0 | next_x >= 4 | next_y < 0 | next_y >= 4){

                }
                // 상어가 있는 칸
                else if(next_x == shark_pos[0] && next_y == shark_pos[1]){

                }
                // 빈칸 다른 물고기가 있는 칸
                else{
                    // - 이동시 서로 위치를 바꾸고 방향이 바뀌지는 않는다.
                    int other_num = map[next_x][next_y][0];
                    int other_dir = map[next_x][next_y][1];
                    // List 변경
                    fish.x = next_x;
                    fish.y = next_y;
                    for(Fish other : fishes){
                        if(other.number == other_num){
                            other.x = x;
                            other.y = y;
                        }
                    }
                    // 맵 변경
                    map[next_x][next_y][0] = num;
                    map[next_x][next_y][1] = dir;
                    map[x][y][0] = other_num;
                    map[x][y][1] = other_dir;
                    break;
                }
                // 방향 갱신
                dir += 1;
                if(dir == 9){
                    dir = 1;
                }
            }
        }
        shark_move(fishes, shark_pos, shark_dir, map, sum);
    }
}

