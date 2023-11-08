package BAEKJOON_RANDOM;


import java.util.*;

// 어두운 굴다리
public class Q17 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> pos = new ArrayList<>();
        for(int i=0; i<m; i++){
            pos.add(sc.nextInt());
        }
        int len = pos.get(0);
        for(int i=1; i<m; i++){
            int value = (pos.get(i) - pos.get(i-1))/2;
            if((pos.get(i) - pos.get(i-1)) % 2 == 1){
                value += 1;
            }
            len = Math.max(len, value);
        }
        len = Math.max(len, n-pos.get(m-1));
        System.out.println(len);
    }
}
