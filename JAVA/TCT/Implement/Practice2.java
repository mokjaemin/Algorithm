package JAVA.TCT.Implement;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");
        String[] pos = scanner.nextLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);
        int x = Integer.valueOf(pos[0]);
        int y = Integer.valueOf(pos[1]);
        int dir = Integer.valueOf(pos[2]);
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] values = scanner.nextLine().split(" ");
            for(int j=0; j<values.length; j++){
                map[i][j] = Integer.valueOf(values[j]);
            }
        }
        // 0, 3, 2, 1
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;
        int count = 0;
        int answer = 1;
        while(true){
            if(count == 4){
                System.out.println(answer);
                break;
            }
            if(dir == 0){
                dir = 3;
                count += 1;
                if(!visited[x][y-1] && map[x][y-1] != 1){
                    visited[x][y-1] = true;
                    answer += 1;
                    y -= 1;
                    count = 0;
                }
            }
            else if(dir == 3){
                dir = 2;
                count += 1;
                if(!visited[x+1][y] && map[x+1][y] != 1){
                    visited[x+1][y] = true;
                    answer += 1;
                    x += 1;
                    count = 0;
                }
            }  
            else if(dir == 2){
                dir = 1;
                count += 1;
                if(!visited[x][y+1] && map[x][y+1] != 1){
                    visited[x][y+1] = true;
                    answer += 1;
                    y += 1;
                    count = 0;
                }
            }
            else{
                dir = 0;
                count += 1;
                if(!visited[x-1][y] && map[x-1][y] != 1){
                    visited[x-1][y-1] = true;
                    answer += 1;
                    x -= 1;
                    count = 0;
                }
            }
        }
    }
}
