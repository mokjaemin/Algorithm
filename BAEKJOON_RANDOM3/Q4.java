package BAEKJOON_RANDOM3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

// 택배 배송
public class Q4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<List<Integer>>> roads = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            roads.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            roads.get(x).add(Arrays.asList(y, c));
            roads.get(y).add(Arrays.asList(x, c));
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(0)));
        queue.add(Arrays.asList(0, 1));
        boolean[] visited = new boolean[n+1];
        while(!queue.isEmpty()){
            List<Integer> now = queue.poll();
            int cost = now.get(0);
            int node = now.get(1);
            if(visited[node]){
                continue;
            }
            if(node == n){
                System.out.println(cost);
                break;
            }
            visited[node] = true;
            for(List<Integer> next : roads.get(node)){
                queue.add(Arrays.asList(next.get(1)+cost, next.get(0)));
            }
        }
    }
}
