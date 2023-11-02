package Softeer2_3;

import java.util.*;

public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<n; i++){
            values.add(sc.nextInt());
        }
        List<Double> answer = new ArrayList<>();
        for(int i=0; i<k; i++){
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int sum = 0;
            for(int j=x; j<=y; j++){
                sum += values.get(j);
            }
            answer.add(sum/(double)(y-x+1));
        }
        for(double a : answer){
            System.out.println(Math.round(a*100.0)/100.0);
        }
    }
}
