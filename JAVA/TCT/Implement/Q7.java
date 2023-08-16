package JAVA.TCT.Implement;

import java.util.*;

// 치킨 배달
public class Q7 {
    public static List<List<Integer>> new_houses;
    public static List<List<Integer>> new_stores;
    public static int new_m;
    public static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nm = scanner.nextLine();
        int n = (int)(nm.charAt(0)-48);
        int m = (int)(nm.charAt(2)-48);
        int[][] map = new int[n][n];
        List<List<Integer>> houses = new ArrayList<>();
        List<List<Integer>> stores = new ArrayList<>();
        for(int i=0; i<n; i++){
            String now = scanner.nextLine();
            String[] nowList = now.split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.valueOf(nowList[j]);
                if(map[i][j] == 1){
                    houses.add(Arrays.asList(i, j));
                }
                if(map[i][j] == 2){
                    stores.add(Arrays.asList(i, j));
                }
            }
        }
        new_houses = houses;
        new_stores = stores;
        new_m = m;
        boolean[] visited = new boolean[stores.size()];
        find(new ArrayList<>(), visited, 0);
        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
    public static void find(List<List<Integer>> result, boolean[] visited, int start){
        if(result.size() == new_m){
            int count = 0;
            for(List<Integer> house : new_houses){
                int x1 = house.get(0);
                int y1 = house.get(1);
                int now = (int)1e9;
                for(List<Integer> chicken : result){
                    int x2 = chicken.get(0);
                    int y2 = chicken.get(1);
                    now = Math.min(now, Math.abs(x1-x2)+Math.abs(y1-y2));
                }
                count += now;
            }
            answer.add(count);
            return;
        }
        for(int i=start; i<new_stores.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                result.add(new_stores.get(i));
                find(result, visited, i+1);
                result.remove(result.size()-1);
                visited[i] = false;
            }
        }
    }
}
