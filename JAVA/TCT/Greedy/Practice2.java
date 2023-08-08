package JAVA.TCT.Greedy;

import java.util.*;

// 숫자 카드 게임
public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in1 = scanner.nextLine();
        String[] in11 = in1.split(" ");
        int n = Integer.valueOf(in11[0]);
        int m = Integer.valueOf(in11[1]);
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<n; i++){
            String in2 = scanner.nextLine();
            String[] in22 = in2.split(" ");
            List<Integer> now = new ArrayList<>();
            for(int j=0; j<in22.length; j++){
                now.add(Integer.valueOf(in22[j]));
            }
            map.add(now);
        }
        int answer = 0;
        for(List<Integer> arr : map){
            Collections.sort(arr);
            answer = Math.max(arr.get(0), answer);
        }
        System.out.println(answer);
    }
}
