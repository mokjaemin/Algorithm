package JAVA.TCT.DFSBFS;

import java.util.*;

// 감시 피하기
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] map = new String[n][n];
        List<List<Integer>> students = new ArrayList<>();
        List<List<Integer>> teachers = new ArrayList<>();
        List<List<Integer>> empty = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.next();
                if(map[i][j].equals("S")){
                    students.add(Arrays.asList(i, j));
                }
                if(map[i][j].equals("T")){
                    teachers.add(Arrays.asList(i, j));
                }
                if(map[i][j].equals("X")){
                    empty.add(Arrays.asList(i, j));
                }
            }
        }
        boolean success = false;
        int len_obs = empty.size();
        for(int obs1=0; obs1<len_obs-2; obs1++){
            for(int obs2=obs1+1; obs2<len_obs-1; obs2++){
                for(int obs3=obs2+1; obs3<len_obs; obs3++){
                    // 설치
                    map[empty.get(obs1).get(0)][empty.get(obs1).get(1)] = "O";
                    map[empty.get(obs2).get(0)][empty.get(obs2).get(1)] = "O";
                    map[empty.get(obs3).get(0)][empty.get(obs3).get(1)] = "O";

                    // 선생마다 감시
                    int total_count = 0;
                    for(List<Integer> teacher : teachers){
                        int count = 0;
                        for(int i=0; i<4; i++){
                            if(check(map, teacher.get(0), teacher.get(1), i)){
                                count += 1;
                            }
                        }
                        if(count == 4){
                            total_count += 1;
                        }
                    }
                    if(total_count == teachers.size()){
                        success = true;
                    }

                    // 해제
                    map[empty.get(obs1).get(0)][empty.get(obs1).get(1)] = "X";
                    map[empty.get(obs2).get(0)][empty.get(obs2).get(1)] = "X";
                    map[empty.get(obs3).get(0)][empty.get(obs3).get(1)] = "X";
                }
            }
        }
        if(success){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    public static boolean check(String[][] map, int x, int y, int direction){
        // 위
        if(direction == 0){
            if(x-1 < 0){
                return true;
            }
            if(map[x-1][y].equals("O")){
                return true;
            }
            if(map[x-1][y].equals("S")){
                return false;
            }
            return check(map, x-1, y, direction);
        }
        // 오른쪽
        if(direction == 1){
            if(y+1 >= map.length){
                return true;
            }
            if(map[x][y+1].equals("O")){
                return true;
            }
            if(map[x][y+1].equals("S")){
                return false;
            }
            return check(map, x, y+1, direction);
        }
        // 아래
        if(direction == 2){
            if(x+1 >= map.length){
                return true;
            }
            if(map[x+1][y].equals("O")){
                return true;
            }
            if(map[x+1][y].equals("S")){
                return false;
            }
            return check(map, x+1, y, direction);
        }
        // 왼쪽
        if(direction == 3){
            if(y-1 < 0){
                return true;
            }
            if(map[x][y-1].equals("O")){
                return true;
            }
            if(map[x][y-1].equals("S")){
                return false;
            }
            return check(map, x, y-1, direction);
        }
        return true;
    }
}
