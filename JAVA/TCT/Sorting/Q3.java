package JAVA.TCT.Sorting;

import java.util.*;

// 카드 정렬하기
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> check = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            check.add(sc.nextInt());
        }
        List<Integer> result = new ArrayList<>();
        while(true){
            if(check.size() <= 1){
                break;
            }
            int now = check.poll();
            now += check.poll();
            result.add(now);
            check.add(now);
        }
        int answer = 0;
        for(int i : result){
            answer += i;
        }
        System.out.println(answer);
    }
}
