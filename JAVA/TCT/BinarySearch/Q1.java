package JAVA.TCT.BinarySearch;

import java.util.*;

// 정렬된 배열에서 특정 수의 개수 구하기
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<n; i++){
            values.add(sc.nextInt());
        }
        // find start
        int start = 0;
        int end = n-1;
        int result1 = -1;
        while(start <= end){
            int mid = (start+end)/2;
            int value = values.get(mid);
            if((mid == 0 | value > values.get(mid-1)) && value == x){
                result1 = mid;
                break;
            }
            else if(value < x){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        // find last
        if(result1 != -1){
            start = 0;
            end = n-1;
            int result2 = -1;
            while(start <= end){
                int mid = (start+end)/2;
                int value = values.get(mid);
                if((mid == n-1 | value < values.get(mid+1)) && value == x){
                    result2 = mid;
                    break;
                }
                else if(value <= x){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            System.out.println(result2-result1+1);
        }
        else{
            System.out.println(result1);
        }
    }
}
