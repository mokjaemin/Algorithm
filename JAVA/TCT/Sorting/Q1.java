package JAVA.TCT.Sorting;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] map = new String[n];
        for(int i=0; i<n; i++){
            map[i] = sc.nextLine();
        }
        List<List<String>> check = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<String> now = new ArrayList<>();
            String[] values = map[i].split(" ");
            now.add(values[0]);
            now.add(values[1]);
            now.add(values[2]);
            now.add(values[3]);
            check.add(now);
        }
        Collections.sort(check, Comparator
        .comparing((List<String> arr) -> -Integer.valueOf(arr.get(1)))
        .thenComparing(arr -> Integer.valueOf(arr.get(2)))
        .thenComparing(arr -> -Integer.valueOf(arr.get(3)))
        .thenComparing(arr -> arr.get(0)));

        for(int i=0; i<check.size(); i++){
            System.out.println(check.get(i).get(0));
        }
    }
    
}
