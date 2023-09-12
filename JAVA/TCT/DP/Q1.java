package JAVA.TCT.DP;

import java.util.*;


// 금광
public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] map = new int[n][m];
            for(int x=0; x<n; x++){
                for(int y=0; y<m; y++){
                    map[x][y] = sc.nextInt();
                }
            }
            for(int y=1; y<m; y++){
                for(int x=0; x<n; x++){
                    int now = 0;
                    if(x-1 >= 0 && y-1 >= 0){
                        now = Math.max(now, map[x-1][y-1]);
                    }
                    if(y-1 >= 0){
                        now = Math.max(now, map[x][y-1]);
                    }
                    if(x+1 < n && y-1 >= 0){
                        now = Math.max(now, map[x+1][y-1]);
                    }
                    map[x][y] += now;
                }
            }
            int max_value = 0;
            for(int a=0; a<n; a++){
                max_value = Math.max(max_value, map[a][m-1]);
            }
            result.add(max_value);
        }
        for(int i : result){
            System.out.println(i);
        }
    }
}
