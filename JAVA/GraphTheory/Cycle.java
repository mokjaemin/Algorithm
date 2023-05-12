package JAVA.GraphTheory;

public class Cycle {
    public static void main(String[] args){
        int[][] lines = {{1, 2}, {1, 3}, {2, 3}};
        int[] parents = {0, 1, 2, 3};
        for(int[] line : lines){
            int parent1 = find_parent(parents, line[0]);
            int parent2 = find_parent(parents, line[1]);
            if(parent1 > parent2){
                parents[line[0]] = parent2;
            }
            else if(parent1 == parent2){
                System.out.println("사이클 발생");
            }
            else{
                parents[line[1]] = parent1;
            }
        }

    }
    private static int find_parent(int[] parents, int node){
        if(parents[node] != node){
            parents[node] = find_parent(parents, parents[node]);
        }
        return parents[node];
    }
}
