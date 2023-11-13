package BAEKJOON_RANDOM2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q8 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int n = Integer.parseInt(a.split(" ")[0]);
        int m = Integer.parseInt(a.split(" ")[1]);
        HashMap<String, Boolean> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String value = br.readLine();
            map.put(value, true);
        }
        List<Integer> answer = new ArrayList<>();
        int count = n;
        for(int i=0; i<m; i++){
            String value = br.readLine();
            String[] values = value.split(",");
            for(String now : values){
                if(map.get(now) == null){
                    continue;
                }
                if(map.get(now) == true){
                    count -= 1;
                    map.put(now, false);
                }
            }
            answer.add(count);
        }
        for(int i : answer){
            System.out.println(i);
        }
    }
}
