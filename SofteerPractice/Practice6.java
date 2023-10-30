package SofteerPractice;

import java.util.*;

// 6. 지우는 소수를 좋아해 - 그래프 이론 (크루스칼 알고리즘)
public class Practice6 {
    public static int[] parent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 체육관 수
        int n = sc.nextInt();
        // 길의 수
        int m = sc.nextInt();
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<m; i++){
            map.add(Arrays.asList(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        // 비용별로 정렬
        Collections.sort(map, Comparator.comparing(arr -> arr.get(2)));

        // 부모 초기화
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        // 크루스칼 알고리즘 적용
        int result = 0;
        while(map.size() > 0){
            List<Integer> now = map.remove(0);
            int node1 = now.get(0);
            int node2 = now.get(1);
            int cost = now.get(2);
            if(find_parent(node1) != find_parent(node2)){
                union_parent(node1, node2);
                result = Math.max(result, cost);
            }
        }
        if(result % 2 == 0){
            result += 1;
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
        parent[node1] = parent[parent1];
        parent[node2] = parent[parent2];
    }
}
