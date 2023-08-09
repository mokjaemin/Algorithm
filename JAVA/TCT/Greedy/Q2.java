package JAVA.TCT.Greedy;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int result = (int)(value.charAt(0)-48);
        for(int i=1; i<value.length(); i++){
            int now = (int)(value.charAt(i)-48);
            if(result == 1 | now == 1 | result == 0 | now == 0){
                result += now;
            }
            else{
                result *= now;
            }
        }
        System.out.println(result);
    }
}
