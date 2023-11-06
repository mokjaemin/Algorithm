package LCS;

import java.util.*;

public class LCSTEST {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String X = sc.next();
        String Y = sc.next();
        int lenX = X.length();
        int lenY = Y.length();
        HashSet<Character> check = new HashSet<>();
        for(char y : Y.toCharArray()){
            check.add(y);
        }
        int answer = 0;
        // 바꿀 X의 인덱스
        // 500
        for(int a=0; a<lenX; a++){
            // 변경할 값
            // 26
            for(char c : check){
                // 문자열 생성
                // 500
                StringBuilder sb = new StringBuilder();
                for(int x=0; x<lenX; x++){
                    if(x == a){
                        sb.append(c);
                    }
                    else{
                        sb.append(X.charAt(x));
                    }
                }
                String result = sb.toString();
                int[][] LCS = new int[lenX][lenY];
                // 500
                for(int i=0; i<lenX; i++){
                    // 500
                    for(int j=0; j<lenY; j++){
                        if(i == 0 | j == 0){
                            LCS[i][j] = 0;
                        }
                        else if(result.charAt(i) == Y.charAt(j)){
                            LCS[i][j] = LCS[i-1][j-1] + 1;
                        }
                        else{
                            LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                        }
                        answer = Math.max(answer, LCS[i][j]);
                    }
                }
            }
        }
    }
}
