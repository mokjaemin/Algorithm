package BAEKJOON_DP;


import java.util.*;

// 동전 1
public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> coins = new ArrayList<>();
        for(int i=0; i<n; i++){
            coins.add(sc.nextInt());
        }

        int[] dp = new int[k+1];
        for(int coin : coins){
            for(int money=1; money<=k; money++){
                if(coin > money){
                    continue;
                }
                if(coin == money){
                    dp[money] += 1;
                    continue;
                }
                dp[money] += dp[money-coin];
            }
        }
        System.out.println(dp[k]);
    }
}
