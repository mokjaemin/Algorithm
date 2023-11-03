package BAEKJOON_RANDOM;


import java.util.*;

// 덩치
public class Q10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(Arrays.asList(sc.nextInt(), sc.nextInt()));
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> now = list.get(i);
            int count = 0;
            for(int j=0; j<n; j++){
                if(i == j){
                    continue;
                }
                List<Integer> next = list.get(j);
                if(now.get(0) < next.get(0) && now.get(1) < next.get(1)){
                    count += 1;
                }
            }
            answer.add(count);
        }
        for(int i : answer){
            System.out.print(i+1);
            System.out.print(" ");
        }
    }
}
