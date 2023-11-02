package BackJoon_DFSBFS;

import java.util.*;

// 로봇 청소기
public class Q12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] pos = {sc.nextInt(), sc.nextInt()};
        int dir = sc.nextInt();
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

    }
}
