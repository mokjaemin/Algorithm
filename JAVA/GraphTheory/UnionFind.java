package JAVA.GraphTheory;

public class UnionFind {
    public static void main(String[] args){
        int[][] data = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
        int[] root = {0, 1, 2, 3, 4, 5, 6};
        for(int[] now : data){
            int parent1 = new_find_parent(now[0] ,root);
            int parent2 = new_find_parent(now[1] ,root);
            if(parent1 > parent2){
                root[parent1] = parent2;
            }
            else{
                root[parent2] = parent1;
            }
        }
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
            root[x] = new_find_parent(root[x], root);
        }
        return root[x];
    }
}
