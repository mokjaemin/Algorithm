package JAVA.TCT.Greedy;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        

        List<Integer> result = new ArrayList<>();
        for(String now : values){
            result.add(Integer.valueOf(now));
        }
        Collections.sort(result);

        int now = 1;
        for(int i : result){
            if(i > now){
                break;
            }
            now += i;
        }
        
    }
}
