package BAEKJOON_RANDOM2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Q9 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0){
                if(queue.size() == 0){
                    answer.add(0);
                }
                else{
                    answer.add(queue.poll());
                }
            }
            else{
                queue.add(now);
            }
        }
        for(int i : answer){
            System.out.println(i);
        }
    }
}
