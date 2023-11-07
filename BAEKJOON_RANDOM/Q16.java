package BAEKJOON_RANDOM;


import java.util.*;

// 크로스 컨트리
public class Q16 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> answer = new ArrayList<>();
        for(int k=0; k<t; k++){
            int n = sc.nextInt();
            int[] map = new int[n+1];
            HashMap<Integer, Integer> count = new HashMap<>();
            for(int i=1; i<n+1; i++){
                map[i] = sc.nextInt();
                count.put(map[i], count.getOrDefault(map[i], 0)+1);
            }
            List<Integer> teams = new ArrayList<>();
            for(int team : count.keySet()){
                if(count.get(team) < 6){
                    continue;
                }
                teams.add(team);
            }
            HashMap<Integer, Integer> count1 = new HashMap<>();
            HashMap<Integer, Integer> point1 = new HashMap<>();
            HashMap<Integer, Integer> five1 = new HashMap<>();
            int point = 0;
            for(int i=1; i<n+1; i++){
                if(teams.contains(map[i])){
                    point += 1;
                    count1.put(map[i], count1.getOrDefault(map[i], 0)+1);
                    if(count1.get(map[i]) == 5){
                        five1.put(map[i], point);
                        continue;
                    }
                    if(count1.get(map[i]) >= 6){
                        continue;
                    }
                    point1.put(map[i], point1.getOrDefault(map[i], 0)+point);
                }
            }
            List<List<Integer>> check = new ArrayList<>();
            for(int team : teams){
                check.add(Arrays.asList(point1.get(team), team, five1.get(team)));
            }
            Collections.sort(check, Comparator.comparing((List<Integer> arr) -> arr.get(0))
                                                .thenComparing(arr -> arr.get(2)));
            answer.add(check.get(0).get(1));
        }
        for(int i : answer){
            System.out.println(i);
        }
    }
}
