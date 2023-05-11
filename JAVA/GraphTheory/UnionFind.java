package JAVA.GraphTheory;

public class UnionFind {
    public static void main(String[] args){
        int[][] data = {{1, 4}, {2, 3}, {2, 4}, {5, 6}};
        int[] root = {0, 1, 2, 3, 4, 5, 6};
        for(int[] now : data){
            int parent1 = find_parent(now[0] ,root);
            int parent2 = find_parent(now[1] ,root);
            if(parent1 > parent2){
                root[now[0]] = parent2;
            }
            else{
                root[now[1]] = parent1;
            }
        }
        // 부모
        // for(int r : root){
        //     System.out.print(r);
        // }
        System.out.println("");
        // 서로소 집합
        for(int i=0; i<7; i++){
            new_find_parent(i, root);
        }
        System.out.println("");
    }
    public static int find_parent(int x, int[] root){
        if(x != root[x]){
            x = find_parent(root[x], root);
        }
        return x;
    }

    // 경로 압축법
    public static int new_find_parent(int x, int[] root){
        if(x != root[x]){
            System.out.println(root[x]);
            root[x] = find_parent(root[x], root);
        }
        return root[x];
    }
}
