package JAVA.TCT.Implement;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int sum = 0;
        List<Character> check = new ArrayList<>();
        for(int i=0; i<value.length(); i++){
            char now = value.charAt(i);
            if(Character.isDigit(now)){
                sum += (int)(now - 48);
            }
            else{
                check.add(now);
            }
        }
        Collections.sort(check);
        StringBuilder result = new StringBuilder();
        for(char c : check){
            result.append(c);
        }
        result.append(String.valueOf(sum));
        System.out.println(result.toString());
    }
}
