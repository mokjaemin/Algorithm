package JAVA.TCT.GraphTheory;

import java.util.*;

// 팀 결성
public class Practice1 {
    public static int[] parent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        List<String> result = new ArrayList<>();
        for(int i=0; i<m; i++){
            int work = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(work == 0){
                int parent1 = find(a);
                int parent2 = find(b);
                union(parent1, parent2);
            }
            else{
                if(find(a) == find(b)){
                    result.add("YES");
                }
                else{
                    result.add("NO");
                }
            }
        }
        for(String s : result){
            System.out.println(s);
        }
    }
    public static int find(int index){
        if(parent[index] != index){
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
    public static void union(int parent1, int parent2){
        parent[parent1] = (parent1 > parent2) ? parent2 : parent1;
        parent[parent2] = (parent1 > parent2) ? parent2 : parent1;
    }
}
