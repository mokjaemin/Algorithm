package BAEKJOON_DFSBFS;

import java.util.*;

// 촌수 계산
public class Q5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> nodes = new ArrayList<>();
        for(int i=0; i<=n; i++){
            nodes.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            nodes.get(x).add(y);
            nodes.get(y).add(x);
        }

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(0)));
        queue.add(Arrays.asList(0, start));
        boolean[] visited = new boolean[n+1];
        while(queue.size() > 0){
            List<Integer> now = queue.poll();
            int cost = now.get(0);
            int node = now.get(1);
            if(node == end){
                System.out.println(cost);
                return;
            }
            if(visited[node]){
                continue;
            }
            visited[node] = true;
            for(int next : nodes.get(node)){
                queue.add(Arrays.asList(cost+1, next));
            }
        }
        System.out.println(-1);
    }
}
