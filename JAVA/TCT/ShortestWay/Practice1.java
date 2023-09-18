package JAVA.TCT.ShortestWay;

import java.util.*;

public class Practice1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                if(i == j){
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = (int)1e9;
            }
        }
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
            map[b][a] = 1;
        }
        int x = sc.nextInt();
        int k = sc.nextInt();

        for(int i=0; i<n+1; i++){
            for(int a=0; a<n+1; a++){
                for(int b=0; b<n+1; b++){
                    map[a][b] = Math.min(map[a][b], map[a][i]+map[i][b]);
                }
            }
        }

        if(map[1][k] < 100000 && map[k][x] < 100000){
            System.out.println(map[1][k]+map[k][x]);
        }
        else{
            System.out.println("-1");
        }

    }
}
