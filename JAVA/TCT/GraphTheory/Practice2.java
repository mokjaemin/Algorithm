package JAVA.TCT.GraphTheory;

import java.util.*;

// 도시 분할 계획
public class Practice2 {
    public static int[] parent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 부모 리스트 갱신
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        List<List<Integer>> queue = new ArrayList<>();
        for(int i=0; i<m; i++){
            queue.add(Arrays.asList(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        // 정렬
        Collections.sort(queue, Comparator.comparing(arr -> arr.get(2)));
        int result = 0;
        int last = 0;
        for(List<Integer> info : queue){
            int node1 = info.get(0);
            int node2 = info.get(1);
            int cost = info.get(2);
            // 부모 파악
            int parent1 = find(node1);
            int parent2 = find(node2);
            // 사이클 발생시 도로 설치 안함
            if(parent1 == parent2){
                continue;
            }
            // 부모 파악 및 합치기 연산
            union(node1, node2);
            result += cost;
            last = cost;
        }
        System.out.println(result-last);
    }
    public static int find(int node){
        if(parent[node] != node){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    public static void union(int x, int y){
        int parent1 = find(x);
        int parent2 = find(y);
        parent[parent1] = (parent1 > parent2) ? parent2 : parent1;
        parent[parent2] = (parent1 > parent2) ? parent2 : parent1;
    }
}
