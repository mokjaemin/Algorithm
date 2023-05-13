package JAVA.GraphTheory;

import java.util.*;

import javax.management.openmbean.ArrayType;
public class TopologySort {
    public static void main(String[] args){
        int[][] lines = {{1, 2}, {1, 5}, {2, 3}, {2, 6}, {3, 4}, {4, 7}, {5, 6}, {6, 4}};
        List<List<Integer>> map = new ArrayList<>();
        int[] indegree = new int[8];
        for(int i=0; i<8; i++){
            List<Integer> test_map = new ArrayList<>();
            map.add(test_map);
            indegree[i] = 0;
        }
        for(int[] line : lines){
            map.get(line[0]).add(line[1]);
            indegree[line[1]] += 1;
        }
        System.out.println(map);
        for(int i : indegree){
            System.out.print(i);
        }
        System.out.println(" ");

        List<Integer> queue = new ArrayList<>();
        for(int i=1 ; i<indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        System.out.println(queue);
        List<Integer> answer = new ArrayList<>();
        while(queue.size() > 0){
            int now_node = queue.remove(0);
            answer.add(now_node);
            for(int i : map.get(now_node)){
                indegree[i] -= 1;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        for(int i : answer){
            System.out.print(i);
        }
        System.out.print("");
    }    
}
