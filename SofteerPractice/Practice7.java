package SofteerPractice;


import java.util.*;

public class Practice7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = (int)1e9;
            }
        }
        // 길 정보
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x-1][y-1] = 0;
        }
        int start = sc.nextInt()-1;
        int end = sc.nextInt()-1;


        for(int k=0; k<n; k++){
            for(int x=0; x<n; x++){
                for(int y=0; y<n; y++){
                    if(map[x][k] == 0 && map[k][y] == 0){
                        map[x][y] = 0;
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            if(i == start | i == end){
                continue;
            }
            if(map[start][i] == 0 && map[i][end] == 0 && map[end][i] == 0 && map[i][start] == 0){
                System.out.println(i+1);
                answer += 1;
            }
        }
        System.out.println(answer);
    }

}
