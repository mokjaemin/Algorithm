package JAVA.TCT.DP;

import java.util.*;

// 효율적인 화폐 구성
public class Practice4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> coins = new ArrayList<>();
        for(int i=0; i<n; i++){
            coins.add(sc.nextInt());
        }
        int[] dp = new int[m+1];
        Arrays.fill(dp, (int)1e9);

        dp[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=coins.get(i); j<m+1; j++){
                dp[j] = Math.min(dp[j], dp[j-coins.get(i)]+1);
            }
        }

        if(dp[m] >= 100000){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[m]);
        }
    }
    
}
