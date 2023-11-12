package LCS;

import java.util.*;

public class LCSTEST {
    public static int[][][] LCS;
    public static String X;
    public static String Y;
    public static int n;
    public static int m;
    public static String result;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        X = "ACCABCBAB";
        Y = "CBBBABD";
        n = X.length();
        m = Y.length();
        LCS = new int[n+1][m+1][2];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i == 0 | j == 0){
                    continue;
                }
                // 같으면
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    LCS[i][j][0] = LCS[i-1][j-1][0]+1;
                    LCS[i][j][1] = LCS[i-1][j-1][1];
                    continue;
                }
                // 다른면
                if(LCS[i-1][j-1][1] == 0 | LCS[i-1][j][1] == 0){
                    int value = 0;
                    value = Math.max(value, LCS[i-1][j-1][0]);
                    value = Math.max(value, LCS[i-1][j][0]);
                    if(LCS[i-1][j-1][1] == 0){
                        if(LCS[i-1][j-1][0]+1 <= i && LCS[i-1][j-1][0]+1 <= j){
                            value = Math.max(value, LCS[i-1][j-1][0]+1);
                        }
                    }
                    if(LCS[i-1][j][1] == 0){
                        if(LCS[i-1][j][0]+1 <= i && LCS[i-1][j][0]+1 <= j){
                            value = Math.max(value, LCS[i-1][j][0]+1);
                        }
                    }
                    LCS[i][j][0] = value;
                }
                else{
                    LCS[i][j][0] = Math.max(LCS[i-1][j][0], LCS[i][j-1][0]);
                }
                LCS[i][j][1] = 1;
            }
        }
        System.out.println(Y);
        System.out.println(X);
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                System.out.print(LCS[i][j][0]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
        System.out.println("");
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                System.out.print(LCS[i][j][1]);
                System.out.print(" ");
            }
            System.out.println("");
        }
//        dfs(new ArrayList<>(), n, m);
//        System.out.println(LCS[n][m]);
//        System.out.println(result);
    }
//    public static void dfs(List<Character> list, int x, int y){
//        if(list.size() == LCS[n][m]){
//            StringBuilder sb = new StringBuilder();
//            for(int j=list.size()-1; j>=0; j--){
//                sb.append(list.get(j));
//            }
//            result = sb.toString();
//            return;
//        }
//        if(x-1 < 0 | y-1 < 0){
//            return;
//        }
//        if(LCS[x][y] == LCS[x-1][y]){
//            dfs(list, x-1, y);
//        }
//        if(LCS[x][y] == LCS[x][y-1]){
//            dfs(list, x, y-1);
//        }
//        if(LCS[x][y] != LCS[x-1][y] && LCS[x][y] != LCS[x][y-1]){
//            list.add(X.charAt(x-1));
//            dfs(list, x-1, y-1);
//            list.remove(list.size()-1);
//        }
//    }
}


