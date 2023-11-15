package BAEKJOON_RANDOM2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 지름길
public class Q18 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nd = br.readLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] map = new int[d+1];
        for(int i=1; i<d+1; i++){
            map[i] = i;
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] values = br.readLine().split(" ");
            int start = Integer.parseInt(values[0]);
            int end = Integer.parseInt(values[1]);
            int cost = Integer.parseInt(values[2]);
            if(end > d){
                continue;
            }
            if(end-start <= cost){
                continue;
            }
            list.add(Arrays.asList(start, end, cost));
        }
        Collections.sort(list, Comparator.comparing(arr -> arr.get(0)));
        for(List<Integer> now : list){
            int start = now.get(0);
            int end = now.get(1);
            int cost = now.get(2);
            map[end] = Math.min(map[end], map[start]+cost);
            for(int i=end; i<=d; i++){
                map[i] = Math.min(map[i], map[i-1]+1);
            }
        }
        System.out.println(map[d]);
    }
}
