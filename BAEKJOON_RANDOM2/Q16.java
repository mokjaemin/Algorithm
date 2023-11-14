package BAEKJOON_RANDOM2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// N번째 큰 수
public class Q16 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.comparing(arr -> -arr));
        for(int i=0; i<n; i++){
            String[] values = br.readLine().split(" ");
            for(String value : values){
                queue.add(Long.parseLong(value));
            }
        }
        for(int i=0; i<n-1; i++){
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
