package JAVA.TCT.ShortestWay;


import java.util.*;

// 숨바꼭질
public class Q4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            map.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.get(x).add(y);
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);
        PriorityQueue<List<Integer>> queue
                = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(0)));
        queue.add(Arrays.asList(0, 1));
        int max_value = 0;
        while(queue.size() > 0){
            List<Integer> now = queue.poll();
            int cost = now.get(0);
            int node = now.get(1);
            if(cost > distance[node]){
                continue;
            }
            distance[node] = cost;
            max_value = Math.max(max_value, cost);
            for(int next : map.get(node)){
                if(cost+1 > distance[next]){
                    continue;
                }
                queue.add(Arrays.asList(cost+1, next));
            }
        }
        int count = 1;
        int index = 0;
        for(int i=1; i<=n; i++){
            if(distance[i] == max_value){
                if(index == 0){
                    index = i;
                }
                count += 1;
            }
        }
        System.out.print(index);
        System.out.print(" ");
        System.out.print(max_value);
        System.out.print(" ");
        System.out.print(count);
    }
}
