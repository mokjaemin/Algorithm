package BAEKJOON_RANDOM;

import java.util.Scanner;

// 돌게임
public class Q7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n % 2 == 1){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }
}
