package JAVA.TCT.BinarySearch;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<n; i++){
            values.add(sc.nextInt());
        }
        int start = 0;
        int end = n-1;
        boolean success = false;
        while(start <= end){
            int mid = (start+end)/2;
            int value = values.get(mid);
            if(value == mid){
                System.out.println(mid);
                success = true;
                break;
            }
            else if(value < mid){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        if(!success){
            System.out.println(-1);
        }
    }
}
