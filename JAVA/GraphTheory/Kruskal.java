package JAVA.GraphTheory;
import java.util.*;
public class Kruskal {
    public static void main(String[] args){
        int[][] lines = {
            {29, 1, 2}, {35, 2, 3}, {7, 3, 4}, {13, 4, 7},
            {23, 4, 6}, {25, 6, 7}, {34, 2, 6}, {53, 5, 6},
            {75, 1, 5}
        };
        int[] parents = {0, 1, 2, 3, 4, 5, 6, 7};
        int result = 0;
        Arrays.sort(lines, Comparator.comparingInt(arr -> arr[0]));
        for(int[] line : lines){
            int parent1 = find_parent(parents, line[1]);
            int parent2 = find_parent(parents, line[2]);
            if(parent1 != parent2){
                parents[line[1]] = (parent1 > parent2) ? parent2 : parent1;
                parents[line[2]] = (parent1 > parent2) ? parent2 : parent1;
                result += line[0];
            }
        }
        System.out.println(result);
    }
    public static int find_parent(int[] parents, int node){
        if(node != parents[node]){
            parents[node] = find_parent(parents, parents[node]);
        }
        return parents[node];
    }
}
