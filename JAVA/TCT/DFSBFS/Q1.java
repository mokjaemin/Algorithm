package JAVA.TCT.DFSBFS;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        String[] new_info = info.split(" ");
        int n = Integer.valueOf(new_info[0]);
        int m = Integer.valueOf(new_info[1]);
        int k = Integer.valueOf(new_info[2]);
        int x = Integer.valueOf(new_info[3]);
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<=n; i++){
            map.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            String now = scanner.nextLine();
            int from = (int)(now.charAt(0)-48);
            int to = (int)(now.charAt(2)-48);
            map.get(from).add(to);
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(0)));
        queue.add(Arrays.asList(0, x));
        while(queue.size()>0){
            List<Integer> now = queue.poll();
            int cost = now.get(0);
            int node = now.get(1);
            if(cost >= distance[node]){
                continue;
            }
            distance[node] = cost;
            for(int next : map.get(node)){
                queue.add(Arrays.asList(cost+1, next));
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<=n; i++){
            if(distance[i] == k){
                answer.add(i);
            }
        }
        if(answer.size() == 0){
            System.out.println(-1);
        }
        else{
            Collections.sort(answer);
            for(int i : answer){
                System.out.println(i);
            }
        }
    }
}
