package JAVA.TCT.Greedy;

import java.util.*;

// 1이 될때까지
public class Practice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();
        String[] value = values.split(" ");
        int n = Integer.valueOf(value[0]);
        int m = Integer.valueOf(value[1]);
        int answer = 0;
        while(n != 1){
            if(n % m == 0){
                n /= m;
            }
            else{
                n -= 1;
            }
            answer += 1;
        }
        System.out.println(answer);
    }
}
