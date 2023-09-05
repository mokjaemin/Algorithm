package JAVA.TCT.BinarySearch;

import java.util.*;

public class Practice1 {
    public static List<Integer> values = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            values.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int value = sc.nextInt();
            if(find(value)){
                System.out.print("yes");
            }
            else{
                System.out.print("no");
            }
            System.out.print(" ");
        }
        System.out.println("");
    }
    public static boolean find(int value){
        int start = 0;
        int end = values.size()-1;
        while(start <= end){
            int mid = (start + end)/2;
            int now = values.get(mid);
            if(now > value){
                end = mid-1;
            }
            else if(now == value){
                return true;
            }
            else{
                start = mid+1;
            }
        }
        return false;
    }
}
