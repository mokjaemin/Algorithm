package BAEKJOON_RANDOM;

import java.util.*;

// 쿠키의 신체 측정
public class Q13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        for(int i=0; i<n; i++){
            String value = sc.next();
            for(int j=0; j<n; j++){
                map[i][j] = value.charAt(j);
            }
        }
        // 심장 찾기
        int[] heart = new int[2];
        boolean success = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == '*'){
                    heart[0] = i+1;
                    heart[1] = j;
                    success = true;
                    break;
                }
            }
            if(success){
                break;
            }
        }
        // 왼팔 길이 측정
        int leftArm = 0;
        for(int i=1; i<n; i++){
            int next_y = heart[1] - i;
            if(next_y < 0){
                break;
            }
            if(map[heart[0]][next_y] == '_'){
                break;
            }
            leftArm += 1;
        }
        // 오른팔 길이 측정
        int rightArm = 0;
        for(int i=1; i<n; i++){
            int next_y = heart[1] + i;
            if(next_y >= n){
                break;
            }
            if(map[heart[0]][next_y] == '_'){
                break;
            }
            rightArm += 1;
        }
        // 몸통 길이 측정
        int body = 0;
        int[] bodyEnd = new int[2];
        for(int i=1; i<n; i++){
            int next_x = heart[0] + i;
            if(next_x >= n){
                break;
            }
            if(map[next_x][heart[1]] == '_'){
                bodyEnd[0] = next_x-1;
                bodyEnd[1] = heart[1];
                break;
            }
            body += 1;
        }
        // 왼쪽 다리 측정
        int leftLeg = 1;
        int[] leftLegStart = {bodyEnd[0]+1, bodyEnd[1]-1};
        for(int i=1; i<n; i++){
            int next_x = leftLegStart[0] + i;
            if(next_x >= n){
                break;
            }
            if(map[next_x][leftLegStart[1]] == '_'){
                break;
            }
            leftLeg += 1;
        }
        // 오른쪽 다리 측정
        int rightLeg = 1;
        int[] rightLegStart = {bodyEnd[0]+1, bodyEnd[1]+1};
        for(int i=1; i<n; i++){
            int next_x = rightLegStart[0] + i;
            if(next_x >= n){
                break;
            }
            if(map[next_x][rightLegStart[1]] == '_'){
                break;
            }
            rightLeg += 1;
        }
        System.out.print(heart[0]+1);
        System.out.print(" ");
        System.out.println(heart[1]+1);
        System.out.print(leftArm);
        System.out.print(" ");
        System.out.print(rightArm);
        System.out.print(" ");
        System.out.print(body);
        System.out.print(" ");
        System.out.print(leftLeg);
        System.out.print(" ");
        System.out.print(rightLeg);
    }
}
