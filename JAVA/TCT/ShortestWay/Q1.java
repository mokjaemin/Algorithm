package JAVA.TCT.ShortestWay;


import java.util.*;

// 플로이드
public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                map[i][j] = (int)1e9;
                if(i == j){
                    map[i][j] = 0;
                }
            }
        }
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            map[a][b] = Math.min(map[a][b], cost);
        }

        for(int i=1; i<n+1; i++){
            for(int x=1; x<n+1; x++){
                for(int y=1; y<n+1; y++){
                    map[x][y] = Math.min(map[x][y], map[x][i]+map[i][y]);
                }
            }
        }

        for(int x=1; x<n+1; x++){
            for(int y=1; y<n+1; y++){
                if(map[x][y] > 100000){
                    System.out.print(0);
                    System.out.print(" ");
                    continue;
                }
                System.out.print(map[x][y]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
