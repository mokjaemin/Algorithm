package BAEKJOON_RANDOM3;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 용액
public class Q5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            list.add(Long.parseLong(st.nextToken()));
        }
        long min_value = Long.MAX_VALUE;
        long left_result = 0;
        long right_result = 0;
        for(int i=0; i<n; i++){
            long now = list.get(i);
            int left = i+1;
            int right = n-1;
            while(left <= right){
                int mid = (left+right)/2;
                long value = list.get(mid);
                long sum = now+value;
                if(Math.abs(sum) < min_value){
                    min_value = Math.abs(sum);
                    left_result = now;
                    right_result = value;
                }
                if(sum < 0){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        System.out.print(left_result);
        System.out.print(" ");
        System.out.println(right_result);
    }
}
