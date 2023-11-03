package BAEKJOON_RANDOM;


import java.util.Scanner;

// 벌집
public class Q4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long sum = 1;
        int index = 1;
        while(true){
            if(n <= sum){
                System.out.println(index);
                break;
            }
            sum += 6*index;
            index += 1;
        }
    }
}
