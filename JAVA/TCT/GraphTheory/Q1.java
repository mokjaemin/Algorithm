package JAVA.TCT.GraphTheory;

import java.util.*;

public class Q1 {
    public static int[] parent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        parent = new int[n];
        int m = sc.nextInt();
        List<Integer> road = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
            parent[i] = i;
        }
        for(int i=0; i<m; i++){
            road.add(sc.nextInt()-1);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    union_parent(i, j);
                }
            }
        }
        boolean result = true;
        int now = road.get(0);
        for(int i=1; i<road.size(); i++){
            int next = road.get(i);
            if(parent[now] != parent[next]){
                result = false;
                break;
            }
            now = next;
        }
        if(result){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    public static int find_parent(int node){
        if(parent[node] != node){
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
