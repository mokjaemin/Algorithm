package BAEKJOON_DFSBFS;


import java.util.*;

// 맥주 마시면서 걸어가기
public class Q11 {
    public static List<List<Integer>> gs;
    public static int[] end = new int[2];
    public static boolean success;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 테스트 수
        int t = sc.nextInt();
        List<String> result = new ArrayList<>();
        for(int a=0; a<t; a++) {
            // 편의점 수
            int n = sc.nextInt();
            int[] pos = {sc.nextInt(), sc.nextInt()};
            gs = new ArrayList<>();
            for(int i=0; i<n; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                gs.add(Arrays.asList(x, y));
            }
            end[0] = sc.nextInt();
            end[1] = sc.nextInt();
            success = false;
            dfs(pos, new boolean[n]);
            if(success){
                result.add("happy");
            }
            else{
                result.add("sad");
            }
        }
        for(String answer : result){
            System.out.println(answer);
        }
    }
    public static void dfs(int[] pos, boolean[] visited){
        if(Math.abs(pos[0]-end[0])+Math.abs(pos[1]-end[1]) <= 20*50){
            success = true;
            return;
        }
        for(int i=0; i<gs.size(); i++){
            int x = gs.get(i).get(0);
            int y = gs.get(i).get(1);
            int distance = Math.abs(pos[0]-x)+Math.abs(pos[1]-y);
            if(!visited[i] && distance <= 20*50){
                visited[i] = true;
                int[] next_pos = {x, y};
                dfs(next_pos, visited);
            }
        }
    }
}
