package BackJoonDfsBfs;

import java.util.*;

// 바이러스
public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> nodes = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            nodes.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            nodes.get(x).add(y);
            nodes.get(y).add(x);
        }
        int count = 0;
        List<Integer> queue = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(1);
        while(queue.size() > 0){
            int now = queue.remove(0);
            if(visited[now]){
                continue;
            }
            visited[now] = true;
            count += 1;
            for(int next : nodes.get(now)){
                queue.add(next);
            }
        }
        if(count <= 1){
            System.out.println(0);
        }
        else{
            System.out.println(count-1);
        }
    }
}
