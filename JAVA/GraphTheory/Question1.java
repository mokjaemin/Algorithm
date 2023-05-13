package JAVA.GraphTheory;

public class Question1 {
    public static void main(String[] args){
        int[][] data = {
            {0, 1, 3}, {1, 1, 7}, {0, 7, 6}, {1, 7, 1},
            {0, 3, 7}, {0, 4, 2}, {0, 1, 1}, {1, 1, 1}
        };
        int[] parents = new int[8];
        for(int i=0; i<8; i++){
            parents[i] = i;
        }
        for(int[] now : data){
            if(now[0] == 0){
                int parent1 = find_parent(parents, now[1]);
                int parent2 = find_parent(parents, now[2]);
                parents[parent1] = (parent1 > parent2) ? parent2 : parent1;             
                parents[parent2] = (parent1 > parent2) ? parent2 : parent1;
                continue;
            }
            if(find_parent(parents, now[1]) == find_parent(parents, now[2])){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    public static int find_parent(int[] parents, int node){
        if(node != parents[node]){
            parents[node] = find_parent(parents, parents[node]);
        }
        return parents[node];
    }
}
