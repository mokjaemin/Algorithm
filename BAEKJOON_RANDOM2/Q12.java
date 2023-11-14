package BAEKJOON_RANDOM2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// LCS 2
public class Q12 {
    public static String value1;
    public static String value2;
    public static String answer;
    public static boolean success = false;
    public static int[][] map;
    public static int n;
    public static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        value1 = br.readLine();
        value2 = br.readLine();
        n = value1.length();
        m = value2.length();
        map = new int[n+1][m+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(value1.charAt(i-1) == value2.charAt(j-1)){
                    map[i][j] = map[i-1][j-1] + 1;
                }
                else{
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
            }
        }
        System.out.println(map[n][m]);
        dfs(new ArrayList<>(), n, m);
        System.out.println(answer);
    }
    public static void dfs(List<Character> list, int x, int y){
        if(list.size() == map[n][m]){
            StringBuilder sb = new StringBuilder();
            for(int j=list.size()-1; j>=0; j--){
                sb.append(list.get(j));
            }
            answer = sb.toString();
            success = true;
            return;
        }
        if(success){
            return;
        }
        if(x-1 < 0 | y-1 < 0){
            return;
        }
        if(map[x][y] == map[x-1][y]){
            dfs(list, x-1, y);
        }
        if(success){
            return;
        }
        if(map[x][y] == map[x][y-1]){
            dfs(list, x, y-1);
        }
        if(success){
            return;
        }
        if(map[x][y] != map[x-1][y] && map[x][y] != map[x][y-1]){
            list.add(value1.charAt(x-1));
            dfs(list, x-1, y-1);
            list.remove(list.size()-1);
        }
    }
}
