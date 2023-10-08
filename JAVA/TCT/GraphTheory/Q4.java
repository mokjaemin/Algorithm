package JAVA.TCT.GraphTheory;

import java.util.*;

class Point implements Comparable<Point>{
    public int value;
    public int index;
    public Point(int value, int index){
        this.value = value;
        this.index = index;
    }
    @Override
    public int compareTo(Point other){
        if(this.value == other.value){
            return Integer.compare(this.index, other.index);
        }
        return Integer.compare(this.value, other.value);
    }
}

class Edge implements Comparable<Edge>{
    public int distance;
    public int index1;
    public int index2;
    public Edge(int distance, int index1, int index2){
        this.distance = distance;
        this.index1 = index1;
        this.index2 = index2;
    }
    @Override
    public int compareTo(Edge other){
        if(this.distance < other.distance){
            return -1;
        }
        return 1;
    }
}

public class Q4 {
    public static int[] parent;
    public static void main(String[] args){
        // 정보 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        List<Point> x = new ArrayList<>();
        List<Point> y = new ArrayList<>();
        List<Point> z = new ArrayList<>();
        for(int i=0; i<n; i++){
            x.add(new Point(sc.nextInt(), i+1));
            y.add(new Point(sc.nextInt(), i+1));
            z.add(new Point(sc.nextInt(), i+1));
        }
        // 정렬
        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(z);
        // 간선 정보 추출
        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<n-1; i++){
            // 거리, 행성인덱스1, 행성인덱스2
            edges.add(new Edge(x.get(i+1).value-x.get(i).value,
                    x.get(i).index, x.get(i+1).index));
            edges.add(new Edge(y.get(i+1).value-y.get(i).value,
                    y.get(i).index, y.get(i+1).index));
            edges.add(new Edge(z.get(i+1).value-z.get(i).value,
                    z.get(i).index, z.get(i+1).index));
        }
        // 종합 정보 정렬
        Collections.sort(edges);
        // 크루스칼 로직
        int result = 0;
        for(Edge edge : edges){
            int cost = edge.distance;
            int star1 = edge.index1;
            int star2 = edge.index2;
            int parent1 = find_parent(star1);
            int parent2 = find_parent(star2);
            if(parent1 == parent2){
                continue;
            }
            result += cost;
            union_parent(star1, star2);
        }
        System.out.println(result);
    }
    public static int find_parent(int star){
        if(parent[star] != star){
            parent[star] = find_parent(parent[star]);
        }
        return parent[star];
    }
    public static void union_parent(int star1, int star2){
        int parent1 = find_parent(star1);
        int parent2 = find_parent(star2);
        parent[parent1] = (parent1 > parent2) ? parent2 : parent1;
        parent[parent2] = (parent1 > parent2) ? parent2 : parent1;
    }
}
