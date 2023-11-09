package BAEKJOON_RANDOM2;

import java.util.*;

public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String values = sc.next();
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            char value = values.charAt(i);
            if(value == 'H'){
                continue;
            }
            for(int j=-k; j<=k; j++){
                if(j == 0){
                    continue;
                }
                int index = i+j;
                if(index < 0 | index >= n){
                    continue;
                }
                if(visited[index]){
                    continue;
                }
                if(values.charAt(index) == 'P'){
                    continue;
                }
                visited[index] = true;
                answer += 1;
                break;
            }
        }
        System.out.println(answer);
    }
}
