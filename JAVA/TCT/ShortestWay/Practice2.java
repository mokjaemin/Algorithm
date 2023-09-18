package JAVA.TCT.ShortestWay;

import java.util.*;

public class Practice2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        List<List<List<Integer>>> map = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            map.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();
            map.get(x).add(Arrays.asList(y, cost));
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);
        distance[c] = 0;
        boolean[] visited = new boolean[n+1];
        PriorityQueue<List<Integer>> queue
                = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(0)));
        queue.add(Arrays.asList(0, c));
        while(queue.size() > 0){
            List<Integer> now = queue.poll();
            int cost = now.get(0);
            int node = now.get(1);
            if(visited[node]){
                continue;
            }
            visited[node] = true;
            for(List<Integer> info : map.get(node)){
                int next = info.get(0);
                int time = info.get(1);
                if(visited[next]){
                    continue;
                }
                distance[next] = Math.min(distance[next], cost+time);
                queue.add(Arrays.asList(cost+time, next));
            }
        }
        int count = 0;
        int max_value = 0;
        for(int i=1; i<n+1; i++){
            if(i == c){
                continue;
            }
            if(distance[i] < 1000000){
                count += 1;
                max_value = Math.max(max_value, distance[i]);
            }
        }
        System.out.print(count);
        System.out.print(" ");
        System.out.println(max_value);
    }
}
