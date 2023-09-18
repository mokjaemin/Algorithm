package JAVA.TCT.DP;

import java.util.*;

// 편집 거리
public class Q6 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 두개의 문자열 입력 받기
        String str1 = sc.next();
        String str2 = sc.next();
        // 로직 함수 실행
        edit_dist(str1, str2);
    }

    public static void edit_dist(String str1, String str2){
        // 각 문자열의 길이
        int n = str1.length();
        int m = str2.length();

        // 2차원 dp 초기화
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            dp[i][0] = i;
        }
        for(int i=1; i<m+1; i++){
            dp[0][i] = i;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                // 두 문자가 같은 경우
                // - 행과 열에 해당하는 문자가 서로 같다면 왼쪽 위에 해당하는 수를 그대로 대입
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                // 두 문자가 다른 경우
                // - 행과 열에 해당하는 문자가 서로 다르다면, 왼쪽, 위쪽, 왼쪽 위에 해당하는 수 중
                // 가장 작은 수에 1을 더해 대입
                else{
                    int result = Math.min(dp[i][j-1], dp[i-1][j]);
                    result = Math.min(result, dp[i-1][j-1]);
                    dp[i][j] = 1 + result;
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
