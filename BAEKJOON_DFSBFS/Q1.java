package BAEKJOON_DFSBFS;


import java.util.*;

// 1. DFS와 BFS
public class Q1 {
    public static List<List<Integer>> nodes = new ArrayList<>();
    public static List<Integer> resultDFS = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        for(int i=0; i<n+1; i++){
            nodes.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            nodes.get(x).add(y);
            nodes.get(y).add(x);
        }
        for(List<Integer> node : nodes){
            Collections.sort(node);
        }

        // BFS
        List<Integer> resultBFS = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(start);
        while(queue.size() > 0){
            int now = queue.remove(0);
            if(visited[now]){
                continue;
            }
            visited[now] = true;
            resultBFS.add(now);
            for(int node : nodes.get(now)){
                queue.add(node);
            }
        }
        dfs(start, new boolean[n+1]);
        for(int i : resultDFS){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
        for(int i : resultBFS){
            System.out.print(i);
            System.out.print(" ");
        }
    }
    public static void dfs(int start, boolean[] visited){
        if(visited[start]){
            return;
        }
        visited[start] = true;
        resultDFS.add(start);
        for(int node : nodes.get(start)){
            dfs(node, visited);
        }
    }
}
