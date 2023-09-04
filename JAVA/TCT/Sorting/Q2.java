package JAVA.TCT.Sorting;

import java.util.*;

// 안테나
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<n; i++){
            int now = sc.nextInt();
            values.add(now);
        }
        Collections.sort(values);
        System.out.println(values.get((n-1)/2));
    }
}
