package BAEKJOON_RANDOM3;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 문자열 게임 2
public class Q1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<String> answer = new ArrayList<>();
        for(int a=0; a<t; a++){
            String value = br.readLine();
            HashMap<Character, List<Integer>> map = new HashMap<>();
            for(int i=0; i<value.length(); i++){
                char v = value.charAt(i);
                if(map.get(v) == null){
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(i);
                    map.put(v, indexes);
                }
                else{
                    List<Integer> indexes = map.get(v);
                    indexes.add(i);
                    map.put(v, indexes);
                }
            }
            int k = Integer.parseInt(br.readLine());
            int min_value = (int)1e9;
            int max_value = 0;
            for(char key : map.keySet()){
                if(map.get(key).size() < k){
                    continue;
                }
                List<Integer> now = map.get(key);
                int start = 0;
                int end = k-1;
                while(true){
                    if(end >= now.size()){
                        break;
                    }
                    min_value = Math.min(min_value, now.get(end)-now.get(start)+1);
                    max_value = Math.max(max_value, now.get(end)-now.get(start)+1);
                    start += 1;
                    end += 1;
                }
            }
            if(max_value == 0){
                answer.add("-1");
                continue;
            }
            answer.add(String.valueOf(min_value) + " " + String.valueOf(max_value));
        }
        for(String a : answer){
            System.out.println(a);
        }
    }
}
