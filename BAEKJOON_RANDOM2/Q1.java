package BAEKJOON_RANDOM2;


import java.util.*;

// 블로그
public class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int sum = 0;
        int count = 0;
        int max_value = 0;
        int index = 0;
        int answer = 0;
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<n; i++){
            int value = sc.nextInt();
            values.add(value);
            sum += value;
            count += 1;
            if(count == x){
                count -= 1;
                if(max_value == sum){
                    max_value = sum;
                    answer += 1;
                }
                if(max_value < sum){
                    max_value = sum;
                    answer = 1;
                }
                sum -= values.get(index);
                index += 1;
            }
        }
        if(max_value == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max_value);
        System.out.println(answer);
    }
}
