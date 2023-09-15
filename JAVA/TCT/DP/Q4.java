package JAVA.TCT.DP;

import java.util.*;

public class Q4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> soldiers = new ArrayList<>();
        for(int i=0; i<n; i++){
            soldiers.add(sc.nextInt());
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max_value = 1;
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(soldiers.get(j) < soldiers.get(i)){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max_value = Math.max(max_value, dp[i]);
                }
            }
        }
        System.out.println(n-max_value);

    }
}
