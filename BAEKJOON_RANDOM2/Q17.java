package BAEKJOON_RANDOM2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// 겹치는 건 싫어
public class Q17 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int answer = 0;
        String[] values = br.readLine().split(" ");
        for(int start=0; start<n; start++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int result = 0;
            for(int i=0; i<n; i++){
                int value = 0;
                if(start+i < n){
                    value = Integer.parseInt(values[start+i]);
                }
                else{
                    value = Integer.parseInt(values[start+i-n]);
                }
                if(map.get(value) != null && map.get(value)+1 > k){
                    answer = Math.max(answer, result);
                    break;
                }
                result += 1;
                map.put(value, map.getOrDefault(value, 0)+1);
            }
        }
        System.out.println(answer);
    }
}
