package BAEKJOON_RANDOM;

import java.util.*;

// 스위치 켜고 끄기
public class Q15 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] map = new int[n+1];
        for(int i=1; i<=n; i++){
            map[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int sex = sc.nextInt();
            int num = sc.nextInt();
            // 남
            if(sex == 1){
                for(int j=0; j<n+1; j+=num){
                    map[j] = map[j] == 0 ? 1 : 0;
                }
            }
            // 여
            else{
                map[num] = map[num] == 0 ? 1 : 0;
                int left = num-1;
                int right = num+1;
                while(true){
                    if(left <= 0 | right >= n+1){
                        break;
                    }
                    if(map[left] == map[right]){
                        map[left] = map[left] == 0 ? 1 : 0;
                        map[right] = map[right] == 0 ? 1 : 0;
                    }
                    else{
                        break;
                    }
                    left -= 1;
                    right += 1;
                }
            }
        }
        int count = 0;
        for(int j=1; j<n+1; j++){
            System.out.print(map[j]);
            System.out.print(" ");
            count += 1;
            if(count == 20 && j != n){
                count = 0;
                System.out.println("");
            }
        }
    }
}
