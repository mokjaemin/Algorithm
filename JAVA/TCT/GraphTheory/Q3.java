package JAVA.TCT.GraphTheory;

import java.util.*;

// 어두운 길
public class Q3 {
    public static int[] parent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        PriorityQueue<List<Integer>> queue
                = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(2)));
        for(int i=0; i<m; i++){
            queue.add(Arrays.asList(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        int result = 0;
        while(queue.size() > 0){
            List<Integer> now = queue.poll();
            int x = now.get(0);
            int y = now.get(1);
            int cost = now.get(2);
            int parent1 = find_parent(x);
            int parent2 = find_parent(y);
            if(parent1 != parent2){
                union_parent(x, y);
            }
            else{
                result += cost;
            }
        }
        System.out.println(result);
    }
    public static int find_parent(int node){
        if(node != parent[node]){
            parent[node] = find_parent(parent[node]);
        }
        return parent[node];
    }
    public static void union_parent(int node1, int node2){
        int parent1 = find_parent(node1);
        int parent2 = find_parent(node2);
        parent[parent1] = (parent1 > parent2) ? parent2 : parent1;
        parent[parent2] = (parent1 > parent2) ? parent2 : parent1;
    }
}
