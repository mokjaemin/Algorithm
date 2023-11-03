package BAEKJOON_RANDOM;

import java.util.*;

// 집합
// - 비트 마스킹으로 해결해야 함
public class Q6_X {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] map = new int[21];
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<m; i++) {
            String action = sc.next();
            if(action.equals("all")){
                for(int j=1; j<=20; j++){
                    map[j] = 1;
                }
                continue;
            }
            if(action.equals("empty")){
                map = new int[21];
                continue;
            }
            int count = sc.nextInt();
            if(action.equals("add")){
                map[count] += 1;
                continue;
            }
            if(action.equals("remove")){
                map[count] -= 1;
                continue;
            }
            if(action.equals("check")){
                if(map[count] == 1){
                    result.add(1);
                }
                else{
                    result.add(0);
                }
                continue;
            }
            if(action.equals("toggle")){
                if(map[count] == 1){
                    map[count] -= 1;
                }
                else{
                    map[count] += 1;
                }
                continue;
            }
        }
        for(int i : result){
            System.out.println(i);
        }
    }
}
