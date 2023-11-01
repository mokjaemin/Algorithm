package BaekJoonRandom;


import java.util.*;

// 수열
public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        int answer = 0;
        int result = 0;
        for(int i=0; i<k; i++){
            result += list.get(i);
        }
        answer = result;
        for(int i=0; i<n-k; i++){
            result += -list.get(i)+list.get(i+k);
            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }
}
