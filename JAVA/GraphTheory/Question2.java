package JAVA.GraphTheory;

import java.util.*;
public class Question2 {
    public static void main(String[] args){
        int[][] data = {
            {1, 2, 3}, {1, 3, 2}, {3, 2, 1}, {2, 5, 2}, {3, 4, 4},
            {7, 3, 6}, {5, 1, 5}, {1, 6, 2}, {6, 4, 1}, {6, 5, 3},
            {4, 5, 3}, {6, 7, 4}
        };
        Arrays.sort(data, Comparator.comparingInt(arr -> arr[2]));
        int[] parents = new int[8];
        for(int i=0; i<8; i++){
            parents[i] = i;
        }
        List<Integer> costs = new ArrayList<>();
        int result = 0;
        for(int[] i : data){
            int parent1 = find_parent(parents, i[0]);
            int parent2 = find_parent(parents, i[1]);
            if(parent1 != parent2){
                parents[parent1] = (parent1 > parent2) ? parent2 : parent1;
                parents[parent2] = (parent1 > parent2) ? parent2 : parent1;
                costs.add(i[2]);
                result += i[2];
            }
        }
        result -= Collections.max(costs);
        System.out.println(result);
    }
    public static int find_parent(int[] parents, int node){
        if(node != parents[node]){
            parents[node] = find_parent(parents, parents[node]);
        }
        return parents[node];
    }
}
