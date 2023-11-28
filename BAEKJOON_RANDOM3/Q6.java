package BAEKJOON_RANDOM3;

import java.util.*;

public class Q6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(0)));
        for(int i=0; i<n; i++){
            queue.add(Arrays.asList(sc.nextInt(), 1));
        }
        int m = sc.nextInt();
        for(int i=0; i<m-1; i++){
            List<Integer> now = queue.poll();
            queue.add(Arrays.asList(now.get(0)*(now.get(1)+1), now.get(1)+1));
        }
        System.out.println(queue.poll().get(0));
    }
}
