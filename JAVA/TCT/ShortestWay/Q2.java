package JAVA.TCT.ShortestWay;


import java.util.*;

// 정확한 순위
public class Q2 {
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
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
        }

        for(int i=1; i<n+1; i++){
            for(int x=1; x<n+1; x++){
                for(int y=1; y<n+1; y++){
                    map[x][y] = Math.min(map[x][y], map[x][i]+map[i][y]);
                }
            }
        }

        int result = 0;
        for(int i=1; i<n+1; i++){
            int count = 0;
            for(int j=1; j<n+1; j++){
                if(map[i][j] != (int)1e9 | map[j][i] != (int)1e9){
                    count += 1;
                }
            }
            if(count == n){
                result += 1;
            }
        }
        System.out.println(result);
    }
}
