package BAEKJOON_DFSBFS;

import java.util.*;

// 숨바꼭질
public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(1)));
        queue.add(Arrays.asList(n, 0));
        // 시간복잡도 줄이기 1 : 방문처리
        boolean[] visited = new boolean[100002];
        while(queue.size() > 0){
            List<Integer> now = queue.poll();
            int x = now.get(0);
            int cost = now.get(1);
            if(x == k){
                System.out.println(cost);
                break;
            }
            // 시간복잡도 줄이기 2 : 범위 벗어나는지 처리
            if(x > 100001 | x < 0){
                continue;
            }
            if(visited[x]){
                continue;
            }
            visited[x] = true;
            queue.add(Arrays.asList(x-1, cost+1));
            queue.add(Arrays.asList(x+1, cost+1));
            queue.add(Arrays.asList(x*2, cost+1));
        }
    }
}
