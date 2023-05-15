package JAVA.GraphTheory;


import java.util.*;
public class Question6 {
    public static void main(String[] args){
        int n = 7;
        int[][] lines ={
            {0, 1, 7},
            {0, 3, 5},
            {1, 2, 8},
            {1, 3, 9},
            {1, 4, 7},
            {2, 4, 5},
            {3, 4, 15},
            {3, 5, 6},
            {4, 5, 8},
            {4, 6, 9},
            {5, 6, 11}
        };
        Arrays.sort(lines, Comparator.comparingInt(arr -> arr[2]));
        int[] parents = new int[n+1];
        for(int i=0; i<n+1; i++){
            parents[i] = i;
        }
        int result = 0;
        int base = 0;
        for(int[] line : lines){
            base += line[2];
            int parent1 = find_parents(parents, line[0]);
            int parent2 = find_parents(parents, line[1]);
            if(parent1 != parent2){
                result += line[2];
                parents[parent1] = (parent1>parent2) ? parent2 : parent1;
                parents[parent2] = (parent1>parent2) ? parent2 : parent1;
            }
        }
        System.out.println(base-result);
    }
    public static int find_parents(int[] parents, int node){
        if(node != parents[node]){
            parents[node] = find_parents(parents, parents[node]);
        }
        return parents[node];
    }
}
