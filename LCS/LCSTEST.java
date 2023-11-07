package LCS;

import java.util.*;

public class LCSTEST {
    public static int[][] LCS;
    public static String X = "GBCDFE";
    public static String Y = "ABCDEF";
    public static int n;
    public static int m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(X);
        System.out.println(Y);
        n = X.length();
        m = Y.length();
        LCS = new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i == 0 | j == 0){
                    continue;
                }
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    continue;
                }
                LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
            }
        }
        dfs(new ArrayList<>(), n, m);
    }
    public static void dfs(List<Character> list, int x, int y){
        if(list.size() == LCS[n][m]){
            System.out.println(list);
            return;
        }
        if(x-1 < 0 | y-1 < 0){
            return;
        }
        if(LCS[x][y] == LCS[x-1][y]){
            dfs(list, x-1, y);
        }
        if(LCS[x][y] == LCS[x][y-1]){
            dfs(list, x, y-1);
        }
        if(LCS[x][y] != LCS[x-1][y] && LCS[x][y] != LCS[x][y-1]){
            list.add(X.charAt(x-1));
            dfs(list, x-1, y-1);
            list.remove(list.size()-1);
        }
    }
}
