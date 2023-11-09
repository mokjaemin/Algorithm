package BAEKJOON_RANDOM;


import java.util.*;

// 주유소
public class Q19 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] distance = new long[n-1];
        long[] cost = new long[n];
        for(int i=0; i<n-1; i++){
            distance[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            cost[i] = sc.nextInt();
        }
        long now = cost[0];
        long result = now*distance[0];
        for(int i=1; i<n-1; i++){
            long next = cost[i];
            if(now > next){
                now = next;
            }
            result += now*distance[i];
        }
        System.out.println(result);
    }
}
