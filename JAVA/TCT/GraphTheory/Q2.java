package JAVA.TCT.GraphTheory;

import java.util.*;

public class Q2 {
    public static int[] parent;
    public static void main(String[] args){

        // 기본 입력 및 설정
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();
        parent = new int[g+1];
        for(int i=0; i<=g; i++){
            parent[i] = i;
        }
        List<Integer> planes = new ArrayList<>();
        for(int i=0; i<p; i++){
            planes.add(sc.nextInt());
        }

        // 로직
        int result = 0;
        for(int plane1 : planes){
            int parent1 = find_parent(plane1);
            if(parent1 == 0){
                break;
            }
            result += 1;
            union_parent(parent1, parent1-1);
            for(int i : parent){
                System.out.print(i);
            }
            System.out.println(" ");
        }
        System.out.println(result);
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
