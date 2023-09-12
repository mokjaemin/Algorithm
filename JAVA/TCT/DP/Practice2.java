package JAVA.TCT.DP;

import java.util.*;

// 개미 전사
public class Practice2 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> array = new ArrayList<>();
        for(int i=0; i<n; i++){
            array.add(sc.nextInt());
        }

        int[] dp = new int[n+1];
        dp[0] = array.get(0);
        dp[1] = Math.max(dp[0], array.get(1));
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], array.get(i)+dp[i-2]);
        }
        System.out.println(dp[n-1]);
    }

}
