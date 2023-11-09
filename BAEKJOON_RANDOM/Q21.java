package BAEKJOON_RANDOM;

import java.util.*;

// 예산
public class Q21 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> values = new ArrayList<>();
        long sum = 0;
        int max_value = 0;
        for(int i=0; i<n; i++){
            int value = sc.nextInt();
            values.add(value);
            sum += value;
            max_value = Math.max(max_value, value);
        }
        long m = sc.nextLong();
        if(sum <= m){
            System.out.println(max_value);
            return;
        }
        int left = 0;
        int right = max_value;
        int answer = 0;
        while(left <= right){
            int mid = (left+right)/2;
            long now = 0;
            for(int value : values){
                if(value > mid){
                    now += mid;
                }
                else{
                    now += value;
                }
            }
            if(now <= m){
                answer = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
