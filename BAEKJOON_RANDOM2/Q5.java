package BAEKJOON_RANDOM2;


import java.util.*;

// KCPC
public class Q5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for(int test=0; test<t; test++){
            // 팀의 수
            int n = sc.nextInt();
            // 최근 제출 시간
            int[] latest = new int[n+1];
            // 풀이 제출 횟수
            int[] count = new int[n+1];
            // 문제의 수
            int k = sc.nextInt();
            // 팀별 문제별 최고점
            int[][] probs = new int[n+1][k+1];
            // 팀 아이디
            int myId = sc.nextInt();
            // 로그의 수
            int log = sc.nextInt();
            for(int i=0; i<log; i++){
                int id = sc.nextInt();
                int prob = sc.nextInt();
                int score = sc.nextInt();
                probs[id][prob] = Math.max(probs[id][prob], score);
                latest[id] = Math.max(latest[id], i);
                count[id] += 1;
            }
            List<List<Integer>> teams = new ArrayList<>();
            for(int i=0; i<=n; i++){
                teams.add(new ArrayList<>());
            }
            for(int i=1; i<=n; i++){
                int sum = 0;
                for(int j : probs[i]){
                    sum += j;
                }
                teams.get(i).add(i);
                teams.get(i).add(sum);
                teams.get(i).add(count[i]);
                teams.get(i).add(latest[i]);
            }
            teams.remove(0);
            Collections.sort(teams, Comparator.comparing((List<Integer> arr) -> -arr.get(1))
                                            .thenComparing(arr -> arr.get(2))
                                            .thenComparing(arr -> arr.get(3)));
            int rank = 1;
            for(List<Integer> team : teams){
                if(team.get(0) == myId){
                    result.add(rank);
                }
                rank += 1;
            }
        }
        for(int i : result){
            System.out.println(i);
        }
    }
}
