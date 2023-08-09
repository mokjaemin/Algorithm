package JAVA.TCT.Greedy;

import java.util.*;

public class Q5 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value1 = scanner.nextLine();
        String[] values1 = value1.split(" ");
        String value2 = scanner.nextLine();
        String[] values2 = value2.split(" ");

        int answer = 0;
        for(int i=0; i<values2.length; i++){
            int now = Integer.valueOf(values2[i]);
            for(int j=i+1; j<values2.length; j++){
                int next = Integer.valueOf(values2[j]);
                if(now != next){
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
