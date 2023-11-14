package BAEKJOON_RANDOM2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1, 2, 3 더하기 4
public class Q13 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] map = new int[10001];
        int[] num = {2, 3};
        for(int i=1; i<=10000; i++){
            map[i] = 1;
        }
        for(int n : num){
            map[n] += 1;
            for(int i=n+1; i<=10000; i++){
                map[i] += map[i-n];
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            answer.add(map[n]);
        }
        for(int i : answer) {
            System.out.println(i);
        }
    }
}
