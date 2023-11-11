package BAEKJOON_RANDOM2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// IF 문 좀 대신 써줘
public class Q7 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            int key = Integer.parseInt(st.nextToken());
            if(map.get(key) == null){
                map.put(key, value);
            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        List<String> answer = new ArrayList<>();
        for(int i=0; i<m; i++){
            int now = Integer.parseInt(br.readLine());
            int start = 0;
            int end = keys.size()-1;
            int result = keys.get(end);
            while(start <= end){
                int mid = (start+end)/2;
                int value = keys.get(mid);
                if(now <= value){
                    result = Math.min(result, value);
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            answer.add(map.get(result));
        }
        for(String a : answer){
            System.out.println(a);
        }
    }
}
