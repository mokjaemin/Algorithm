package BAEKJOON_RANDOM2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 숨바꼭질 3
public class Q14 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        int n = Integer.parseInt(value.split(" ")[0]);
        int k = Integer.parseInt(value.split(" ")[1]);
        int count = 0;
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(arr->arr.get(0)));
        queue.add(Arrays.asList(0, n));
        boolean[] visited = new boolean[100001];
        while(queue.size() > 0){
            List<Integer> now = queue.poll();
            int cost = now.get(0);
            int pos = now.get(1);
            if(pos == k){
                System.out.println(cost);
                break;
            }
            if(visited[pos]){
                continue;
            }
            visited[pos] = true;
            if(pos-1 >= 0){
                queue.add(Arrays.asList(cost+1, pos-1));
            }
            if(pos+1 <= 100000){
                queue.add(Arrays.asList(cost+1, pos+1));
            }
            if(pos*2 <= 100000){
                queue.add(Arrays.asList(cost, pos*2));
            }
        }
    }
}
