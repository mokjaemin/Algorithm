package BAEKJOON_DP;
import java.util.Scanner;


// 상자 넣기
public class Q9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = sc.nextInt();
        }
        int[] dp = new int[1001];
        for(int i=0; i<n; i++){
            int max_value = 0;
            int value = map[i];
            for(int j=value-1; j>=0; j--){
                max_value = Math.max(max_value, dp[j]);
            }
            dp[value] = max_value+1;
        }
        int result = 0;
        for(int i=0; i<=1000; i++){
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
