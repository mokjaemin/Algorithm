package BAEKJOON_RANDOM2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 회전초밥
public class Q20 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ndkc = br.readLine().split(" ");
        int n = Integer.parseInt(ndkc[0]);
        int d = Integer.parseInt(ndkc[1]);
        int k = Integer.parseInt(ndkc[2]);
        int c = Integer.parseInt(ndkc[3]);
        List<Integer> dishes = new ArrayList<>();
        for(int i=0; i<n; i++){
            dishes.add(Integer.parseInt(br.readLine()));
        }
        int[] now = new int[d+1];
        int count = 0;
        for(int i=0; i<k; i++){
            int dish = dishes.get(i);
            dishes.add(dish);
        }
        List<Integer> new_dishes = new ArrayList<>();
        for(int i=dishes.size()-1; i>=0; i--){
            new_dishes.add(dishes.get(i));
        }
        dishes = new_dishes;
        for(int i=0; i<k; i++){
            int dish = dishes.get(i);
            now[dish] += 1;
            if(now[dish] == 1){
                count += 1;
            }
        }
        int answer = count;
        if(now[c] == 0){
            answer += 1;
        }
        for(int i=k; i<dishes.size()-1; i++){
            int next = dishes.get(i);
            now[next] += 1;
            if(now[next] == 1){
                count += 1;
            }
            int before = dishes.get(i-k);
            now[before] -= 1;
            if(now[before] == 0){
                count -= 1;
            }
            answer = Math.max(answer, count);
            if(now[c] == 0){
                answer = Math.max(answer, count+1);
            }
        }
        System.out.println(answer);
    }
}
