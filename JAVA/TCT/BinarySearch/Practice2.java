package JAVA.TCT.BinarySearch;

import java.util.*;

// 떡볶이 떡 만들기
public class Practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<n; i++){
            values.add(sc.nextInt());
        }
        Collections.sort(values);
        int start = 0;
        int end = values.get(values.size()-1);
        int answer = 0;
        while(start <= end){
            int mid = (start+end)/2;
            int sum = 0;
            for(int value : values){
                int now = value - mid;
                if(now > 0){
                    sum += now;
                }
            }
            if(sum >= m){
                start = mid+1;
                answer = Math.max(answer, mid);
            }
            else{
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}
