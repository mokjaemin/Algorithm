package JAVA.GraphTheory;

import java.util.*;
public class Question7 {
    public static void main(String[] args){
        int[][] data = {
            {11, -15, -15, 0},
            {14, -5, -15, 1},
            {-1, -1, -5, 2},
            {10, -4, -1, 3},
            {19, -4, 19, 4}
        };
        List<List<Integer>> check = new ArrayList<>();
        int[] parents = new int[5];
        for(int i=0; i<5; i++){
            parents[i] = i;
        }
        for(int i=0; i<3; i++){
            int now = i;
            Arrays.sort(data, Comparator.comparingInt(arr -> arr[now]));
            for(int j=0; j<data.length-1; j++){
                List<Integer> nowList = new ArrayList<>();
                nowList.add(Math.abs(data[j][now] - data[j+1][now]));
                nowList.add(j);
                nowList.add(j+1);
                check.add(nowList);
            }
        }

        int result = 0;
        Collections.sort(check, Comparator.comparingInt(arr -> arr.get(0)));
        for(List<Integer> nowCheck : check){;
            int parent1 = find_paretns(parents, nowCheck.get(1));
            int parent2 = find_paretns(parents, nowCheck.get(2));
            if(parent1 != parent2){
                parents[parent1] = (parent1 > parent2) ? parent2 : parent1;
                parents[parent2] = (parent1 > parent2) ? parent2 : parent1;
                result += nowCheck.get(0);
            }
        }
        System.out.println(result);
        
    }
    public static int find_paretns(int[] parents, int node){
        if(node != parents[node]){
            parents[node] = find_paretns(parents, parents[node]);
        }
        return parents[node];
    }
}
