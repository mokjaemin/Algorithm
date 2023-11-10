package BAEKJOON_RANDOM2;


import java.util.*;

// 비슷한 단어
public class Q4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String value = sc.next();
        int answer = 0;
        for(int i=1; i<n; i++){
            String next = sc.next();
            List<Character> list = new ArrayList<>();
            if(next.length() > value.length()){
                answer += check(next, value);
            }
            else{
                answer += check(value, next);
            }
        }
        System.out.println(answer);
    }
    public static int check(String bigOne, String smallOne){
        List<Character> list = new ArrayList<>();
        for(char c : bigOne.toCharArray()){
            list.add(c);
        }
        for(char c : smallOne.toCharArray()){
            list.remove(Character.valueOf(c));
        }
        if(list.size() <= 1){
            return 1;
        }
        return 0;
    }
}
