package JAVA.TCT.DP;

import java.util.*;

public class Q3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> times = new ArrayList<>();
        List<Integer> costs = new ArrayList<>();
        for(int i=0; i<n; i++){
            int time = sc.nextInt();
            int cost = sc.nextInt();
            times.add(time);
            costs.add(cost);
        }
        int max_value = 0;
        int[] dp = new int[n+1];
        for(int i=n-1; i>=0; i--){
            int time = times.get(i)+i;
            int cost = costs.get(i);
            if(time <= n){
                dp[i] = Math.max(dp[time]+cost, max_value);
                max_value = dp[i];
            }
            else{
                dp[i] = max_value;
            }
        }
        System.out.println(max_value);
    }
}
