package JAVA.TCT.DP;

import java.util.Scanner;

// 정수 삼각형
public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int count = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<count; j++){
                map[i][j] = sc.nextInt();
            }
            count += 1;
        }
        count = 2;
        int max_value = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<count; j++){
                int now = 0;
                now = Math.max(now, map[i-1][j]);
                if(j-1 >= 0){
                    now = Math.max(now, map[i-1][j-1]);
                }
                map[i][j] += now;
                if(i == n-1){
                    max_value = Math.max(map[i][j], max_value);
                }
            }
            count += 1;
        }
        System.out.println(max_value);
    }
}
