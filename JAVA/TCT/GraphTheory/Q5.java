package JAVA.TCT.GraphTheory;


import java.util.*;

// 최종 순위
public class Q5 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        // 반복 횟수
        int t = sc.nextInt();
        for(int tc=0; tc<t; tc++){
            // 사람 수
            int n = sc.nextInt();
            // 진입 차수
            int[] indegree = new int[n+1];
            // 사람마다 관계 그래프
            boolean[][] graph = new boolean[n+1][n+1];
            // 작년 순위
            List<Integer> lastYear = new ArrayList<>();
            for(int i=0; i<n; i++){
                lastYear.add(sc.nextInt());
            }
            // 작년 순위를 바탕으로 초기화
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    // graph[a][b]가 true 이면 a가 b보다 순위가 높다.
                    graph[lastYear.get(i)][lastYear.get(j)] = true;
                    // indegree = 자신보다 높은 순위의 사람 수
                    indegree[lastYear.get(j)] += 1;
                }
            }

            // 순위 변동
            int m = sc.nextInt();
            for(int i=0; i<m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                // 기존에 a가 b보다 순위가 높았다면
                if(graph[a][b]){
                    // b가 a보다 순위가 높다.
                    graph[a][b] = false;
                    graph[b][a] = true;
                    // a보다 순위가 높은 사람 수 증가
                    indegree[a] += 1;
                    // b보다 순위가 높은 사람 수 감소
                    indegree[b] -= 1;
                }
                else{
                    graph[a][b] = true;
                    graph[b][a] = false;
                    indegree[a] -= 1;
                    indegree[b] += 1;
                }
            }

            // 위상 정렬
            List<Integer> result = new ArrayList<>();
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i=1; i<n+1; i++){
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
            // 위상 정렬 결과가 오로지 하나인지? : 정확한 순위를 찾을 수 없다
            boolean certain = true;
            // 그래프 내 사이클이 발생하는지? : 데이터에 일관성이 없다.
            boolean cycle = false;

            for(int i=0; i<n; i++){
                if(queue.size() >= 2){
                    certain = false;
                    break;
                }
                if(queue.size() == 0){
                    cycle = true;
                    break;
                }
                int now = queue.poll();
                result.add(now);
                for(int j=1; j<n+1; j++){
                    if(graph[now][j]){
                        indegree[j] -= 1;
                        if(indegree[j] == 0){
                            queue.add(j);
                        }
                    }
                }
            }

            if(cycle){
                System.out.println("IMPOSSIBLE");
            }
            else if(!certain){
                System.out.println("?");
            }
            else{
                for(int i : result){
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println("");
            }
        }
    }
}
