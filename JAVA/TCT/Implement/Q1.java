package JAVA.TCT.Implement;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<value.length()/2; i++){
            sum1 += (int)(value.charAt(i)-48);
        }
        for(int i=value.length()/2; i<value.length(); i++){
            sum2 += (int)(value.charAt(i)-48);
        }
        if(sum1 == sum2){
            System.out.println("LUCKY");
        }
        else{
            System.out.println("READY");
        }
    }
}
