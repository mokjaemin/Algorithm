package NHN;

import java.util.*;

public class Q5 {
    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1000, 3));
        list.add(Arrays.asList(2000, 4));
        list.add(Arrays.asList(5000, 1));
        int[] map = new int[101];
        for(int i=0; i<=100; i++){
            map[i] = (int)1e9;
        }
        for(int i=1; i<=100; i++){
            for(List<Integer> now : list){
            int cost = now.get(0);
            int days = now.get(1);
                if(i <= days){
                    map[i] = Math.min(map[i], cost);
                }
                else{
                    map[i] = Math.min(map[i], map[i-days]+cost);
                }
            }
            System.out.println(map[i]);
        }
    }
}
