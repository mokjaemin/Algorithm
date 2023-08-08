package JAVA.TCT.Greedy;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value1 = scanner.nextLine();
        int n = Integer.valueOf(value1);
        List<Integer> map = new ArrayList<>();
        String value2 = scanner.nextLine();
        String[] new_value2 = value2.split(" ");
        for(int i=0; i<n; i++){
            int now = Integer.valueOf(new_value2[i]);
            map.add(now);
        }
        Collections.sort(map);
        int answer = 0;
        int count = 0;
        for(int m : map){
            count += 1;
            if(count == m){
                answer += 1;
                count = 0;
            }
        }
        System.out.println(answer);
    }
}
