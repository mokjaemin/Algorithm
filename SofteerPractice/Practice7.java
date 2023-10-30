package SofteerPractice;


import java.util.*;

// 7. 출퇴근길 - DFS
public class Practice7 {
    public static List<List<Integer>> map = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<=n; i++){
            map.add(new ArrayList<>());
        }
        // 길 정보
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.get(x).add(y);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        List<Integer> answer = new ArrayList<>();
        int result = 0;

        // 시작점 -> 끝점
        int[] s_point = new int[n+1];
        List<Integer> way = new ArrayList<>();
        way.add(start);
        find(start, end, way, new boolean[n+1], s_point);

        // 끝점 -> 시작점
        int[] e_point = new int[n+1];
        way = new ArrayList<>();
        way.add(end);
        find(end, start, way, new boolean[n+1], e_point);
        for(int i=1; i<n+1; i++){
            int p = e_point[i];
            if(p == 1 && s_point[i] == 1){
                result += 1;
            }
        }

        System.out.println(result-2);
    }
    public static void find(int start, int end, List<Integer> way, boolean[] visited, int[] point){
        int now = way.get(way.size()-1);
        // 목표까지 방문 시
        if(now == end){
            for(int w : way){
                if(point[w] == 0){
                    point[w] += 1;
                }
            }
            return;
        }
        // 시작점으로 돌아왔을 시
        if(now == start && visited[start]){
            for(int w : way){
                if(point[w] == 0){
                    point[w] += 1;
                }
            }
            return;
        }
        // 재방문 처리
        if(visited[now]){
            return;
        }
        // 다음 방문 처리
        for(int next : map.get(now)){
            visited[now] = true;
            way.add(next);
            find(start, end, way, visited, point);
            visited[now] = false;
            way.remove(way.size()-1);
        }
    }
}
