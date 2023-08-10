package JAVA.TCT.Implement;

import java.util.*;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int x = (int)(value.charAt(0)-97);
        int y = (int)(value.charAt(1)-49);
        int n = 8;
        int[] dx = {-1, 1, -1, 1, 2, 2, -2, -2};
        int[] dy = {2, 2, -2, -2, 1, -1, 1, -1};
        int answer = 0;
        for(int i=0; i<8; i++){
            int next_x = x+dx[i];
            int next_y = y+dy[i];
            if(next_x < 0 | next_y < 0 | next_x >= n | next_y >= n){
                continue;
            }
            answer += 1;
        }
        System.out.println(answer);
    }
}
