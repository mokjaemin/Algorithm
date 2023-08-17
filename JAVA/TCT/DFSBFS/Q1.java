package JAVA.TCT.DFSBFS;

import java.util.*;

// 특정 거리의 도시 찾기
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받는 방식 수정
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        List<List<Integer>> map = new ArrayList<>();
        int[] distance = new int[n+1];
        for (int i=0; i<=n; i++) {
            map.add(new ArrayList<Integer>());
            distance[i] = -1;
        }

        for (int i=0; i<m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map.get(from).add(to);
        }

        distance[x] = 0;
        // 수정 부분, 기존 - List<Integer>와 remove 시간복잡도가 떨어진다.
        // PriorityQueue, 무한처리 후 최단거리 왜 안되는지 -> 단방향이기 때문에?
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        while (queue.size() > 0) {
            int now = queue.poll();
            for(int next : map.get(now)){
                if (distance[next] == -1) {
                    distance[next] = distance[now]+1;
                    queue.add(next);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check){
             System.out.println(-1);   
        }
    }
}