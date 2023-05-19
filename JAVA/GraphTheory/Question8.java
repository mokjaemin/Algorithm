package JAVA.GraphTheory;

import java.util.*;
public class Question8 {
    public static void main(String[] args){
        // 노드의 수
        int n = 5;
        // 진입 차수 초기화
        int[] indegree = new int[n+1];
        Arrays.fill(indegree, 0);
        // 연결 여부
        Boolean[][] graph = new Boolean[n+1][n+1];
        for(Boolean[] g : graph){
            Arrays.fill(g, false);
        }
        // 초기 랭크
        int[] data = {5, 4, 3, 2, 1};
        // 초기 랭크에 따른 초기화
        // indegree : 자신보다 높은 랭크 수
        // graph : 노드별 연결여부 (a는 b보다 높다.)
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                graph[data[i]][data[j]] = true;
                indegree[data[j]] += 1;
            }
        }
        int[][] lines = {
            {2, 4},
            {3, 4}
        };
        // indegree : 자신보다 높은 랭크 수 변경
        // graph : 연결 방향 변경
        for(int[] line : lines){
            if(graph[line[0]][line[1]]){
                graph[line[0]][line[1]] = false;
                graph[line[1]][line[0]] = true;
                indegree[line[0]] += 1;
                indegree[line[1]] -= 1;
            }
            else{
                graph[line[1]][line[0]] = false;
                graph[line[0]][line[1]] = true;
                indegree[line[1]] += 1;
                indegree[line[0]] -= 1;
            }
        }
        // 결과
        List<Integer> result = new ArrayList<>();
        // 큐
        List<Integer> queue = new ArrayList<>();

        // 큐 초기화
        for(int i=1; i<n+1; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        // 위상 정렬 결과가 여러개인 경우
        Boolean certain = true;
        // 사이클이 발생하는 경우
        Boolean cycle = false;

        for(int i=0; i<n; i++){
            // 사이클 발생
            // 모든 노드를 확인하기 전에 큐가 빈 경우
            if(queue.size() == 0){
                cycle = true;
                break;
            }
            // 위상 정렬 결과가 여러개인 경우 발생
            // 즉, 순위가 불분명한 경우
            if(queue.size() >= 2){
                certain = false;
                break;
            }
            // 큐 확인
            int now = queue.remove(0);
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
        // 결과 출력
        if(cycle){
            System.out.println("IMPOSSIBLE");
        }
        else if(!certain){
            System.out.println("?");
        }
        else{
            for(int i : result){
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}
