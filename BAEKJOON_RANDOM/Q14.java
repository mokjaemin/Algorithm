package BAEKJOON_RANDOM;

import java.util.*;

// 등수 구하기
public class Q14 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long score = sc.nextLong();
        int limit = sc.nextInt();
        List<Long> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(sc.nextLong());
        }
        list.add(score);
        Collections.sort(list, Comparator.comparing(arr->-arr));
        if(list.size() <= limit){
            for(int i=0; i<list.size(); i++){
                if(list.get(i) == score){
                    System.out.println(i+1);
                    break;
                }
            }
        }
        else{
            if(list.get(limit) >= score){
                System.out.println(-1);
            }
            else{
                for(int i=0; i<list.size(); i++){
                    if(list.get(i) == score){
                        System.out.println(i+1);
                        break;
                    }
                }
            }
        }
    }
}
