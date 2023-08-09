package JAVA.TCT.Greedy;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int count0 = 0;
        int count1 = 0;
        int now = (int)(value.charAt(0) - 48);
        for(int i=1; i<value.length(); i++){
            int next = (int)(value.charAt(i) - 48);
            if(next == now){
                continue;
            }
            if(now == 0){
                count0 += 1;
            }
            if(now == 1){
                count1 += 1;
            }
            now = next;
        }
        System.out.println(Math.max(count0, count1));
    }
}
