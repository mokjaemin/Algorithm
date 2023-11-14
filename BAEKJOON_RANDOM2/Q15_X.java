package BAEKJOON_RANDOM2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// A와 B 2
public class Q15_X {
    public static int TA;
    public static int TB;
    public static String T;
    public static boolean success = false;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        T = br.readLine();
        if(S.equals(T)){
            System.out.println(1);
            return;
        }
        int SA = 0;
        int SB = 0;
        for(char s : S.toCharArray()){
            if(s == 'A'){
                SA += 1;
            }
            else{
                SB += 1;
            }
        }
        for(char t : T.toCharArray()){
            if(t == 'A'){
                TA += 1;
            }
            else{
                TB += 1;
            }
        }
        check(S, SA, SB);
        if(success){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
    public static void check(String s, int a, int b){
        if(TA < a | TB < b){
            return;
        }
        if(s.length() == T.length()){
            if(s.equals(T)){
                success = true;
            }
            return;
        }
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(s);
        sb1.append("A");
        sb2.append("B");
        sb2.reverse();
        check(sb1.toString(), a+1, b);
        check(sb2.toString(), a, b+1);
    }
}
