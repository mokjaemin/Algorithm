package SofteerPractice;


import java.util.*;

// 1. 자동차 테스트 - 이진탐색
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
        // 정렬 시간복잡도 N*logN
        Collections.sort(values);
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<q; i++){
            int mid = sc.nextInt();
            // 이진탐색으로 위치 찾기
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
        // 위치 0과 마지막 위치는 중간값이 될 수 없다
        int start = 1;
        int end = values.size()-2;
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
