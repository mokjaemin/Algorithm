package BAEKJOON_DP;


import java.util.*;

// 동전 2
public class Q5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> coins = new ArrayList<>();
        for(int i=0; i<n; i++){
            coins.add(sc.nextInt());
        }
        int[] dp = new int[k+1];
        for(int i=1; i<k+1; i++){
            dp[i] = (int)1e9;
        }
        Collections.sort(coins);
        for(int coin : coins){
            for(int money=1; money<=k; money++){
                if(coin > money){
                    continue;
                }
                if(coin == money){
                    dp[money] = 1;
                    continue;
                }
                if(dp[money-coin] <= 1000000){
                    dp[money] = Math.min(dp[money-coin]+1, dp[money]);
                }
            }
        }
        if(dp[k] >= 1000000){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[k]);
    }
}
