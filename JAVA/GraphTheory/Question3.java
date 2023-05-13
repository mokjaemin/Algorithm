package JAVA.GraphTheory;

import java.util.*;
public class Question3 {
    public static void main(String[] args){
        int[][] data = {
            {10, -1}, {10, 1, -1}, {4, 1, -1},
            {4, 3, 1, -1}, {3, 3, -1}
        };
        List<List<Integer>> map = new ArrayList<>();
        List<Integer> time = new ArrayList<>();
        int[] indegree = new int[5];
        for(int i=0; i<5; i++){
            indegree[i] = 0;
        }
        for(int j=0; j<data.length; j++){
            List<Integer> now = new ArrayList<>();
            map.add(now);
            for(int i=1; i<data[j].length-1; i++){
                map.get(data[j][i]-1).add(j);
                indegree[j] += 1;
            }
            time.add(data[j][0]);
        }
        System.out.println(map);
        System.out.println(time);
        for(int i=0; i<5; i++){
            System.out.print(indegree[i]);
        }
        System.out.println("");

        List<Integer> queue = new ArrayList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
                break;
            }
        }
        while(!queue.isEmpty()){
            int now = queue.remove(0);
            for(int i : map.get(now)){
                indegree[i] -= 1;
                if(indegree[i] == 0){
                    queue.add(i);
                    time.set(i, time.get(i)+time.get(now));
                }
            }
        }
        System.out.println(time);
        for(int i=0; i<5; i++){
            System.out.print(indegree[i]);
        }
        System.out.println("");

    }
}
