package BAEKJOON_RANDOM2;


import java.util.*;

// 타노스
public class Q6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        int count0 = 0;
        int count1 = 0;
        for(char c : value.toCharArray()){
            count0 += (c == '0') ? 1 : 0;
            count1 += (c == '1') ? 1 : 0;
        }
        count0 /= 2;
        count1 /= 2;
        StringBuilder sb = new StringBuilder();
        for(int i=value.length()-1; i>=0; i--){
            if(value.charAt(i) == '0' && count0 != 0){
                count0 -= 1;
                continue;
            }
            sb.append(value.charAt(i));
        }
        value = sb.reverse().toString();
        sb = new StringBuilder();
        for(int i=0; i<value.length(); i++){
            if(value.charAt(i) == '1' && count1 != 0){
                count1 -= 1;
                continue;
            }
            sb.append(value.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
