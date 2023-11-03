package BAEKJOON_RANDOM;


import java.util.*;

// ZOAC 4
public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int answer = 0;
        for(int i=0; i<n; i+=a+1){
            for(int j=0; j<m; j+=b+1){
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
