package BAEKJOON_RANDOM;


import java.util.*;

// 카드 2
public class Q18 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> list = new LinkedList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        while(list.size() != 1){
            list.poll();
            int value = list.poll();
            list.add(value);
        }
        System.out.println(list.peek());
    }
}
