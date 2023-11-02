package BackJoon_DFSBFS;


import java.util.*;

// 스타트 링크
public class Q8 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // 총 층의 수
        int F = sc.nextInt();
        // 강호가 있는 층
        int S = sc.nextInt();
        // 스타트링크가 위치한 층
        int G = sc.nextInt();
        // 위로가는 층의 수
        int U = sc.nextInt();
        // 아래로 가는 층의 수
        int D = sc.nextInt();

        PriorityQueue<List<Integer>> queue
                = new PriorityQueue<>(Comparator.comparing(arr -> arr.get(1)));
        queue.add(Arrays.asList(S, 0));

        int result = 0;
        boolean success = false;
        boolean[] visited = new boolean[F+1];
        while(queue.size() > 0){
            List<Integer> now = queue.poll();
            int x = now.get(0);
            int cost = now.get(1);
            if(x == G){
                success = true;
                result = cost;
                break;
            }
            if(x <= 0 | x > F){
                continue;
            }
            if(visited[x]){
                continue;
            }
            visited[x] = true;
            queue.add(Arrays.asList(x+U, cost+1));
            queue.add(Arrays.asList(x-D, cost+1));
        }
        if(success){
            System.out.println(result);
        }
        else{
            System.out.println("use the stairs");
        }
    }
}
