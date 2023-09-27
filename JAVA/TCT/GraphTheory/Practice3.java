package JAVA.TCT.GraphTheory;


import java.util.*;

// 커리 큘럼
public class Practice3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] graph = new int[n];
        int[] times = new int[n];
        List<List<Integer>> classes = new ArrayList<>();
        for(int i=0; i<n; i++){
            classes.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            times[i] = sc.nextInt();
            while(true){
                int before = sc.nextInt();
                if(before == -1){
                    break;
                }
                graph[i] += 1;
                classes.get(before-1).add(i);
            }
        }
        List<Integer> queue = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(graph[i] == 0){
                queue.add(i);
            }
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = times[i];
        }
        while(queue.size() > 0){
            int now = queue.remove(0);
            for(int next : classes.get(now)){
                // 그전에 방문한 내역 vs now까지 오는데 걸리는 비용 + next의 비용
                result[next] = Math.max(result[next], result[now]+times[next]);
                graph[next] -= 1;
                if(graph[next] == 0){
                    queue.add(next);
                }
            }
        }
        for(int i=0; i<n; i++){
            System.out.println(result[i]);
        }
    }
}
