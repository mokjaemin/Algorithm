package JAVA.GraphTheory;


// 여행 계획
public class Question4 {
    public static void main(String[] args){
        int n = 5;
        int[][] map = {
            {0, 1, 0, 1, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        int[] parents = new int[n+1];
        for(int i=0; i<n+1; i++){
            parents[i] = i;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    int parent1 = find_parent(parents, i+1);
                    int parent2 = find_parent(parents, j+1);
                    parents[parent1] = (parent1 > parent2) ? parent2 : parent1;
                    parents[parent2] = (parent1 > parent2) ? parent2 : parent1;
                }
            }
        }
        for(int i : parents){
            System.out.print(i);
        }
        System.out.println(" ");

    }
    public static int find_parent(int[] parents, int node){
        if(parents[node] != node){
            parents[node] = find_parent(parents, parents[node]);
        }
        return parents[node];
    }
}
