package JAVA.GraphTheory;

import java.util.*;
public class Question8 {
    public static void main(String[] args){
        List<List<Integer>> map = new ArrayList<>();
        int[] original = {5, 4, 3, 2, 1};
        List<Integer> new_original = new ArrayList<>();
        int[][] lines = {{2, 4}, {3, 4}};
        for(int i=0; i<original.length; i++){
            new_original.add(original[i]);
            List<Integer> new_map = new ArrayList<>();
            if(i == 0){
                map.add(new_map);
                continue;
            }
            for(int j=i-1; j>=0; j--){
                new_map.add(original[j]);
            }
            map.add(new_map);
        }
        System.out.println(map);
        for(int[] line : lines){
            int index0 = new_original.indexOf(line[0]);
            int index1 = new_original.indexOf(line[1]);
            if(map.get(index0).contains(line[1])){
                map.get(index0).remove(Integer.valueOf(line[1]));
                map.get(index1).add(line[0]);
                System.out.println(map);
                continue;
            }
            map.get(index1).remove(Integer.valueOf(line[0]));
            map.get(index0).add(line[1]);
            System.out.println(map);
        }
        // for(int i=0; i<map.size(); i++){
        //     if(map.get(i).size() == 0){
        //         List<Integer> queue = new ArrayList<>();
        //         queue.add(original[i]);
        //         while(queue.size() > 0){
        //             int now = queue.remove(0);
                    
        //         }
        //         break;
        //     }
        // }
        System.out.println(Boolean.valueOf(true));
    }
}
