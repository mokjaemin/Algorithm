package BAEKJOON_RANDOM;


import java.util.*;

// 임스와 함께하는 미니게임
public class Q12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String kind = sc.next();
        HashSet<String> ids = new HashSet<>();
        for(int i=0; i<n; i++){
            String id = sc.next();
            ids.add(id);
        }
        if(kind.equals("Y")){
            System.out.println(ids.size());
        }
        else if(kind.equals("F")){
            System.out.println(ids.size()/2);
        }
        else{
            System.out.println(ids.size()/3);
        }
    }
}
