package SofteerPractice;


import java.util.*;

// 1. 자동차 테스트
public class Practice1 {
    public static List<Integer> values = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 1~50000
        int n = sc.nextInt();
        // 1~200000
        int q = sc.nextInt();
        // 값은 10억 이하
        for(int i=0; i<n; i++){
            int value = sc.nextInt();
            values.add(value);
        }
        Collections.sort(values);
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<q; i++){
            int mid = sc.nextInt();
            int pos = binary_search(mid);
            if(pos == -1){
                answer.add(0);
            }
            else{
                answer.add(pos*(n-pos-1));
            }
        }
        for(int a : answer){
            System.out.println(a);
        }
    }
    public static int binary_search(int mid){
        int start = 1;
        int end = values.size()-1;
        while(start <= end){
            int now = (start + end)/2;
            if(values.get(now) > mid){
                end = now-1;
                continue;
            }
            if(values.get(now) < mid){
                start = now+1;
                continue;
            }
            if(values.get(now) == mid){
                return now;
            }
        }
        return -1;
    }
}
